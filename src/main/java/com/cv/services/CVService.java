package com.cv.services;

import com.cv.domain.CreateCVResponse;
import com.cv.domain.CVDTO;
import java.util.List;

public interface CVService {
	CreateCVResponse createStory(CVDTO story);
	CVDTO getStories(String id);
	void deleteStory(String id);
  	CVDTO updateStory(CVDTO request, String id);
}
