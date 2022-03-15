package com.example.demo.service;

import com.example.demo.dto.EmpRequest;
import com.example.demo.repo.EmpRepository;
import com.example.demo.repo.ManagerRepository;
import com.example.demo.utils.AppConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.apache.catalina.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService
{
    private final Logger logger =
            LoggerFactory.getLogger(KafkaConsumerService.class);

    @Autowired
    EmpRepository empRepository;

    @Autowired
    ManagerRepository managerRepository;

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void consume(String message)
    {
        logger.info(String.format("Message recieved -> %s", message));
        try {
            EmpRequest empRequest = new ObjectMapper().readValue(message, EmpRequest.class);
            Manager manager = Manager.builder().name(empRequest.getName()).salary(empRequest.getSalary())
                    .email(empRequest.getEmail()).city(empRequest.getCity())
                    .build();
          
            managerRepository.save(manager);
           
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       
    }
}
