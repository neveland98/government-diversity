package com.talentpath.diversity.models;

public class Term {

    Integer termId;
    Person person;
    Integer termStart;
    Integer termEnd;
    String region;
    Position position;

    public Term() {}

    public Term(Person person, Integer termStart, Integer termEnd, String region, Position position) {
        this.termId = -1;
        this.person = person;
        this.termStart = termStart;
        this.termEnd = termEnd;
        this.region = region;
        this.position = position;
    }

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getTermStart() {
        return termStart;
    }

    public void setTermStart(Integer termStart) {
        this.termStart = termStart;
    }

    public Integer getTermEnd() {
        return termEnd;
    }

    public void setTermEnd(Integer termEnd) {
        this.termEnd = termEnd;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
