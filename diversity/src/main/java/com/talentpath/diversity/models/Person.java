package com.talentpath.diversity.models;

public class Person {

    Integer id;
    String firstName;
    String lastName;
    Integer birthYear;
    Gender gender;
    Race race;
    Party party;

    public Person() {}

    /**
     * Testing constructor only.
     * @param firstName First name.
     * @param lastName Last name.
     * @param birthYear Birth year.
     * @param gender Gender.
     * @param race Race.
     * @param party Party.
     */
    public Person(String firstName,String lastName,Integer birthYear,Gender gender,Race race,Party party) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.race = race;
        this.party = party;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (birthYear != null ? !birthYear.equals(person.birthYear) : person.birthYear != null) return false;
        if (gender != person.gender) return false;
        if (race != person.race) return false;
        return party == person.party;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthYear != null ? birthYear.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (race != null ? race.hashCode() : 0);
        result = 31 * result + (party != null ? party.hashCode() : 0);
        return result;
    }
}


