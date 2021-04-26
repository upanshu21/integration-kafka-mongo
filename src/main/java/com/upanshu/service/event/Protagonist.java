package com.upanshu.service.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Protagonist.Builder.class)
public class Protagonist {

    private final String characterName;
    private final String showName;
    private final String power;
    private final boolean isStillOnAir;

    private Protagonist(Builder builder) {
        characterName = builder.characterName;
        showName = builder.showName;
        power = builder.power;
        isStillOnAir = builder.isStillOnAir;

    }

    public String getCharacterName() {
        return characterName;
    }

    public String getShowName() {
        return showName;
    }

    public String getPower() {
        return power;
    }

    public boolean isStillOnAir() {
        return isStillOnAir;
    }

    public static class Builder {
        private String characterName;
        private String showName;
        private String power;
        private boolean isStillOnAir;

        public Builder withCharacterName(String characterName) {
            this.characterName = characterName;
            return this;
        }

        public Builder withShowName(String showName) {
            this.showName = showName;
            return this;
        }

        public Builder withPower(String power) {
            this.power = power;
            return this;
        }

        public Builder withIsStillOnAir(boolean isStillOnAir) {
            this.isStillOnAir = isStillOnAir;
            return this;
        }

        public Protagonist build() {
            return new Protagonist(this);
        }
    }

}
