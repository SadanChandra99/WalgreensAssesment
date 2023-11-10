package com.walgreens.pcs.assesment.dto;

import java.util.List;

import com.walgreens.pcs.assesment.entity.Assesment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
	
	private List<Assesment> content;
	private int pageNo;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean last;
	

}
