package com.employee.common;

public class Constants {

  public static class XMLPathKeys {

    public static final String EMPLOYEE_ID = "XpathEmployeeIDKey";
    public static final String EMPLOYEE_NAME = "XpathEmployeeNameKey";
    public static final String EMPLOYEE_ADDRESS = "XpathEmployeeAddressKey";
    public static final String FACULTY_NAME = "XpathFacultyNameKey";
    public static final String DEPARTMENT = "XpathDepartmentKey";
    public static final String DESIGNATION = "XpathDesignationKey";
  }

  public static class XMLQueryCommon {

    public static final String EMPLOYEE_QUERY = "//Employees/Employee";
  }

  public static class XMLEmployeeTagNames {

    public static final String EMPLOYEE_ID = "EmployeeID";
    public static final String EMPLOYEE_NAME = "EmployeeFullName";
    public static final String EMPLOYEE_ADDRESS = "EmployeeFullAddress";
    public static final String FACULTY_NAME = "FacultyName";
    public static final String DEPARTMENT = "Department";
    public static final String DESIGNATION = "Designation";
  }

  public static class Config {

    public static final String CONFIG_FILE_PATH = "../../../config/config.properties";
    public static final String EMPLOYEE_QUERY_XML_PATH =
      "src/config/EmployeeQuery.xml";
    public static final String EMPLOYEE_RESPONSE_XML =
      "src/config/EmployeeResponse.xml";
    public static final String EMPLOYEE_REQUEST = "src/config/EmployeeRequest.xml";
    public static final String EMPLOYEE_MODIFIED =
      "src/config/Employee-modified.xsl";
  }

  public static class Props {

    public static final String DB_URL = "url";
    public static final String DB_USERNAME = "username";
    public static final String DB_PASSWORD = "password";
  }

  public static class ColumnIndexes {

    public static final int COLUMN_INDEX_ONE = 1;
    public static final int COLUMN_INDEX_TWO = 2;
    public static final int COLUMN_INDEX_THREE = 3;
    public static final int COLUMN_INDEX_FOUR = 4;
    public static final int COLUMN_INDEX_FIVE = 5;
    public static final int COLUMN_INDEX_SIX = 6;
  }
}
