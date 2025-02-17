package com.arknova.shared.domain.generic;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public abstract class DomainActionsContainer {
    protected Set<Consumer<? super DomainEvent>> actions = new HashSet<>();

    protected void add(final Consumer<? super DomainEvent> action) {
        actions.add(action);
    }
}
