package org.example;

import java.util.*;

public class BankEmployee {
    private int id;
    private String name;
    private Set<String> skills;
    private Map<String, String> achievements;

    public BankEmployee(int id, String name, Set<String> skills, Map<String, String> achievements) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.achievements = achievements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Map<String, String> getAchievements() {
        return achievements;
    }

    public void setAchievements(Map<String, String> achievements) {
        this.achievements = achievements;
    }
}
