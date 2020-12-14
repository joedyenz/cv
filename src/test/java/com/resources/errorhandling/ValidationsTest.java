package com.resources.errorhandling;

import com.resources.controller.ResourcesController;
import com.resources.domain.CreateStoryResponse;
import com.resources.domain.StoryRequestDTO;
import io.micrometer.core.instrument.config.validate.Validated;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationsTest {

    @InjectMocks
    private Validations validations;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }



}
