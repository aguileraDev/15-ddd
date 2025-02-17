package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.Identity;

public class ProjectId extends Identity {

    public ProjectId(){
        super();
    }

    private ProjectId(String id) {
        super(id);
    }

    public static ProjectId of(String id) {
        return new ProjectId(id);
    }
}
