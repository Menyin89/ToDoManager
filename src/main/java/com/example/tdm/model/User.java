package com.example.tdm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Person")
public class User {

    @Id
    @Column(name="user_id")
    @JsonProperty("id")
    private Integer id;

    @Column(name="user_name")
    private String userName;

    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<ToDoItem> toDoList = new ArrayList<>();

    public User() {}

    public void addToDoItem(ToDoItem toDoItem) {
        this.toDoList.add(toDoItem);
        toDoItem.setUser(this);
    }

    public void removeToDoItem(ToDoItem toDoItem) {
        this.toDoList.remove(toDoItem);
        toDoItem.setUser(null);
    }

    public User(Integer code, String userName) {
        this.id = code;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
