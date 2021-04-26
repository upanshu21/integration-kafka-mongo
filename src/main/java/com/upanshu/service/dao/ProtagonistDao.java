package com.upanshu.service.dao;

import com.upanshu.service.event.Protagonist;
import com.upanshu.service.event.database.ProtagonistInformation;
import com.upanshu.service.repository.ProtagonistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProtagonistDao {

    private static final Logger logger = LoggerFactory.getLogger(Protagonist.class);

    private final ProtagonistRepository dataBaseObject;

    public ProtagonistDao(ProtagonistRepository dataBaseObject) {
        this.dataBaseObject = dataBaseObject;
    }

    public void insertProtagonistData(ProtagonistInformation protagonist) {
        try {
           dataBaseObject.save(protagonist);
           logger.info("Protagonist information successfully saved to database");
        } catch (Exception e) {
            logger.error("Could not save Protagonist information to database");
        }
    }

    public Optional<List<ProtagonistInformation>> getAllProtagonist() {
        try {
            return Optional.of(dataBaseObject.findAll());
        } catch (Exception e) {
            return Optional.empty();
        }

    }
}
