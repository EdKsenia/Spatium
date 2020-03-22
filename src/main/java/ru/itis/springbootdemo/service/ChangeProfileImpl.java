package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

@Component
public class ChangeProfileImpl implements ChangeProfile {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void changeProfile(SignUpDto form) {
        User user = User.builder()
                .name(form.getName())
                .born(form.getBorn())
                .about(form.getAbout())
                .build();

        usersRepository.save(user);
    }
}