package ru.itis.springbootdemo.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.springbootdemo.models.SmsRequest;
import ru.itis.springbootdemo.models.SmsResponse;

import java.util.Random;

import static sun.misc.Version.println;

@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendMessage(String phone) {
        String message = "Your letter received, expect a response from our experts" ;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth("ksushka.e20@gmail.com", "Wk4U1uWmJMb5bSvcR4zd2kMPoZT8");

        HttpEntity<SmsRequest> request = new HttpEntity<>(
                new SmsRequest(phone, message,"SMS Aero", "DIRECT"), httpHeaders);
        String resourceUrl = "https://gate.smsaero.ru/v2/sms/send";

        ResponseEntity<SmsResponse> response = restTemplate.postForEntity(resourceUrl, request, SmsResponse.class);
    }
}
