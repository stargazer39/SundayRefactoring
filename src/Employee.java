public class Employee {

  public String employeeId;
  public String fullName;
  public String address;
  public String facultyName;
  public String department;
  public String designation;

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeID) {
    employeeId = employeeID;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getFacultyName() {
    return this.facultyName;
  }

  public void setfacultyName(String facultyName) {
    this.facultyName = facultyName;
  }

  public String getDepartment() {
    return this.department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getDesignation() {
    return this.designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  @Override
  public String toString() {
    return (
      "Employee ID = " +
      this.employeeId +
      "\n" +
      "FullName = " +
      this.fullName +
      "\n" +
      "Address = " +
      this.address +
      "\n" +
      "Faculty Name = " +
      this.facultyName +
      "\n" +
      "Department = " +
      this.department +
      "\n" +
      "Designation = " +
      this.designation
    );
  }
}
