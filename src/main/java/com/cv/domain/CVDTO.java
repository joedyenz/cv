package com.cv.domain;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

@Data
public class CVDTO {

	private String id;
	private String firstName;
    private String lastName;
    private String job;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;
    private List<SkillDTO> skills;
    private List<LanguageDTO> languages;
    private List<WorkExperienceDTO> workExperience;
    private List<EducationDTO> education;
    private List<ChallengeDTO> challenges;
    private SocialMediaDTO socialMedia;
    private ConfigDTO config;

}//END CLASS
