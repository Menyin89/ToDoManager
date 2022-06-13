package com.example.tdm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Person")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
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

    public User(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
