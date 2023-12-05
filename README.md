| CS-665     | Software Design & Patterns |
| ---------- | -------------------------- |
| Name       | ALISA BELOUSOVA            |
| Date       | 12/05/2023                 |
| Course     | Fall                       |
| Assignment | Project                    |

# Assignment Overview

In this project, I've implemented a software system utilizing the Reactor pattern. The context for this implementation was an Internet of Things (IoT) environment, which often deals with multiple types of sensor data and requires efficient, non-blocking processing.

# GitHub Repository Link:

https://github.com/alisa007/cs-665-project

# Implementation Description

## Flexibility

* Extensibility with New Event Types: The implementation is designed to be easily extensible with new sensor event types. Adding a new sensor event type involves creating a subclass of `SensorEvent` and implementing the `getEventDescription` method. No changes are needed in the `Reactor` or `SensorEventDemultiplexer` classes because of polymorphism. Similarly, adding a new event handler is as straightforward as implementing the `EventHandler` interface for the new event type. The `Reactor` class's `dispatch` method will automatically handle the new event type if the `getHandlerForEvent` method is updated accordingly.
* Decoupling of Components: The use of interfaces (`EventHandler`) and abstract classes (`SensorEvent`) provides a high degree of decoupling. This allows for individual components to be modified, added, or removed without impacting other parts of the system.

## Simplicity and Understandability

* Clear Separation of Concerns: Each class and interface has a well-defined role, making the system easier to understand and maintain. For example, `SensorEvent` and its subclasses represent sensor data, `EventHandler` deals with processing these events, and the `Reactor` orchestrates the event handling.
* Consistency in Design: The implementation follows consistent design principles across all components, such as consistent method naming and usage of data types. This consistency aids in making the codebase predictable and easier to navigate.

## Avoidance of Duplicated Code

* Use of Inheritance and Polymorphism: By using abstract classes and interfaces, common functionalities are centralized. For instance, the `SensorEvent` class encapsulates attributes and methods common to all sensor events, eliminating the need for duplicate code in each event type. Event handling is abstracted through the `EventHandler` interface, ensuring that common handling logic is not duplicated across different handler implementations.

## Use of Design Patterns

* Reactor Pattern: The Reactor pattern is used to manage multiple concurrent input/output event streams without using multiple threads. This pattern is ideal for IoT systems where handling different sensor inputs efficiently is crucial. The pattern allows for non-blocking event handling, which is critical in resource-constrained environments like IoT.
* Template Method Pattern: The template method pattern is used through the use of abstract classes (`SensorEvent`). Subclasses are required to implement the abstract method (`getEventDescription`), providing a template for event-specific behavior.
* Factory Method Pattern: The method `getHandlerForEvent` in the `Reactor` class follows the Factory Method pattern by creating objects (event handlers) without specifying the exact class of object that will be created. This allows for flexibility and decoupling between the `Reactor` and specific `EventHandler` implementations.

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

To run, use the following command:

```bash
mvn clean test
```

## Spotbugs

Use the following command:

```bash
mvn spotbugs:gui 
```

## Checkstyle

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`
