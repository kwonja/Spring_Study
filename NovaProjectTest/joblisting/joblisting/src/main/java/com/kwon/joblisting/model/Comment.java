package com.kwon.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "Comments")
public class Comment {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Comment[] getReplies() {
        return replies;
    }

    public void setReplies(Comment[] replies) {
        this.replies = replies;
    }

    private String message;
    private String timestamp;
    private Comment replies[];

    @Override
    public String toString() {
        return "Comment{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", replies=" + Arrays.toString(replies) +
                '}';
    }
}
