package com.example.roquebuarquejr.simplechat.model;

import java.io.Serializable;

/**
 * Created by roque
 */
public class User implements Serializable {
    private String username;
    private String uid;
    private String emoji;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
