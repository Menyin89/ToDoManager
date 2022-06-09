package com.example.tdm.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Person")
public class User {

    @Id
    @Column(name="user_id")
    private Integer id;

    @Column(name="user_name")
    private String userName;

    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<ToDoItem> toDoList;

    public User() {}

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

    public List<ToDoItem> getToDoList() {
        return toDoList;
    }

}
