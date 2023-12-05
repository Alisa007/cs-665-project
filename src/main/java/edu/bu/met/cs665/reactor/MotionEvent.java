/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/05/2023
 * File Name: MotionEvent.java
 * Description: This class extends SensorEvent to represent motion detection events in IoT systems.
 * It encapsulates details specific to motion events, such as the detected motion's description,
 * and provides a method to get a descriptive message about the event.
 */

package edu.bu.met.cs665.reactor;

public class MotionEvent extends SensorEvent {
  private final String motionDetected;

  public MotionEvent(String sensorId, String motionDetected) {
    super(sensorId);
    this.motionDetected = motionDetected;
  }

  public String getMotionDetected() {
    return motionDetected;
  }

  @Override
  public String getEventDescription() {
    return "Motion detected by sensor " + getSensorId() + ": " + motionDetected;
  }
}

