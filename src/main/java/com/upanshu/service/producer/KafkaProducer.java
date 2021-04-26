package com.upanshu.service.producer;

import com.upanshu.service.event.Protagonist;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Protagonist protagonist){
        try {
            logger.info("Publishing Protagonist with name: {} ", protagonist.getCharacterName());
            kafkaTemplate.sendDefault(protagonist);
            kafkaTemplate.flush();
            logger.info("Message successfully published to kafka");
        } catch (Exception e) {
            logger.info("Failed to publish message to kafka");
            e.printStackTrace();
        }
    }

}
