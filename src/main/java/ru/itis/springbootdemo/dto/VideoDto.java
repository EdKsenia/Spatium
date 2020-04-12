package ru.itis.springbootdemo.dto;

        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.springframework.web.multipart.MultipartFile;
        import ru.itis.springbootdemo.models.Channel;
        import ru.itis.springbootdemo.models.User;
        import ru.itis.springbootdemo.models.Video;

        import java.time.LocalDateTime;
        import java.util.List;
        import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoDto {
    private Long id;
    private String name;
    private String description;
    private MultipartFile img;
    private MultipartFile video;
    private Channel channel;
    //
    public static VideoDto from(Video video){
        return VideoDto.builder().
                id(video.getId())
                .name(video.getName())
                .description(video.getDescription())
                .channel(video.getChannel())
                .build();
    }

    public static List<VideoDto> from(List<Video> videos) {
        return videos.stream()
                .map(VideoDto::from)
                .collect(Collectors.toList());
    }


}

