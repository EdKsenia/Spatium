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
        private Long status;
        private String extendStatus;
        private String channel;
        private double cost;
        private Long dateSend;
        private Long dateCreate;
    }
}
