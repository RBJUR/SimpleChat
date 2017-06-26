package com.example.roquebuarquejr.simplechat.model;

import java.io.Serializable;

/**
 * Created by roque
 */
public class Message implements Serializable {
    private String author;
    private String message;
    private String emoji;

    public Message() {
    }

    public Message(String author, String message, String emoji) {
        this.author = author;
        this.message = message;
        this.emoji = emoji;
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

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
