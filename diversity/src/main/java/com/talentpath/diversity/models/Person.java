package com.talentpath.diversity.models;

public class Person {

    Integer id;
    String name;
    Integer birthYear;
    Gender gender;
    Race race;

    public Person() {}

    /**
     * Testing constructor only.
     * @param name Full name.
     * @param birthYear Birth year.
     * @param gender Gender.
     * @param race Race.
     */
    public Person(String name,Integer birthYear,Gender gender,Race race) {
        this.id = -1;
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.race = race;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (birthYear != null ? !birthYear.equals(person.birthYear) : person.birthYear != null) return false;
        if (gender != person.gender) return false;
        return race == person.race;
    }

    @Override
    public int hashCode() {
        int result = name != null? name.hashCode() : 0;
        result = 31 * result + (birthYear != null ? birthYear.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (race != null ? race.hashCode() : 0);
        return result;
    }
}


