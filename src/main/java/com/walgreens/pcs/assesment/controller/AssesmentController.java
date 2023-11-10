package com.walgreens.pcs.assesment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walgreens.pcs.assesment.dto.AppConstants;
import com.walgreens.pcs.assesment.dto.PostResponse;
import com.walgreens.pcs.assesment.entity.Assesment;
import com.walgreens.pcs.assesment.service.AssesmentService;

@RestController
@RequestMapping("/assesment")
public class AssesmentController {

	@Autowired
	private AssesmentService assesmentService;
	
	@PostMapping("/")
	public ResponseEntity<Assesment> createAssesment(@RequestBody Assesment assesment){
		Assesment addedAssesment = assesmentService.createAssesment(assesment);
		return new ResponseEntity<Assesment>(addedAssesment, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<PostResponse> getAllAssesments(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize, 
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
			){
		PostResponse response = assesmentService.getAssesments(pageNo, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(response, HttpStatus.OK);
	}
}
