/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/05/2023
 * File Name: EventHandler.java
 * Description: This interface is part of the Reactor pattern implementation for IoT systems.
 * It defines the contract for event handlers with a method to process different sensor events.
 */

package edu.bu.met.cs665.reactor;

public interface EventHandler {
  void handleEvent(SensorEvent event);
}
