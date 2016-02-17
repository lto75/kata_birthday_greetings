package it.xpug.kata.birthday_greetings;

import it.xpug.kata.core.Greetings;
import it.xpug.kata.core.IEmployeeRepository;
import it.xpug.kata.core.IMessageService;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BirthdayService {

	private final IEmployeeRepository employeeFileRepository;
	private IMessageService messageService;

	public BirthdayService(IMessageService messageService,IEmployeeRepository iEmployeeRepository) {
		this.messageService = messageService;
		this.employeeFileRepository = iEmployeeRepository;
	}

	public void sendGreetings(XDate xDate) throws IOException, ParseException, AddressException, MessagingException {
		List<Employee> employees = employeeFileRepository.findEmployeesWhoBirthDayIs(xDate);
		sendTheMessageToTheEmployeesSelected(employees);
	}

	private void sendTheMessageToTheEmployeesSelected(List<Employee> employees) throws MessagingException {
		for(Employee employee : employees){
			String recipient = employee.getEmail();
			String body = "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstName());
			String subject = "Happy Birthday!";
			String senders = "sender@here.com";
			Greetings greetings = new Greetings(recipient,body,subject,senders);
			this.messageService.send(greetings);
		}

	}

}
