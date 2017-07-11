package com.example.roquebuarquejr.simplechat.model;

import java.io.Serializable;

/**
 * Created by roque
 */
public class Message implements Serializable {
    private String author;
    private String message;

    public Message() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
