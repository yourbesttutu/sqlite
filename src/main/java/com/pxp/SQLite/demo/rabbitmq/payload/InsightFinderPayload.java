package com.pxp.SQLite.demo.rabbitmq.payload;

import java.io.Serializable;

public abstract class InsightFinderPayload implements Serializable {

  public abstract boolean doTask();
}
