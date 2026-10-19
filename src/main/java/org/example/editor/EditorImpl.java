package org.example.editor;

import org.example.exception.ArrayException;
import org.example.publisher.EventManager;
import org.example.publisher.EventManagerImpl;

import java.io.File;
import java.util.EventListener;

public class EditorImpl implements Editor{
    public EventManager events;
    private File file;

    public EditorImpl() {
        this.events = new EventManagerImpl("open", "save");
    }
    @Override
    public void openFile(String filePath) throws ArrayException {
        this.file = new File(filePath);
        events.notify("open", file);
    }
    @Override
    public void saveFile() throws ArrayException {
        if (this.file == null) {
            throw new ArrayException("Please open a file first.");
        }
        events.notify("save", file);
    }
}
