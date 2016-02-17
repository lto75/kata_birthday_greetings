package it.xpug.kata.core;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * Created by lionel on 16/02/2016.
 */
public interface IMessageService {

    public void send(Greetings greetings) throws AddressException,MessagingException;
}
