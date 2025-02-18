package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;

public class CreatedZoo extends DomainEvent {
    public CreatedZoo() {
        super(EventsEnum.CREATED_ZOO.name());
    }

}
