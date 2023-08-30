package com.pxp.SQLite.demo.cassandra;

import java.util.Properties;

public class RetrieveSystemVariables {

  private static final String[] IF_CONFIG_SYS_VARS = {"STORAGE_INTERFACE", "AppVersion",
      "AppPlatform", "Zone", "HEALTH_SCORE_METHOD", "LOCAL_CACHE_ENABLED", "MAIL_ONOFF_SWITCH",
      "MAIL_SMTP_SERVER", "MAIL_SEND_OVER_SECURITY", "MAIL_SMTP_PORT", "MAIL_SMTP_AUTH",
      "MAIL_INFORM_USER", "MAIL_SEND_USER", "MAIL_AUTH_USER", "MAIL_SMTP_PW", "AWS_ACCESS_KEY",
      "AWS_SECRET_KEY", "DEDICATED_LOG_WORKER", "DEDICATED_LOG_REPLAY_WORKER",
      "DEDICATED_AGENT_WORKER", "GENERAL_WORKER", "GENERAL_SUPPORT_WORKER",
      "GENERAL_LOG_WORKER", "METRIC_TRAIN", "METRIC_DETECTION", "METRIC_PREDICTION",
      "LOG_COORDINATOR", "LOG_TRAIN", "LOG_DETECTION", "LOG_COLLECTION", "LOG_SAVE_NID_DATA",
      "LOG_REDUCER", "CAUSAL_RELATION_WORKER", "UPDATE_EVENTS_WORKER", "ANOMALY_INSIGHTS_WORKER",
      "ANOMALY_TRANSFER_WORKER", "GENERAL_METRIC_WORKER_PART1", "GENERAL_METRIC_WORKER_PART2",
      "GENERAL_METRIC_COLLECTOR_WORKER",
      "REDIS_LISTENER_ROLE", "AGENTWORKER_NUMBER", "LOG_CRON_TRAINING_SPAN_MILLIS",
      "LOG_BOOTSTRAP_TRAINING_SPAN_MILLIS", "TEMP_PWD_EXPIRE_TIME", "LOG_KEYWORDS_COLLECTION_FLAG",
      "NUM_OF_METRIC_TRAIN_THREADS", "NUM_OF_METRIC_DETECTION_THREADS",
      "NUM_OF_METRIC_PREDICTION_THREADS", "NUM_OF_LOG_REPLAY_THREADS", "NUM_OF_LOG_AGENT_THREADS",
      "NUM_OF_LOG_TRAIN_THREADS", "NUM_OF_LOG_DETECTION_THREADS", "NUM_OF_LOG_COLLECTION_THREADS",
      "NUM_OF_LOG_SAVE_NID_DATA_THREADS", "NUM_OF_LOG_REDUCER_THREADS",
      "NUM_OF_HISTORICAL_LOG_TRAIN_THREADS", "NUM_OF_HISTORICAL_LOG_DETECTION_THREADS",
      "NUM_OF_HISTORICAL_LOG_COLLECTION_THREADS", "NUM_OF_GENERAL_WORKER_THREADS",
      "NUM_OF_GENERAL_LOG_WORKER_THREADS", "NUM_OF_GENERAL_METRIC_WORKER_THREADS",
      "NUM_OF_ANOMALY_INSIGHTS_WORKER_THREADS", "NUM_OF_PREDICTION_TIMELINE_WORKER_THREADS",
      "NUM_OF_RELATION_TASK_THREADS", "NUM_OF_GLOBALVIEW_TASK_THREADS",
      "DEFAULT_CAUSAL_LOG_PREDICTION_COUNT_THRESHOLD",
      "DEFAULT_CAUSAL_LOG_PREDICTION_PROBABILITY_THRESHOLD", "USING_NEW_METRIC_TABLE",
      "MAX_LOG_SIZE", "INCIDENT_TIME_RANGE", "RAW_DATA_CHUNK_SIZE", "LOG_DETECTION_BATCH_SIZE",
      "NUM_OF_CHUNK_TO_FETCH", "DEMO_PROJECT_LIST", "DEMO_USER", "ALLOW_FILE_UPLOAD",
      "HTTP_PROXY_HOST", "HTTP_PROXY_PORT", "HTTP_PROXY_USERNAME", "HTTP_PROXY_PASSWORD",
      "HTTPS_PROXY_HOST", "HTTPS_PROXY_PORT", "HTTPS_PROXY_USERNAME", "HTTPS_PROXY_PASSWORD",
      "CASSANDRA_STORE_TIMEOUT", "SESSION_TIMEOUT", "USER_LOCK_DURATION", "MAX_LOG_IN_RETRY",
      "CAUSAL_TASK_TIMEOUT", "SSL_ON", "SSL_CER_DIR", "SSL_TRUST_STORE_FILE_DIR",
      "SSL_KEY_STORE_FILE_DIR", "SSL_KEY_STORE_PW", "SSL_TRUST_STORE_PW", "METRIC_CHUNKING_SIZE",
      "NONE_CRON_PAYLOAD", "LOG_PATTERN_PREFETCH", "LOG_COLLECTION_PREFETCH",
      "SAVE_LOG_COMPRESS_EVENT"};
  private static final String[] ENV_CONFIG_SYS_VARS =
      {"CASSANDRA_CLIENT_HOST_IP", "cassandraClientUserName", "cassandraClientPassword",
          "CASSANDRA_DO_NOT_SYNC",
          "REDISSON_CONFIG_FILE", "rabbitmqInstallations", "RABBITMQ_IP", "RABBITMQ_USERNAME",
          "RABBITMQ_PASSWORD", "RABBITMQ_HEARTBEAT", "RABBITMQ_BUILTIN_AUTO_RECOVERY",
          "RABBITMQ_INSIGHTFINDER_MONITOR", "RABBITMQ_CHANNEL_MAX", "RABBITMQ_AUTO_ACK",
          "RABBITMQ_ACK_BEFORE_PROCESS", "RABBITMQ_MANAGEMENT_PREFIX", "RABBITMQ_PORT",
          "IF_UI_HOST", "WORKER_IP_LIST"};
  private static final String IF_SYS_VARS = "IF_SYS_VARS";
  private static final String ENV_SYS_VARS = "ENV_SYS_VARS";

