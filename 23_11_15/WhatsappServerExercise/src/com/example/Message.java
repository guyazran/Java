package com.example;

/**
 * Created by guyazran on 11/23/15.
 */
public class Message implements Comparable<Message>{
    private String content, sender, recipient;
    private long receiveTime;

    public Message(String content, String sender, String recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
        receiveTime = System.currentTimeMillis();
    }


    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public long getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(long receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj instanceof Message){
            Message otherMessage = (Message)obj;
            return this.receiveTime == otherMessage.receiveTime && this.content.equals(otherMessage.content) && this.sender.equals(otherMessage.sender) && this.recipient.equals(otherMessage.recipient);
        }
        return false;
    }

    @Override
    public int compareTo(Message o) {
        int delta = (int)(this.receiveTime - o.receiveTime);
        return delta;
    }
}
