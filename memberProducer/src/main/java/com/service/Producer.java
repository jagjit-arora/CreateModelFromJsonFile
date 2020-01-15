package com.service;

import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Patient;

@Service
public class Producer {
	@Autowired
	private KafkaTemplate<String, Patient> kafkaTemplate;

	String kafkaTopic = "patientnew";
	ObjectMapper mapper = new ObjectMapper();

	public void test() throws Exception {
		Patient p = new Patient(1, "John", 19928399, "male");
		File file=new File((Producer.class.getClassLoader().getResource("").getPath()+"models/model2.json"));
		System.out.println(file.createNewFile());
		mapper.writeValue(file, p);
		System.out.println(mapper.writeValueAsString(p));
	}
	public void read() throws Exception {
		File file=new File(this.getClass().getClassLoader().getResource("models/model2.json").getPath());
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
