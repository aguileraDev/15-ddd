package com.arknova.zoo_administrator.domain.zoological.entities;

import com.arknova.shared.domain.generic.Entity;
import com.arknova.zoo_administrator.domain.zoological.values.Description;
import com.arknova.zoo_administrator.domain.zoological.values.Name;
import com.arknova.zoo_administrator.domain.zoological.values.ProjectId;
import com.arknova.zoo_administrator.domain.zoological.values.Requirement;
import com.arknova.zoo_administrator.domain.zoological.values.Reward;

import java.util.ArrayList;
import java.util.List;

public class Project extends Entity<ProjectId> {
    private Name name;
    private Description description;
    private List<Requirement> requirements;
    private List<Reward> rewards;

    public Project(ProjectId identity, Name name, Description description, List<Requirement> requirements, List<Reward> rewards) {
        super(identity);
        this.name = name;
        this.description = description;
        this.requirements = requirements;
        this.rewards = rewards;
    }

    public Project(Name name, Description description) {
        super(new ProjectId());
        this.name = name;
        this.description = description;
        this.requirements = new ArrayList<>();
        this.rewards = new ArrayList<>();
    }
}
