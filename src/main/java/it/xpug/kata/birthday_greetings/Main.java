package it.xpug.kata.birthday_greetings;

import it.xpug.kata.core.IEmployeeRepository;
import it.xpug.kata.core.IMessageService;
import it.xpug.kata.implementation.EmployeeFileRepository;
import it.xpug.kata.implementation.MessageService;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {

		IMessageService messageService = new MessageService("localhost",25);
		IEmployeeRepository employeeRepository = new EmployeeFileRepository("employee_data.txt");
		BirthdayService service = new BirthdayService(messageService,employeeRepository);
		service.sendGreetings(new XDate());
	}

}
