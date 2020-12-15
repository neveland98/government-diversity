package com.talentpath.diversity.models;

public class Term {

    Integer termId;
    Person person;
    Integer termStart;
    Integer termEnd;
    String region;
    Position position;
    Party party;

    public Term() {}

    public Term(Person person, Integer termStart, Integer termEnd, String region, Position position, Party party) {
        this.termId = -1;
        this.person = person;
        this.termStart = termStart;
        this.termEnd = termEnd;
        this.region = region;
        this.position = position;
        this.party = party;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term = (Term) o;

        if (person != null ? !person.equals(term.person) : term.person != null) return false;
        if (termStart != null ? !termStart.equals(term.termStart) : term.termStart != null) return false;
        if (termEnd != null ? !termEnd.equals(term.termEnd) : term.termEnd != null) return false;
        if (region != null ? !region.equals(term.region) : term.region != null) return false;
        if (party != null ? !party.equals(term.party) : term.party != null) return false;
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
        return result;
    }
}
