package org.example.publisher;
import org.example.exception.ArrayException;
import org.example.listeners.LogOpenListener;

import java.io.File;
import java.util.*;

public interface EventManager {
    void subscribe(String eventType, LogOpenListener listener) throws ArrayException;
    void unsubscribe(String eventType, LogOpenListener listener) throws ArrayException;
    void notify(String eventType, File file) throws ArrayException;
}
