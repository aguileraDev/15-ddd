package com.arknova.zoo_administrator.domain.deck.entities;

import com.arknova.shared.domain.generic.Entity;
import com.arknova.zoo_administrator.domain.deck.values.CardId;
import com.arknova.zoo_administrator.domain.deck.values.Description;
import com.arknova.zoo_administrator.domain.deck.values.Requirement;
import com.arknova.zoo_administrator.domain.deck.values.Skill;
import com.arknova.zoo_administrator.domain.deck.values.Type;

import java.util.ArrayList;
import java.util.List;

public class Card extends Entity<CardId> {
    private Type type;
    private Description description;
    private List<Skill> skills;
    private List<Requirement> requirements;

    public Card(CardId identity, Type type, Description description, List<Skill> skills, List<Requirement> requirements) {
        super(identity);
        this.type = type;
        this.description = description;
        this.skills = skills;
        this.requirements = requirements;
    }

    public Card(Type type, Description description) {
        super(new CardId());
        this.type = type;
        this.description = description;
        this.skills = new ArrayList<>();
        this.requirements = new ArrayList<>();
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }
}
