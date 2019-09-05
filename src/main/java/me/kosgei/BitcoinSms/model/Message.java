package me.kosgei.BitcoinSms.model;

public class Message {
    private String message;
    private Data data;

    public Message() {
    }
    public Message(String message, Data data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
