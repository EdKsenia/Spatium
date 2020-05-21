package ru.itis.springbootdemo.schedulers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.springbootdemo.models.Video;

import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
public class StatisticSchedulers {
    @Autowired
    private SchedulersService schedulersService;


    @Transactional
//    <second> <minute> <hour> <day-of-month> <month> <day-of-week> <year>
    @Scheduled(cron = "0 26 23 ? * MON,THU")
    public void run() {
        List<Video> videos = schedulersService.getLast5();
        log.info("5 последних добавлених записей");
        int i = 1;
        for (Video video : videos) {
            log.info(i + ": В канал " + video.getChannel().getName() + " добавлено " + video.getName());
            i++;
        }
    }
}
