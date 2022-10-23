package com.employee.common;

import com.employee.database.DatabaseConnection;
import com.employee.utils.EmployeeQueryUtil;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WithProperties {

  public static final Properties p = new Properties();
  public static final Logger log = Logger.getLogger(
    WithProperties.class.getName()
  );

  static {
    try {
      p.load(
        EmployeeQueryUtil.class.getResourceAsStream(
            Constants.Config.CONFIG_FILE_PATH
          )
      );
    } catch (Exception e) {
      log.log(Level.SEVERE, e.getMessage());
    }
  }
}
