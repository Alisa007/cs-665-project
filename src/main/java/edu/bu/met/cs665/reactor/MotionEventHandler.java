/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/05/2023
 * File Name: MotionEventHandler.java
 * Description: Implements the EventHandler interface 
 * for handling motion events in IoT systems.
 * This class provides specific logic to process motion events, 
 * such as triggering alarms or recording data.
 */

package edu.bu.met.cs665.reactor;

public class MotionEventHandler implements EventHandler {
  @Override
  public void handleEvent(SensorEvent event) {
    MotionEvent motionEvent = (MotionEvent) event;
    String motionDetected = motionEvent.getMotionDetected();
    // Handle the motion event, e.g., triggering alarms, recording data, etc.
    System.out.println("Handling motion event: " + motionDetected);
  }
}
