package com.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Patient;

@Service
public class Producer {
	@Autowired
	private KafkaTemplate<String, Patient> kafkaTemplate;

	String kafkaTopic = "patientnew";
	ObjectMapper mapper = new ObjectMapper();

	public void test() throws JsonProcessingException {
		Patient p = new Patient(1, "John", 19928399, "male");
		System.out.println(mapper.writeValueAsString(p));
	}
	public void read() throws Exception {
		File file=new File(Producer.class.getClassLoader().getResource("models/model1.json").getFile());
		Patient k=mapper.readValue(file, Patient.class);
		System.out.println(k.toString());
	}
	
	public void send() {
		Patient p = new Patient(1, "John", 19928399, "male");
		kafkaTemplate.send(kafkaTopic, 0, p.getPatientId() + "", p);
		System.out.println(p.toString());
		Patient q = new Patient(2, "John", 19928399, "male");
		kafkaTemplate.send(kafkaTopic, 1, q.getPatientId() + "", q);
		System.out.println(q.toString());

	}

}
