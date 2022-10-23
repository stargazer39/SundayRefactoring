package com.employee.service;

import com.employee.common.WithProperties;
import com.employee.model.Employee;
import java.util.ArrayList;

public abstract class AbstractService extends WithProperties {

  public abstract void displayEmployees();

  public abstract void createEmployeeTable();

  public abstract void saveEmployeesToDb();

  public abstract void employeeGetById(String eid);

  public abstract void displayEmployee();

  public abstract void printEmployee(ArrayList<Employee> l);
}
