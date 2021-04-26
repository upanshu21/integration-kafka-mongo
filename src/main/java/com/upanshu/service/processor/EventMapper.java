package com.upanshu.service.processor;

import com.upanshu.service.event.Protagonist;
import com.upanshu.service.event.database.ProtagonistInformation;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public ProtagonistInformation mapProtagonistToProtagonistInformation(Protagonist protagonist) {
        ProtagonistInformation protagonistInformation = new ProtagonistInformation();
        protagonistInformation.setCharacterName(protagonist.getCharacterName());
        protagonistInformation.setShowName(protagonist.getShowName());
        protagonistInformation.setPower(protagonist.getPower());
        protagonistInformation.setStillOnAir(protagonist.isStillOnAir());
        return protagonistInformation;
    }
}
