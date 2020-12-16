package com.cv.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ChallengeDTO {
    private String name;
    private String date;
    private String description;
    private String url;
}
