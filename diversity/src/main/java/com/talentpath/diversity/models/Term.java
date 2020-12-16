package com.talentpath.diversity.models;

import java.util.Objects;

public class Term {

    Integer termId;
    Person person;
    Integer termStart;
    Integer termEnd;
    String region;
    Position position;
    Party party;
    Integer year;

    public Term() {}

    public Term(Person person, Integer termStart, Integer termEnd, String region, Position position, Party party, Integer year) {
        this.termId = -1;
        this.person = person;
        this.termStart = termStart;
        this.termEnd = termEnd;
        this.region = region;
        this.position = position;
        this.party = party;
        this.year = year;
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

    public Party getParty() { return party; }

    public void setParty(Party party) { this.party = party; }

    public Integer getYear() { return year; }

    public void setYear(Integer year) { this.year = year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term = (Term) o;

        if (!Objects.equals(person, term.person)) return false;
        if (!Objects.equals(termStart, term.termStart)) return false;
        if (!Objects.equals(termEnd, term.termEnd)) return false;
        if (!Objects.equals(region, term.region)) return false;
        if (!Objects.equals(party, term.party)) return false;
        if (!Objects.equals(year, term.year)) return false;
        return position == term.position;
    }

    @Override
    public int hashCode() {
        int result = person != null ? person.hashCode() : 0;
        result = 31 * result + (termStart != null ? termStart.hashCode() : 0);
        result = 31 * result + (termEnd != null ? termEnd.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (party != null ? party.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode(): 0);
        return result;
    }
}
