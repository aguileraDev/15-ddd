package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;


public class ProjectActivated extends DomainEvent {
    private final String projectId;

    public ProjectActivated(String projectId, String description) {
        super(EventsEnum.PROJECT_ACTIVATED.name());
        this.projectId = projectId;

    }

    public String getProjectId() {
        return projectId;
    }


}
