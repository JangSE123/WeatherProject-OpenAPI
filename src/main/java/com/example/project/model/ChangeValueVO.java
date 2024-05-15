package com.example.project.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChangeValueVO {

    public static String getAutoBaseDate() {
        LocalDateTime now = LocalDateTime.now();

        return now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static String getAutoBaseTime() {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HHmm"));
        int minutes = Integer.parseInt(time.substring(2));

        if (minutes >= 30) {
            return time;
        } else {
            LocalDateTime adjustedTime = now.minusHours(1).plusMinutes(30);
            return adjustedTime.format(DateTimeFormatter.ofPattern("HHmm"));
        }
    }
}