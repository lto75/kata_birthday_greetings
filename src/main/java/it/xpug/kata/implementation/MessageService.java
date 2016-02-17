package it.xpug.kata.implementation;

import it.xpug.kata.core.Greetings;
import it.xpug.kata.core.IMessageService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.logging.Logger;

/**
 * Created by lionel on 16/02/2016.
 */
public class MessageService implements IMessageService{

    private final String smtpHost;
    private int smtpPort;

    public MessageService(String smtpHost, int smtpPort) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;

    }

    public void send(Greetings greetings) throws AddressException,MessagingException  {
        // Create a mail session
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", this.smtpHost);
        props.put("mail.smtp.port", "" + this.smtpPort);
        Session session = Session.getInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(greetings.senders));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(greetings.recipient));
        msg.setSubject(greetings.subject);

        msg.setText(greetings.body);
        // Send the message
        Transport.send(msg);


    }
}
