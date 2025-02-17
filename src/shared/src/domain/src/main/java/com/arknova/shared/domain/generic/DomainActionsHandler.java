package com.arknova.shared.domain.generic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class DomainActionsHandler {
    private final List<DomainEvent> events = new LinkedList<>();
    private final Map<String, AtomicLong> versions = new ConcurrentHashMap<>();
    private final Set<Consumer<? super DomainEvent>> actions = new HashSet<>();


    private void handle(final DomainEvent event, final Consumer<? super DomainEvent> action){
        try{
            action.accept(event);
            final long version = increaseVersion(event);
            event.setVersion(version);

        }catch (ClassCastException ignored){}
    }

    public void apply(final DomainEvent event){
        events.add(event);
        actions.forEach(action -> handle(event, action));
    }

    public List<DomainEvent> getEvents() {
        return events;
    }

    public void subscribe(final DomainActionsContainer actionsContainer){
        actions.addAll(actionsContainer.actions);
    }

    private long increaseVersion(final DomainEvent event){
        final AtomicLong version = versions.get(event.getName());
        final long newVersion = version != null ? version.incrementAndGet() : event.getVersion();
        versions.put(event.getName(), new AtomicLong(newVersion));
        return newVersion;
    }


}
