package ru.itis.springbootdemo.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.models.Role;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .born(form.getBorn())
                .about(form.getAbout())
                .createdAt(LocalDateTime.now())
                .state(State.NOT_CONFIRMED)
                .role(Role.USER)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        usersRepository.save(user);


        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
        Map<String, Object> root = new HashMap<>();
        root.put("username", user.getName());
        root.put("confirmCode", user.getConfirmCode());
        Template temp = null;
        try {
            temp = cfg.getTemplate("mail.ftl");
            Writer out = new OutputStreamWriter(System.out);
            temp.process(root, out);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        Template finalTemp = temp;
        executorService.submit(() ->
        {
            try {
                emailService.sendMail("Confirm", FreeMarkerTemplateUtils.processTemplateIntoString(finalTemp, root), user.getEmail());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        });
    }
}
