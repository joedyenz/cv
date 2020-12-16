package com.cv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cv.configuration.OrikaConfiguration;
import org.springframework.stereotype.Service;

import com.cv.domain.CreateCVResponse;
import com.cv.model.CVModel;
import com.cv.domain.CVDTO;
import com.cv.repository.CVRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CVServiceImpl implements CVService {

	private final CVRepository CVRepository;
	private final OrikaConfiguration mapper;

	public CVServiceImpl(CVRepository CVRepository, OrikaConfiguration orikaConfiguration) {
		this.CVRepository = CVRepository;
		this.mapper = orikaConfiguration;
	}

	@Override
	public CreateCVResponse createStory(CVDTO CVDTO) {
		CVDTO.setId(null);
		CVModel CVModel = mapper.map(CVDTO, CVModel.class);
		CreateCVResponse response = new CreateCVResponse();
		response.setId(CVRepository.save(CVModel).getId().toString());
		log.info("Story saved with id: {}", response.getId());
		return response;
	}//END createStory

	@Override
	public CVDTO getStories() {

		List<CVModel> CVList = CVRepository.findAll();
		CVDTO response = mapper.map(CVList.get(0), CVDTO.class);
		log.info("Consulted successfully on mongoDB");
		return response;
	}//END getStories
  
	@Override
	public CVDTO updateStory(CVDTO CVDTO, String id) {
		CVDTO.setId(id);
		CVModel CVModel;
		if (CVRepository.existsById(id)) {
			CVModel = mapper.map(CVDTO, CVModel.class);
			CVRepository.save(CVModel);
		}
		return CVDTO;
	}//END updateStory
	
	@Override
	public void deleteStory(String id) {
		if (CVRepository.existsById(id)) {
			CVRepository.deleteById(id);
		}
	}//End deleteStory

}// End class
