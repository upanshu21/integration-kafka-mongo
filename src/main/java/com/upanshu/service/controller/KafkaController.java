package com.upanshu.service.controller;

import com.upanshu.service.dao.ProtagonistDao;
import com.upanshu.service.event.Protagonist;
import com.upanshu.service.event.database.ProtagonistInformation;
import com.upanshu.service.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaProducer producer;
    private final ProtagonistDao protagonistDao;

    public KafkaController(KafkaProducer producer, ProtagonistDao protagonistDao) {
        this.producer = producer;
        this.protagonistDao = protagonistDao;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Protagonist protagonistInformation) {
        logger.info("Received request");
        producer.sendMessage(protagonistInformation);
    }

    @GetMapping(value = "/all/events")
    public List<ProtagonistInformation> getAllProtagonistFromDatabase() {
        Optional<List<ProtagonistInformation>> protagonistInformation = protagonistDao.getAllProtagonist();
        if (!protagonistInformation.isPresent()) {
            logger.debug("No data present in database");
        } else {
            logger.info("Received List of Protagonist data");
        }
        return protagonistInformation.get();
    }

}
