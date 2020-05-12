package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dto.ChangeUserDto;
import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.models.FileInfo;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.repositories.VideoRepository;

import java.util.Optional;

@Component
public class ChangeProfileImpl implements ChangeProfile {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private FileStorageService fileStorageService;


    @Override
    public void changeProfile(ChangeUserDto form, Long id) {
        Optional<User> userToUpdate = usersRepository.findById(id);
        MultipartFile file = form.getImg();
        FileInfo fileForUpdate;
        if (userToUpdate.isPresent()) {
            User user = userToUpdate.get();
            if (file != null){
                fileForUpdate =  fileStorageService.saveFile(file);
            } else {
                fileForUpdate = user.getImg();
            }
            user.setName(form.getName());
            user.setAbout(form.getAbout());
            user.setImg(fileForUpdate);

            usersRepository.save(user);
//            sessionBean.setUser(user);
        }

    }
}