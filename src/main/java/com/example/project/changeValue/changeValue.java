package com.example.project.changeValue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class changeValue {

    String dateStr;
    String formattedDate;

    public static String formatDate(String dateStr) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy. M. d");
        LocalDate dateObj = LocalDate.parse(dateStr, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return dateObj.format(outputFormatter);
    }


}
