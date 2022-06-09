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

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
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
}
