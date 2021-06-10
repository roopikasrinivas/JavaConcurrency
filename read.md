##Java Concurrency / Threads

### What is a process?
A process is a unit execution that has its own memory space. Each instance of a Java Virtual Machine (JVM) run as a process (mostly). When we run a Java console application or a JavaFX application, we're kicking off a process. 

Terms process and application are used interchangeably. If one Java application is running and we run another one, each application has its own memory space of **heap**. The first java application can't access the heap that belongs to the second Java application. The heap isn't shared between them. They each have their own.

A **thread** is a unit of execution within a process. Each process can have multiple threads. In Java, every process (or application) has at least one thread, the **main thread** ( for UI applications, this is called **JavaFX application thread**). In fact, just about every Java process also has multiple system