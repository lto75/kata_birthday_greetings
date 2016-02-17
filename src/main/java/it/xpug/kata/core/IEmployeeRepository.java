package it.xpug.kata.core;

import it.xpug.kata.birthday_greetings.Employee;
import it.xpug.kata.birthday_greetings.XDate;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by lionel on 17/02/2016.
 */
public interface IEmployeeRepository {

    public List<Employee> findEmployeesWhoBirthDayIs(XDate ourDate) throws IOException, ParseException;
}
