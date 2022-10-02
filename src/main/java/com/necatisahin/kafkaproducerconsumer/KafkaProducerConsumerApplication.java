package com.necatisahin.kafkaproducerconsumer;

import com.necatisahin.kafkaproducerconsumer.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaProducerConsumerApplication {

    private final static String TOPIC_NAME="necatisahin";
    private final static String GROUP_ID="necatisahin-1";

    public Employee employeeFromTopic = null;

    @KafkaListener(topics = TOPIC_NAME, groupId=GROUP_ID)
    public Employee getJsonMsgFromTopic(Employee user) {
        employeeFromTopic = user;
        return employeeFromTopic;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerConsumerApplication.class, args);
    }

}
