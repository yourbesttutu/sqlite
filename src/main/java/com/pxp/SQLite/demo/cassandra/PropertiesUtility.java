package com.pxp.SQLite.demo.cassandra;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesUtility {

  private static final Logger logger = Logger.getLogger(PropertiesUtility.class.getName());
  private static final String IF_CONFIG_FILE = "config.properties";
  private static final String ENV_CONFIG_FILE = "env.properties";
  private static final String CASSANDRA_CLIENT_HOST_IP = "CASSANDRA_CLIENT_HOST_IP";
  private static final String REDIS_FILE = "REDISSON_CONFIG_FILE";
  public static final String SSL_ON = "SSL_ON";
  public static final String ANOMALY_SIZE_IN_CAUSAL_CHUNK = "ANOMALY_SIZE_IN_CAUSAL_CHUNK";
  public static final String APP_VERSION = "AppVersion";
  public static final String ZOOM_B64 = "ZOOM_B64";
  public static final String ON_PREM = "onPrem";
  private static final String RABBITMQ_HEARTBEAT = "RABBITMQ_HEARTBEAT";
  private static final String RABBITMQ_BUILTIN_AUTO_RECOVERY = "RABBITMQ_BUILTIN_AUTO_RECOVERY";
  private static final String RABBITMQ_CHANNEL_MAX = "RABBITMQ_CHANNEL_MAX";
  private static final String RABBITMQ_INSIGHTFINDER_MONITOR = "RABBITMQ_INSIGHTFINDER_MONITOR";
  private static final String RABBITMQ_AUTO_ACK = "RABBITMQ_AUTO_ACK";
  private static final String RABBITMQ_ACK_BEFORE_PROCESS = "RABBITMQ_ACK_BEFORE_PROCESS";
  private static final String CASSANDRA_DO_NOT_SYNC = "CASSANDRA_DO_NOT_SYNC";
  private static final String RABBITMQ_MANAGEMENT_PREFIX = "RABBITMQ_MANAGEMENT_PREFIX";
  private static final String RABBITMQ_PORT = "RABBITMQ_PORT";

  /**
   * Fetch IF properties from the following sources: 1) environment variables 2) config file if the
   * environment variables are not set
   *
   * @return all of the IF properties
   */
  public static Properties fetchProperty() {
    Properties prop = RetrieveSystemVariables.fetchIFSystemVariables();
    if (prop == null) {
      prop = fetchPropertyFile(IF_CONFIG_FILE);
    }
    return prop;
  }

  public static Properties fetchPropertyFile(String configFileName) {
    Properties prop = new Properties();
    try {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      try (InputStream resourceStream = loader.getResourceAsStream(configFileName)) {
        if (resourceStream != null) {
          prop.load(resourceStream);
          resourceStream.close();
        }
      }
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Fail to load config.properties", e);
    }
    return prop;
  }

}
