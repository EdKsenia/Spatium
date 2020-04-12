package ru.itis.springbootdemo.dto;

        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import ru.itis.springbootdemo.models.Video;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoDto {
    private Long id;
    private Long channel;
    private String name;
    private String description;
    private Long img;
    private Long video_file;

    public static VideoDto from(Video video) {
        return VideoDto.builder()
                .id(video.getId())
                .description(video.getDescription())
                .name(video.getName())
                .channel(video.getChannel())
                .img(video.getImg())
                .video_file(video.getVideo())
                .build();
    }


}

