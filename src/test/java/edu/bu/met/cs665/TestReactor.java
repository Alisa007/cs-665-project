package edu.bu.met.cs665;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.bu.met.cs665.reactor.Reactor;
import edu.bu.met.cs665.reactor.SensorEvent;
import edu.bu.met.cs665.reactor.SensorEventDemultiplexer;
import edu.bu.met.cs665.reactor.TemperatureEvent;
import edu.bu.met.cs665.reactor.MotionEvent;

public class TestReactor {

    static class TestDemultiplexer extends SensorEventDemultiplexer {
        private int counter = 0;
        private final int maxEvents;

        TestDemultiplexer(int maxEvents) {
            this.maxEvents = maxEvents;
        }

        @Override
        public SensorEvent getNextEvent() {
            if (counter >= maxEvents) {
                throw null;
            }

            counter++;
            if (counter == 1) {
                return new TemperatureEvent("TempSensor1", 22.5);
            } else if (counter == 2) {
                return null;
            } else {
                return new MotionEvent("MotionSensor1", "Movement Detected");
            }
        }
    }

    @Test
    public void testReactorRunsAndDispatchesEvents() {
        SensorEventDemultiplexer testDemultiplexer = new TestDemultiplexer(10);
        Reactor reactor = new Reactor(testDemultiplexer);

        Thread reactorThread = new Thread(reactor::run);
        reactorThread.start();

        try {
            reactorThread.join(); // Wait for the reactor thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            fail("Test interrupted");
        }
    }

    @Test
    public void testStopMethodStopsReactor() throws InterruptedException {
        SensorEventDemultiplexer demultiplexer = new TestDemultiplexer(20);
        Reactor reactor = new Reactor(demultiplexer);

        Thread reactorThread = new Thread(reactor::run);
        reactorThread.start();

        // Allow some time for the reactor to start
        Thread.sleep(500);

        assertTrue("Reactor should be running", reactor.isRunning());

        reactor.stop();

        // Wait for the reactor to finishs
        reactorThread.join();

        assertFalse("Reactor should have stopped", reactor.isRunning());
    }
}
