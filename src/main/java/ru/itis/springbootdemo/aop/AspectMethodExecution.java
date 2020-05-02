package ru.itis.springbootdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Aspect
@Component
@Slf4j
public class AspectMethodExecution {

//    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(public * ru.itis.springbootdemo.service.*.*(..))")
    public void callAtMyServicePublic() { }

    @Before("callAtMyServicePublic()")
    public void beforeCallAtMethod1(JoinPoint joinPoint) {
        LocalDateTime time = LocalDateTime.now();
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\.[a-zA-Z]+\\(.*\\)");
        Matcher matcher = pattern.matcher(joinPoint.toString());
        matcher.find();
        String method = matcher.group();
        log.info("Начало:" + time + ". Метод: " + method);

    }

    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint joinPoint) {
        LocalDateTime time = LocalDateTime.now();
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\.[a-zA-Z]+\\(.*\\)");
        Matcher matcher = pattern.matcher(joinPoint.toString());
        matcher.find();
        String method = matcher.group();
        log.info("Окончание:" + time + ". Метод: " + method);

    }
}
