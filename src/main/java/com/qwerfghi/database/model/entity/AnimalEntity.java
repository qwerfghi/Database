package com.qwerfghi.database.model.entity;

import javax.persistence.*;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "animal", schema = "hostel")
public class AnimalEntity {
    private int idanimal;
    private OwnerEntity owner;
    private String animalName;
    private AnimalType animalType;
    private byte age;
    private boolean vetInspection;
    private boolean zootaxi;
    private boolean cut;
    private String notice;
    private int idowner;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idanimal")
    public int getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(int idanimal) {
        this.idanimal = idanimal;
    }

    @Basic
    @Column(name = "animal_name")
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Column(name = "animal_kind")
    @Convert(converter = AnimalEntity.AnimalTypeConverter.class)
    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Basic
    @Column(name = "age")
    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Basic
    @Column(name = "vet_inspection")
    public boolean getVetInspection() {
        return vetInspection;
    }

    public void setVetInspection(boolean vetInspection) {
        this.vetInspection = vetInspection;
    }

    @Basic
    @Column(name = "zootaxi")
    public boolean getZootaxi() {
        return zootaxi;
    }

    public void setZootaxi(boolean zootaxi) {
        this.zootaxi = zootaxi;
    }

    @Basic
    @Column(name = "cut")
    public boolean getCut() {
        return cut;
    }

    public void setCut(boolean cut) {
        this.cut = cut;
    }

    @Basic
    @Column(name = "notice")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalEntity that = (AnimalEntity) o;

        if (idanimal != that.idanimal) return false;
        if (age != that.age) return false;
        if (vetInspection != that.vetInspection) return false;
        if (zootaxi != that.zootaxi) return false;
        if (cut != that.cut) return false;
        if (!owner.equals(that.owner)) return false;
        if (!animalName.equals(that.animalName)) return false;
        if (animalType != that.animalType) return false;
        return notice.equals(that.notice);
    }

    @Override
    public int hashCode() {
        int result = idanimal;
        result = 31 * result + owner.hashCode();
        result = 31 * result + animalName.hashCode();
        result = 31 * result + animalType.hashCode();
        result = 31 * result + (int) age;
        result = 31 * result + (vetInspection ? 1 : 0);
        result = 31 * result + (zootaxi ? 1 : 0);
        result = 31 * result + (cut ? 1 : 0);
        result = 31 * result + notice.hashCode();
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idowner", foreignKey = @ForeignKey(name = "fk_owner"))
    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    @Transient
    public int getIdowner() {
        return owner.getIdowner();
    }

    @Converter
    public static class AnimalTypeConverter implements AttributeConverter<AnimalType, String> {

        public String convertToDatabaseColumn(AnimalType value) {
            if (value == null) {
                return null;
            }
            return value.getAnimalType();
        }

        @Override
        public AnimalType convertToEntityAttribute(String s) {
            if (s == null) {
                return null;
            }
            return AnimalType.fromCode(s);
        }
    }
}