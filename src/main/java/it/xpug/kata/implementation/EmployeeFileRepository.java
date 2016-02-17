package it.xpug.kata.implementation;

import it.xpug.kata.birthday_greetings.Employee;
import it.xpug.kata.birthday_greetings.XDate;
import it.xpug.kata.core.IEmployeeRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileRepository implements IEmployeeRepository{

    private final String fileName;

    public EmployeeFileRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Employee> findEmployeesWhoBirthDayIs(XDate xDate) throws IOException, ParseException {
        List<Employee> employees = new ArrayList<Employee>();
        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
        String str = "";
        str = in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
            if (employee.isBirthday(xDate)) {
                employees.add(employee);
            }
        }

        return employees;
    }
}