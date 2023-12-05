/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/05/2023
 * File Name: TemperatureEvent.java
 * Description: This class extends SensorEvent to represent 
 * temperature-related events in IoT systems.
 * It includes a specific temperature value and provides 
 * a method to return a descriptive message
 * about the temperature event, including the sensor ID 
 * and the recorded temperature.
 */

package edu.bu.met.cs665.reactor;

public class TemperatureEvent extends SensorEvent {
  private final double temperature;

  public TemperatureEvent(String sensorId, double temperature) {
    super(sensorId);
    this.temperature = temperature;
  }

  public double getTemperature() {
    return temperature;
  }

  @Override
  public String getEventDescription() {
    return "Temperature reading from sensor " + getSensorId() + " is " + temperature + "°C";
  }
}
