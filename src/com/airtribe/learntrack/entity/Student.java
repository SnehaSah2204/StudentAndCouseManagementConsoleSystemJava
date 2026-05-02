package com.airtribe.learntrack.entity;


import static com.airtribe.learntrack.util.AutoIdGenerator.generatedStudentId;

public class Student extends Person {
    private String batch;
    private boolean active;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String email, String batch, boolean active) {
        super(generatedStudentId(), firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public Student( String firstName, String lastName, String batch, boolean active) {
        super(generatedStudentId(), firstName, lastName);
        this.batch = batch;
        this.active = active;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getDisplayName(){return getFirstName()+" "+getLastName();}
}
