package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.MasterDataService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/masterdata")
public class MasterDataController {

	@Autowired
	@Qualifier("MONGO_SERVICE")
	MasterDataService masterdataservice;

	@ApiOperation(value = "Get Advertisement")
	@GetMapping(value = "/advertise/category", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Category> getAdvertiseCategory() {
		List<Category> cateList = masterdataservice.getAdvertiseCategory();
		return cateList;
	}

	@ApiOperation(value = "Create Advertisement Category")
	@PostMapping(value = "/advertise/category", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category categoryResp = masterdataservice.createCategory(category);
		return new ResponseEntity<Category>(categoryResp, HttpStatus.CREATED);
	}

	@ApiOperation(value = "get Status")
	@GetMapping(value = "/advertise/status", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Status> getStatus() {
		return masterdataservice.getStatus();
	}

	@ApiOperation(value = "Create Status Category")
	@PostMapping(value = "/advertise/status", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody ResponseEntity<Status> createStatus(@RequestBody Status status) {
		Status statusResp = masterdataservice.createStatus(status);
		return new ResponseEntity<Status>(statusResp, HttpStatus.CREATED);
	}
}
