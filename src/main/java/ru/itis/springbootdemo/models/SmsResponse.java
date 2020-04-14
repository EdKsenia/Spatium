package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsResponse {
    private Boolean success;
    private Data data;
    private String message;

    class Data {
        private Long id;
        private String from;
        private String number;
        private String text;
        private String channel;
        private Long dateSend;
        private Long dateCreate;
    }
}
