package org.example.publisher;

import org.example.listeners.LogOpenListener;

import java.io.File;
import java.util.*;

public class EventManagerImpl implements EventManager{
    Map<String, List<LogOpenListener>> listeners = new HashMap<>();

    public EventManagerImpl(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    @Override
    public void subscribe(String eventType, LogOpenListener listener) {
        List<LogOpenListener> users = listeners.get(eventType);
        users.add(listener);
    }
    @Override
    public void unsubscribe(String eventType, LogOpenListener listener) {
        List<LogOpenListener> users = listeners.get(eventType);
        users.remove(listener);
    }
    @Override
    public void notify(String eventType, File file) {
        List<LogOpenListener> users = listeners.get(eventType);
        for (LogOpenListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
