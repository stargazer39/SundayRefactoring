package com.employee.common;

public class Constants {
	public static class XMLPathKeys {
		public final static String EMPLOYEE_ID = "XpathEmployeeIDKey";
		public final static String EMPLOYEE_NAME = "XpathEmployeeNameKey";
		public final static String EMPLOYEE_ADDRESS = "XpathEmployeeAddressKey";
		public final static String FACULTY_NAME = "XpathFacultyNameKey";
		public final static String DEPARTMENT = "XpathDepartmentKey";
		public final static String DESIGNATION = "XpathDesignationKey";
	}
	
	public static class XMLQueryCommon {
		public final static String EMPLOYEE_QUERY = "//Employees/Employee";
	}
	
	public static class XMLEmployeeTagNames {
		public final static String EMPLOYEE_ID = "EmployeeID";
		public final static String EMPLOYEE_NAME = "EmployeeFullName";
		public final static String EMPLOYEE_ADDRESS = "EmployeeFullAddress";
		public final static String FACULTY_NAME = "FacultyName";
		public final static String DEPARTMENT = "Department";
		public final static String DESIGNATION = "Designation";
	}
	
	public static class Config {
		public final static String CONFIG_FILE_PATH = "../config/config.properties";
		public final static String EMPLOYEE_QUERY_XML_PATH = "src/e/EmployeeQuery.xml";
		public final static String EMPLOYEE_RESPONSE_XML = "src/e/EmployeeResponse.xml";
		public final static String EMPLOYEE_REQUEST = "src/e/EmployeeRequest.xml";
		public final static String EMPLOYEE_MODIFIED = "src/e/Employee-modified.xsl";
	}
	
	public static class Props {
		public final static String DB_URL = "url";
		public final static String DB_USERNAME = "username";
		public final static String DB_PASSWORD = "password";
	}
	
	public static class ColumnIndexes {
		public final static int COLUMN_INDEX_ONE = 1;
		public final static int COLUMN_INDEX_TWO = 2;
		public final static int COLUMN_INDEX_THREE = 3;
		public final static int COLUMN_INDEX_FOUR = 4;
		public final static int COLUMN_INDEX_FIVE = 5;
		public final static int COLUMN_INDEX_SIX = 6;
	}
}
