package org.example.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;

import java.io.File;

public class LogOpenListener implements EventListener {
    private static final Logger LOGGER = LogManager.getLogger(LogOpenListener.class);
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        LOGGER.info("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}