package utils;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WithProperties {

  public static final Properties p = new Properties();

  static {
    try {
      p.load(
        WithProperties.class.getResourceAsStream("../config/config.properties")
      );
    } catch (Exception e) {}
  }
}
