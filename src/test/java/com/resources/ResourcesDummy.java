package com.resources;

import com.resources.domain.*;
import com.resources.model.Story;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class ResourcesDummy {

    public static List<StoryRequestDTO> getStories() {
        List<StoryRequestDTO> list = new ArrayList<>();
        return list;
    }

    public static List<Story> getDBStories() {
        List<Story> list = new ArrayList<>();
        return list;
    }

    public static StoryRequestDTO updateStory() {
        StoryRequestDTO response = new StoryRequestDTO();
        return response;
    }

    public static Story getStory() {
        Story response = new Story();
        return response;
    }

    public static StoryRequestDTO getStoryRequestDTO() {
        StoryRequestDTO response = new StoryRequestDTO();
        return response;
    }

    public static Story getStoryWithId() {
        Story response = new Story();
        ObjectId myId = new ObjectId();
        response.setId(myId);
        return response;
    }

    public static StoryRequestDTO fullDTO() {
        StoryRequestDTO response = new StoryRequestDTO();
        response.setSprintId("123");
        response.setId("123");
        response.setUserId("123");
        response.setPriority("Low");;
        response.setName("123");
        response.setDescription("123");
        response.setAcceptanceCriteria("123");
        response.setStoryPoints(1);
        response.setProgress(1);
        response.setStartDate("2020-12-12");
        response.setDueDate("2020-12-12");
        response.setCreateDate("2020-12-12");
        response.setStatus(1);
        return response;
    }
}
