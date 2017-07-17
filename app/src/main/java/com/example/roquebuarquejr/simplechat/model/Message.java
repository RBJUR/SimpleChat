package com.example.roquebuarquejr.simplechat.model;

import java.io.Serializable;

/**
 * Created by roque
 */
public class Message implements Serializable {
    private String author;
    private String message;
    private String sendby;
    private String sendto;

    public Message() {
    }

    public Message(String author, String message, String sendby, String sendto) {
        this.author = author;
        this.message = message;
        this.sendby = sendby;
        this.sendto = sendto;
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


    public String getSendby() {
        return sendby;
    }

    public void setSendby(String sendby) {
        this.sendby = sendby;
    }

    public String getSendto() {
        return sendto;
    }

    public void setSendto(String sendto) {
        this.sendto = sendto;
    }
}
