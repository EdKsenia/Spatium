package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Video;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoSearchResults {
    private List<Video> videos;
    private Integer count;
}
