package com.cv.controller;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import com.cv.domain.CreateCVResponse;
import com.cv.domain.CVDTO;
import com.cv.services.CVService;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/api/v1")
@Configuration
@RestController
@Slf4j
public class CVController {
	
	private final CVService CVService;

	public CVController(CVService CVService) {
		this.CVService = CVService;
	}

	@GetMapping(value="/cv/{id}", produces="application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public CVDTO getAllStories(@PathVariable String id){
		log.info("Calling Get Operation");
		return CVService.getStories(id);
	}//END GET
   
	@PostMapping(value = "/cv")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CreateCVResponse> postStories(
			@ApiParam(value = "Post story request", required = true) @RequestBody CVDTO request) {
		CreateCVResponse response = CVService.createStory(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}//END POST
  
  @PutMapping(value = "/cv/{id}", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public CVDTO updateStory(@RequestBody CVDTO request, @PathVariable String id) {
		return CVService.updateStory(request, id);
	}//END PUT
  
	@DeleteMapping(value="/cv/{id}", produces = "application/json")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void DeleteStory(@PathVariable String id) {
		CVService.deleteStory(id);
	}//END DELETE
	
}//END CLASS