  /**
   * Check if the IF_SYS_VARS environment variable is set, if true, retrieve IF properties from
   * system variables
   *
   * @return IF properties or null
   */
  public static Properties fetchIFSystemVariables() {
    String hasIFSystemVariablesStr = System.getenv(IF_SYS_VARS);
    boolean hasIFSystemVariables = false;

    if (hasIFSystemVariablesStr!=null) {
      hasIFSystemVariables = Boolean.parseBoolean(hasIFSystemVariablesStr);
    }

    Properties prop = null;
    if (hasIFSystemVariables) {
      prop = fetchSystemVariables(IF_CONFIG_SYS_VARS);
    }
    return prop;
  }

  /**
   * Check if the ENV_SYS_VARS environment variable is set, if true, retrieve Env properties from
   * system variables
   *
   * @return Env properties or null
   */
  public static Properties fetchEnvSystemVariables() {
    String hasEnvSystemVariablesStr = System.getenv(ENV_SYS_VARS);
    boolean hasEnvSystemVariables = false;

    if (hasEnvSystemVariablesStr!=null) {
      hasEnvSystemVariables = Boolean.parseBoolean(hasEnvSystemVariablesStr);
    }

    Properties prop = null;
    if (hasEnvSystemVariables) {
      prop = fetchSystemVariables(ENV_CONFIG_SYS_VARS);
    }
    return prop;
  }

  /**
   * Fetch system variables from the environment and create a properties file with the given name/
   * value
   *
   * @param variables an array of strings with the names of the system variables to fetch
   * @return all of the variables loaded from the system
   */
  private static Properties fetchSystemVariables(String[] variables) {
    Properties prop = new Properties();
    for (String variableName : variables) {
      String value = System.getenv(variableName);
      if (value!=null) {
        prop.put(variableName, value);
      }
    }
    return prop;
  }
}
