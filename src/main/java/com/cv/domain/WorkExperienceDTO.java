package com.cv.domain;

import lombok.Data;

@Data
public class WorkExperienceDTO {
    private String title;
    private String company;
    private String from;
    private String to;
    private Boolean current;
    private String description;
}
