package com.cv.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cv")
public class CVModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ObjectId id;
    private String firstName;
    private String lastName;
    private String job;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;
    private List<SkillModel> skills;
    private List<LanguageModel> languages;
    private List<WorkExperienceModel> workerExperience;
    private List<EducationModel> education;
    private List<ChallengeModel> challenges;
    private SocialMediaModel socialMedia;
    private ConfigModel config;
}
