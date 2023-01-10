package com.pxp.SQLite.demo.rabbitmq.payload;


public class DetectionPayload extends InsightFinderPayload {

  public DetectionPayload() {
  }

  public DetectionPayload(String projectName, String customerName) {
    this.projectName = projectName;
    this.customerName = customerName;
  }

  private String projectName;
  private String customerName;

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  @Override
  public boolean doTask() {
    return true;
  }

  @Override
  public String toString() {
    return "DetectionPayload{" +
        "projectName='" + projectName + '\'' +
        ", customerName='" + customerName + '\'' +
        '}';
  }
}
