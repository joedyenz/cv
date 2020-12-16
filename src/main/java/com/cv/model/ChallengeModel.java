package com.cv.model;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ChallengeModel {
    private String name;
    private Date date;
    private String description;
    private String url;
}
