package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmpRepository;
import com.example.demo.utils.AppConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaProducerService
{
    private static final Logger logger =
            LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message)
    {
        logger.info(String.format("Message sent -> %s", message));
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
    }

    @Autowired
    EmpRepository empRepository;

    public String createManager(int id) throws JsonProcessingException {

        Optional<Employee> employee = empRepository.findById(id);

        if(employee.isPresent()){
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(employee.get());
            this.kafkaTemplate.send(AppConstants.TOPIC_NAME, json);
            return json;
        }else{
            return "not exist";
        }
    }
}