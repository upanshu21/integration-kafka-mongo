package com.upanshu.service.event.database;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProtagonistInformation {

    private String characterName;
    private String showName;
    private String power;
    private boolean isStillOnAir;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public boolean isStillOnAir() {
        return isStillOnAir;
    }

    public void setStillOnAir(boolean isStillOnAir) {
        this.isStillOnAir = isStillOnAir;
    }
}
