package com.arknova.zoo_administrator.domain.zoological.entities;

import com.arknova.shared.domain.generic.Entity;
import com.arknova.zoo_administrator.domain.zoological.Zoological;
import com.arknova.zoo_administrator.domain.zoological.values.BonusPoint;
import com.arknova.zoo_administrator.domain.zoological.values.Description;
import com.arknova.zoo_administrator.domain.zoological.values.IsActive;
import com.arknova.zoo_administrator.domain.zoological.values.Name;
import com.arknova.zoo_administrator.domain.zoological.values.ProjectId;
import com.arknova.zoo_administrator.domain.zoological.values.Requirement;
import com.arknova.zoo_administrator.domain.zoological.values.Reward;


public class Project extends Entity<ProjectId> {
    private Name name;
    private Description description;
    private Requirement requirements;
    private Reward reward;
    private BonusPoint bonusPoint;
    private IsActive isActive;

    public Project(ProjectId identity, Name name, Description description, Requirement requirements, Reward reward, BonusPoint bonusPoint, IsActive isActive) {
        super(identity);
        this.name = name;
        this.description = description;
        this.requirements = requirements;
        this.reward= reward;
        this.isActive = isActive;
        this.bonusPoint = bonusPoint;
    }

    public Project(Name name, Description description, Reward reward) {
        super(new ProjectId());
        this.name = name;
        this.description = description;
        this.requirements = Requirement.of(0);
        this.reward = reward;
        this.isActive = IsActive.of(false);
        this.bonusPoint = BonusPoint.of(0);
    }

    public void checkRequeriments(Zoological zoological){
        if(zoological.getAnimals().size() > requirements.getValue() && zoological.getTotalAttractive().getValue() > 15 ){
            this.isActive = IsActive.of(true);
            setBonusPoint(BonusPoint.of((int) (zoological.getAnimals().size() * 0.15)));
        }
    }

    public Integer enabled(){
        if (this.isActive.getValue()) {
            return bonusPoint.getValue() / 2;
        }
        return 0;
    }

    // region Getters and Setters


    public BonusPoint getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(BonusPoint bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Requirement getRequirements() {
        return requirements;
    }

    public void setRequirements(Requirement requirements) {
        this.requirements = requirements;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }


    // endregion
}
