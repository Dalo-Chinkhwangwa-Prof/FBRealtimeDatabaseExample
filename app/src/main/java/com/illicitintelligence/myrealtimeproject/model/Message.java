package com.illicitintelligence.myrealtimeproject.model;

public class Message {

    private String messageTitle;
    private String messageDate;
    private String userName;
    private String messageContent;

    public Message(/*String messageTitle, String messageDate, String userName, String messageContent*/) {
        /*this.messageTitle = messageTitle;
        this.messageDate = messageDate;
        this.userName = userName;
        this.messageContent = messageContent;*/
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
