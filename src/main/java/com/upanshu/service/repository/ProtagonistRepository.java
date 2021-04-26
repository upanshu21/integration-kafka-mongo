package com.upanshu.service.repository;

import com.upanshu.service.event.database.ProtagonistInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtagonistRepository extends MongoRepository<ProtagonistInformation, String> {
}
