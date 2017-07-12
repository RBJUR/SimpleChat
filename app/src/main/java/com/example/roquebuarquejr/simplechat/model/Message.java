package com.example.roquebuarquejr.simplechat.model;

import java.io.Serializable;

/**
 * Created by roque
 */
public class Message implements Serializable {
    private String author;
    private String message;
    private String talkid;

    public Message() {
    }

    public Message(String talkid, String author, String message) {
        this.talkid = talkid;
        this.author = author;
        this.message = message;
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

    public String getTalkid() {
        return talkid;
    }

    public void setTalkid(String talkid) {
        this.talkid = talkid;
    }
}
