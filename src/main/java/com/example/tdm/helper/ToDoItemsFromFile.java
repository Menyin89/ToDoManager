package com.example.tdm.helper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

//Helper class to import initial items from ToDoItems.json
@Service
public class ToDoItemsFromFile {

    private Integer userId;

    private String name;

    public List<ToDoItemsFromFile> read(String fileToImport) throws IOException {
        return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
                readValue(new FileInputStream(fileToImport), new TypeReference<List<ToDoItemsFromFile>>() {});
    }

    protected ToDoItemsFromFile() {}

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
