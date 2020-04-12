package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.User;

import javax.mail.Multipart;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelDto {
    private Long id;
    private String name;
    private String about;
    private MultipartFile file;
    private User user;
//
    public static ChannelDto from(Channel channel){
        return ChannelDto.builder().
                id(channel.getId())
                .name(channel.getName())
                .about(channel.getAbout())
                .user(channel.getUser())
                .build();

    }

    public static List<ChannelDto> from(List<Channel> channels) {
        return channels.stream()
                .map(ChannelDto::from)
                .collect(Collectors.toList());
    }
}
