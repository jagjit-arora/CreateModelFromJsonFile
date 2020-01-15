package com.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.service.Producer;

@RestController
@RequestMapping("/patient")
public class KafkaController {
	
	@Autowired
	Producer producer;
	@GetMapping("/produce")
	public String producer(@RequestParam("message") String message) throws Exception {
		producer.read();
		producer.test();
		return "this is the message:"+message;
	}
	

}
