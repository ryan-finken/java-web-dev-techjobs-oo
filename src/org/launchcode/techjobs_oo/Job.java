package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(
            String name,
            Employer employer,
            Location location,
            PositionType positionType,
            CoreCompetency coreCompetency
    ) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Custom equals, hashCode, and toString methods:

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        // assignment doesn't specify what "empty" means, so here's my definition:
        //      a field is empty if it is null or its string representation is an empty string
        boolean nameIsEmpty = getName() == null || getName().equals("");
        boolean employerIsEmpty = getEmployer() == null || getEmployer().getValue() == null || getEmployer().getValue().equals("");
        boolean locationIsEmpty = getLocation() == null || getLocation().getValue() == null || getLocation().getValue().equals("");
        boolean posTypeIsEmpty = getPositionType() == null || getPositionType().getValue() == null || getPositionType().getValue().equals("");
        boolean coreCompIsEmpty = getCoreCompetency() == null || getCoreCompetency().getValue() == null || getCoreCompetency().getValue().equals("");

        if (nameIsEmpty && employerIsEmpty && locationIsEmpty && posTypeIsEmpty && coreCompIsEmpty) {
            return "\nOOPS! This job does not seem to exist.\n";
        } else {
            String idLine = "ID: " + getId() + "\n";
            String nameLine = "Name: ";
            String employerLine = "Employer: ";
            String locationLine = "Location: ";
            String posTypeLine = "Position Type: ";
            String coreCompLine = "Core Competency: ";
            String emptyFieldWarning = "Data not available";

            // for each field, check if empty, and if so, display warning. otherwise, display field
            if (nameIsEmpty) {
                nameLine += emptyFieldWarning + "\n";
            } else {
                nameLine += getName() + "\n";
            }
            if (employerIsEmpty) {
                employerLine += emptyFieldWarning + "\n";
            } else {
                employerLine += getEmployer() + "\n";
            }
            if (locationIsEmpty) {
                locationLine += emptyFieldWarning + "\n";
            } else {
                locationLine += getLocation() + "\n";
            }
            if (posTypeIsEmpty) {
                posTypeLine += emptyFieldWarning + "\n";
            } else {
                posTypeLine += getPositionType() + "\n";
            }
            if (coreCompIsEmpty) {
                coreCompLine += emptyFieldWarning + "\n";
            } else {
                coreCompLine += getCoreCompetency() + "\n";
            }
            return "\n" + idLine + nameLine + employerLine + locationLine + posTypeLine + coreCompLine + "\n";
        }


    }

    // Getters and setters:

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
