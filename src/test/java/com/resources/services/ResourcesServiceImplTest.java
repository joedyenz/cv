package com.resources.services;

import com.resources.errorhandling.*;
import com.resources.ResourcesDummy;
import com.resources.domain.*;
import com.resources.model.Story;
import com.resources.repository.StoryRepository;
import com.resources.configuration.OrikaConfiguration;
import com.resources.services.ResourcesServiceImpl;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static com.resources.errorhandling.Validations.validationPostPut;

public class ResourcesServiceImplTest {



    @InjectMocks
    private ResourcesServiceImpl resourcesService;

    @Mock
    OrikaConfiguration orikaConfiguration;

    @Mock
    StoryRepository storyRepository;

    @Mock
    Validations validations;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void postServiceSuccessful() throws Exception {
        CreateStoryResponse response = new CreateStoryResponse();
        ObjectId myId = new ObjectId();
        response.setId(myId.toString());
        StoryRequestDTO request = ResourcesDummy.fullDTO();
        Mockito.when(orikaConfiguration.map(Mockito.any(StoryRequestDTO.class),eq(Story.class)))
                .thenReturn(ResourcesDummy.getStory());
        Mockito.when(storyRepository.save(Mockito.any(Story.class)))
                .thenReturn(ResourcesDummy.getStoryWithId());

        CreateStoryResponse result = resourcesService.createStory(request);
        result.setId(myId.toString());
        assertThat(result).isEqualToComparingFieldByField(response);
    }

    @Test
    public void getServiceSuccessful() throws Exception{

        List<StoryRequestDTO> response = new ArrayList<>();
        Mockito.when(storyRepository.findAll())
                .thenReturn(ResourcesDummy.getDBStories());
        Mockito.when(orikaConfiguration.map(Mockito.any(Story.class),eq(StoryRequestDTO.class)))
                .thenReturn(ResourcesDummy.getStoryRequestDTO());
        List<StoryRequestDTO> result = resourcesService.getStories();
        assertThat(result).isEqualTo(response);
    }

    @Test
    public void putServiceSuccessful() throws Exception{

        Mockito.when(storyRepository.existsById(Mockito.anyString()))
                .thenReturn(true);
        Story dbStory = new Story();
        ObjectId myId = new ObjectId();
        dbStory.setUser_id(myId);
        dbStory.setSprint_id(myId);
        Mockito.when(storyRepository.findById(Mockito.anyString()))
                .thenReturn(Optional.of(dbStory));
        Mockito.when(orikaConfiguration.map(Mockito.any(StoryRequestDTO.class),eq(Story.class)))
                .thenReturn(ResourcesDummy.getStory());
        Mockito.when(storyRepository.save(Mockito.any(Story.class)))
                .thenReturn(ResourcesDummy.getStoryWithId());

        String idString = "123";
        StoryRequestDTO request = ResourcesDummy.fullDTO();

        StoryRequestDTO result = resourcesService.updateStory(request,idString);
        assertThat(result).isEqualToComparingFieldByField(request);
    }
}
