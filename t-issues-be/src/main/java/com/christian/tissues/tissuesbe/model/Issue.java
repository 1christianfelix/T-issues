package com.christian.tissues.tissuesbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Issue {

    @Id
    @GeneratedValue
    private Long id;

    private boolean done;
    private LocalDate targetDate;
    private String description;

    @ManyToOne
    private User user;

    public Issue() {}
    
    public Issue(String description, LocalDate targetDate, boolean done, User user) {
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
        this.user = user;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}