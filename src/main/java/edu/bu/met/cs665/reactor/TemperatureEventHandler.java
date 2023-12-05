/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/05/2023
 * File Name: TemperatureEventHandler.java
 * Description: This class implements the EventHandler interface 
 * for handling temperature sensor events.
 * It provides specific logic for processing temperature events, 
 * such as logging or generating alerts
 * based on the temperature value received from the event.
 */

package edu.bu.met.cs665.reactor;

public class TemperatureEventHandler implements EventHandler {
  @Override
  public void handleEvent(SensorEvent event) {
    TemperatureEvent temperatureEvent = (TemperatureEvent) event;
    double temperature = temperatureEvent.getTemperature();
    // Handle the temperature event, e.g., logging, alerting, etc.
    System.out.println("Handling temperature event: " + temperature + "°C");
  }
}
