package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;


public class ProjectActivated extends DomainEvent {
    private final String projectId;
    private final String description;
    private final String reward;
    private final Integer bonusPoint;


    public ProjectActivated(String projectId, String description, String reward, Integer bonusPoint) {
        super(EventsEnum.PROJECT_ACTIVATED.name());
        this.projectId = projectId;
        this.description = description;
        this.reward = reward;
        this.bonusPoint = bonusPoint;

    }

    public String getProjectId() {
        return projectId;
    }

    public String getDescription() {
        return description;
    }

    public String getReward() {
        return reward;
    }

    public Integer getBonusPoint() {
        return bonusPoint;
    }
}
