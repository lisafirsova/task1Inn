package org.example.editor;

import org.example.exception.ArrayException;

public interface Editor {
    void openFile(String filePath) throws ArrayException;
    void saveFile() throws ArrayException;
}
