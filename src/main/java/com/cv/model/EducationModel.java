package com.cv.model;

import lombok.Data;

import java.util.Date;

@Data
public class EducationModel {
    private String name;
    private String career;
    private Date from;
    private Date to;
    private enum degree {Bachelor, Master, Ph};
}
