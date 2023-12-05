/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/05/2023
 * File Name: SensorEventDemultiplexer.java
 * Description: This class simulates a demultiplexer for sensor events in an IoT system.
 * It randomly generates different types of sensor events (like temperature and motion events)
 * for testing and demonstration purposes. In a real-world scenario, it would interface with
 * actual sensor hardware or network services to receive real sensor data.
 */

package edu.bu.met.cs665.reactor;

import java.util.Random;

public class SensorEventDemultiplexer {
  private Random random = new Random();
  
  /**
   * Retrieves the next sensor event.
   * This method simulates the reception of a random sensor event for demonstration purposes.
   * In a real-world scenario, it would interface with sensor hardware 
   * or a network to receive actual sensor data.
   * 
   * @return SensorEvent, a randomly chosen sensor event or null.
   */
  public SensorEvent getNextEvent() {
    int eventType = random.nextInt(2);

    switch (eventType) {
      case 0:
        return new TemperatureEvent("TempSensor1", 22.5);
      case 1:
        return new MotionEvent("MotionSensor1", "Detected Movement"); 
      default:
        return null; // or bad event
    }
  }
}
