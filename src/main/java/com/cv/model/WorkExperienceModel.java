package com.cv.model;

import lombok.Data;

import java.util.Date;

@Data
public class WorkExperienceModel {
    private String title;
    private String company;
    private Date from;
    private Date to;
    private Boolean current;
    private String description;
}
