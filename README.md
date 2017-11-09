# Simple Spring AOP Demonstration
I've tried to demonstrate following pointcuts:
1. execution 
2. @annotation


## Limitations
* join-points can be at method level not at field level in a class.
* Methods with public visibility will be advised.
* Local or internal method calls within an advised class don’t get intercepted by proxy, 
  so the advice method of the aspect does not get fired or invoked.


## Getting Started
Please use Main class to run the program & trace accordingly.


## Acknowledgments
* https://dzone.com/articles/overview-of-spring-aspect-oriented-programming-aop
* https://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations
* https://docs.spring.io/spring/docs/2.5.x/reference/aop.html
