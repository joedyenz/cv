package com.resources.controller;

import com.resources.ResourcesDummy;
import com.resources.controller.ResourcesController;
import com.resources.domain.*;
import com.resources.services.ResourcesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class ResourcesControllerTest {

    @Mock
    ResourcesService resourcesService;

    @InjectMocks
    private ResourcesController resourcesController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostSuccessful() throws Exception {

        ResponseEntity<CreateStoryResponse> response = new ResponseEntity<>(
                new CreateStoryResponse(), HttpStatus.CREATED);
        StoryRequestDTO request = new StoryRequestDTO();
        Mockito.when(resourcesService.createStory(Mockito.any(StoryRequestDTO.class)))
                .thenReturn(new CreateStoryResponse());
        ResponseEntity<CreateStoryResponse> result = resourcesController.postStories(request);
        assertThat(result.getBody()).isEqualToComparingFieldByField(response.getBody());
    }

    @Test
    public void testGetSuccessful() throws Exception {
        List<StoryRequestDTO> response = new ArrayList<>();
        Mockito.when(resourcesService.getStories()).thenReturn(ResourcesDummy.getStories());
        List<StoryRequestDTO> result = resourcesController.getAllStories();
        assertThat(result).isEqualTo(response);
    }

    @Test
    public void testPutSuccessful() throws Exception {

        StoryRequestDTO response = new StoryRequestDTO();
        String id = "123";
        Mockito.when(resourcesService.updateStory(response, id)).thenReturn(ResourcesDummy.updateStory());
        StoryRequestDTO result = resourcesController.updateStory(response, id);
        assertThat(result).isEqualTo(response);
    }
}
