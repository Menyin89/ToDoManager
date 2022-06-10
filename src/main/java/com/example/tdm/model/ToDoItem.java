package com.example.tdm.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="ToDoItem")
public class ToDoItem {

    @Id
    @GeneratedValue
    @Column(name="todo_id")
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    private boolean done = false;

    @Transient
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public ToDoItem() {
    }

    public ToDoItem(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
