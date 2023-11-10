package com.walgreens.pcs.assesment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.walgreens.pcs.assesment.dto.PostResponse;
import com.walgreens.pcs.assesment.entity.Assesment;
import com.walgreens.pcs.assesment.repository.AssesmentRepository;

@Service
public class AssesmentService {
	
	@Autowired
	private AssesmentRepository assesmentRepository;
	
	
	public Assesment createAssesment(Assesment assesment) {
		
	
		return assesmentRepository.save(assesment);
	}
	
	
	public PostResponse getAssesments(int pageNo, int pageSize, String sortBy, String sortDir){

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<Assesment> assesments = assesmentRepository.findAll(pageable);

		List<Assesment> listOfAssesments = assesments.getContent();

		
		
		PostResponse postResponse = new PostResponse();
		
		
		postResponse.setContent(listOfAssesments);
		postResponse.setPageNo(pageNo);
		postResponse.setLast(false);
		postResponse.setPageSize(pageSize);
		postResponse.setTotalElements(assesments.getTotalElements());
		postResponse.setLast(assesments.isLast());
		postResponse.setTotalPages(assesments.getTotalPages());
		
		return postResponse;
	}

}
