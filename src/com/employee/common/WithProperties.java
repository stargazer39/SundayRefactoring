package com.employee.common;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.employee.utils.EmployeeQueryUtil;

public class WithProperties {

  public static final Properties p = new Properties();

  static {
    try {
      p.load(EmployeeQueryUtil.class.getResourceAsStream(Constants.Config.CONFIG_FILE_PATH));
    } catch (Exception e) {}
  }
}
