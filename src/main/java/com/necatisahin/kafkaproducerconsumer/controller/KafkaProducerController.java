package com.necatisahin.kafkaproducerconsumer.controller;

import com.necatisahin.kafkaproducerconsumer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, Object> template;

    private final static String TOPIC_NAME="necatisahin";

    @PostMapping(value = "api/v1/createEmpAndSendJsonToKafkaTopic")
    public String createEmpAndSendJsonToKafkaTopic(
            @RequestParam("id") int id,
            @RequestParam("name") String name) {

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        template.send(TOPIC_NAME, employee);
        return "Json Data published";
    }
}
