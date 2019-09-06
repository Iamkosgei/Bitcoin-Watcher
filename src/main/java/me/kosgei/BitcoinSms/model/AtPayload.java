package me.kosgei.BitcoinSms.model;

public class AtPayload {
    private String username;
    private String to;
    private String message;

    public AtPayload() {
    }

    public AtPayload(String username, String to, String message) {
        this.username = username;
        this.to = to;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
