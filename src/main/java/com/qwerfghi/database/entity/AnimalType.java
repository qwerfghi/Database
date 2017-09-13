package com.qwerfghi.database.entity;

/**
 * Created by Павел on 22.06.2017.
 */
public enum AnimalType {
    DOG("собака", "для собаки"),
    CAT("кот", "для кота"),
    HAMSTER("хомяк", "для хомяка"),
    TURTLE("черепаха", "для черепахи"),
    SNAKE("змея", "для змеи");

    private final String animalType;
    private final String roomType;

    AnimalType(String animalType, String roomType) {
        this.animalType = animalType;
        this.roomType = roomType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getRoomType() {
        return roomType;
    }

    public static AnimalType fromCode(String value) {
        switch (value) {
            case "собака":
            case "для собаки":
                return DOG;
            case "кот":
            case "для кота":
                return CAT;
            case "хомяк":
            case "для хомяка":
                return HAMSTER;
            case "черепаха":
            case "для черепахи":
                return TURTLE;
            case "змея":
            case "для змеи":
                return SNAKE;
            default:
                return null;
        }
    }
}