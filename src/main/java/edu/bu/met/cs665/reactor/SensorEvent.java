/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/05/2023
 * File Name: SensorEvent.java
 * Description: This abstract class serves as a base for different 
 * types of sensor events in an IoT system.
 * It encapsulates common attributes such as timestamp and sensorId, 
 * and defines an abstract method
 * for subclasses to provide a specific description of the sensor event.
 */

package edu.bu.met.cs665.reactor;

public abstract class SensorEvent {
  private final long timestamp;
  private final String sensorId;

  public SensorEvent(String sensorId) {
    this.timestamp = System.currentTimeMillis(); // Capture the event creation time
    this.sensorId = sensorId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getSensorId() {
    return sensorId;
  }

  public abstract String getEventDescription();
}
