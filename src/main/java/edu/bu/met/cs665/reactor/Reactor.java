/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/05/2023
 * File Name: Reactor.java
 * Description: The Reactor class implements the central part of the Reactor pattern.
 * It manages an event loop that listens for sensor events, 
 * dispatches them to appropriate handlers, and can be stopped and started. 
 * It's designed to efficiently process different types of sensor events
 * in a non-blocking manner, making it suitable for use in IoT systems.
 */

package edu.bu.met.cs665.reactor;

public class Reactor {
  private SensorEventDemultiplexer demultiplexer;
  private boolean running = true;

  public Reactor(SensorEventDemultiplexer demultiplexer) {
    this.demultiplexer = demultiplexer;
  }

  public void run() {
    while (running) {
      SensorEvent event = demultiplexer.getNextEvent();
      
      if (event != null) {
        System.out.println(event.getEventDescription());
        System.out.println(event.getTimestamp());
        dispatch(event);
      }
    }
  }

  public void stop() {
    this.running = false;
  }

  public boolean isRunning() {
    return running;
  }

  private void dispatch(SensorEvent event) {
    EventHandler handler = getHandlerForEvent(event);
    
    if (handler != null) {
      handler.handleEvent(event);
    }
  }

  private EventHandler getHandlerForEvent(SensorEvent event) {
    if (event instanceof TemperatureEvent) {
      return new TemperatureEventHandler();
    } else if (event instanceof MotionEvent) {
      return new MotionEventHandler();
    }

    return null; // Return null if no suitable handler is found
  }
}
