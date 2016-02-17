package it.xpug.kata.core;

/**
 * Created by lionel on 16/02/2016.
 */
public class Greetings {
    public final String recipient;
    public final String body;
    public final String subject;
    public final String senders;

    public Greetings(String recipient, String body, String subject, String senders) {
        this.recipient = recipient;
        this.body = body;
        this.subject = subject;
        this.senders = senders;
    }

}
