# Creating RESTful APIs

This is one of the first guides that I am creating on my own. Right now, I am studying for my CCNA exam, and I am honestly forgetting a lot of the things that I read about a few months ago. I need to start refreshing myself on things I have previously read. I thought to myself, "Why don't I create flashcards?", and eventually I realized I can make a project out of it. I know there are sites online that allow you to accomplish this, you could even do it on Google slides, but what's the fun in that? I read a chapter in my CCNA textbook that talked extensively about network automation via REST APIs. That could be a potential career path for me, so this is also a good opportunity to hone my programming skills and develop some front and back end development skills.

** Note that working with Spring requires a lot of terminology. Make sure to search keywords. There is a section at the bottom of this guide that defines terms used in Spring or this guide. **

## Spring vs. Spring Boot

Spring Framework
- In the 1990s there was Java EE which was proprietary and needed commercial hardware to use. THe open-soirce community came along and creating Spring.
- Spring provides services and similar to Java EE, provides a project infrastructure for building apps on the Java platform.
	- Simple services don't need Spring, but if your service needs security, transactions, resource pooling, and message queues that's where Spring comes in to play.
- Libraries available for REST clients, DB connection pools, and testing frameworks.
- ApplicationContext provides a collection of managed beans in memory.

Spring Boot
- Came after the development of Spring as it was becoming harder and harder to work with.
- Easy to create a Spring app. Spring Boot takes care of dependencies. 3 starter drivers could easily be 30-40 library dependencies.
	- Determines the accepted dependencies based on the Spring Boot version you choose when creating the project.
- Spring Initializr is a tool used to creating Spring apps. This is built-in to most IDEs, but there is also a web page.


## Getting Started

There are several things needed to create a RESTful API. 1) an IDE, 2) Spring Boot extensions for said IDE, and 3) lots and lots of time and brain power to muddle through StackOverflow and Baeldung.

When I took CST-438 at CSUMB, we used Eclipse with the Spring Boot suite installed, so I will use this IDE and environment for this guide.

Below is a list of good blogs and tutorials on how to get started with Spring projects.

- How to Create REST APIs with Java and Spring Boot: https://www.twilio.com/blog/create-rest-apis-java-spring-boot

### Creating a Spring Project

Below are steps to create a new Spring Project in the Eclipse IDE. Small deatil, but note that the Eclipse IDE points to the Spring Initializer.

1. Install Eclipse IDE
	- https://www.eclipse.org/downloads/
2. Install Spring Boot tool suite 
	- Eclipse IDE app > Help > Eclipse Marketplace
	- Search "Spring Tools"
	- Release at time of writing is 4.17.2
	- Install tool suite and restart Eclipse IDE
3. Create a new project
	- Eclipse IDE app > File > New > Other > Spring Starter Project
	- Service URL: https://start.spring.io
	- Name: *name of project*
	- Type: Maven
	- Language: Java
	- Java Version: 17
	- Group: com.*group name*
	- Artifact: 
	- Description: *quick description of the project*
	- Package: *same as Group*
4. Import project dependencies
	- Spring Boot version: 2.7.9
	- Developer tools -> Spring Boot Dev Tools
	- Web -> Spring Web
	- See below for a list of dependencies
5. Test Spring Boot App
	- Select the *Name*Applicaiton.java class
	- Run as Spring Boot App
	- Should start without any errors
	- Terminate server

Alternatively use Spring Initializr and repeat the same process. There will be slightly different steps to import the starter project.
https://start.spring.io/

1. After clicking the generate button and downloading the starter project
	- Keep starter project zipped
	- Open Eclipse IDE app
	- File > Import > Maven > Existing Maven Project

### Connecting Git and GitHub



1. Create NEW repo on the command line:
'''
	echo "# flashcard-backend" >> README.md
	git init
	git add README.md
	git commit -m "first commit"
	git branch -M main
	git remote add origin https://github.com/camoakley/flashcard-backend.git
	git push -u origin main
'''

Or...

2. Push an existing repo from an EXISTING repo from the command line:
'''
	git remote add origin https://github.com/camoakley/flashcard-backend.git
	git branch -M main
	git push -u origin main
'''

#### Dependencies
	1. Spring Web - required for building RESTful web applications.
    2. Spring Data JPA - required to access the data from the database. 
    3. MySQL Driver - required to connect with MySQL database.
    4. Thymeleaf - templating engine for views.

#### Starter Directory Structure
src/main/java/com/camoakley/flashcard 
- This subdirectory consists of all the Java classes for the Spring project.
- Java classes are used for many different things, they can represent object from our database or they can be a controller class.

src/main/resources/static
- For webpages that can be served directly to the browser without any input from the templating engine.

src/main/resources/templates
- For webpages that need some data plugged into them before being served to the requestor.

The application.properties file under the resource folder contains the properties your Spring Boot will use to configure the application. 
- Add database configuration details such as database URL, username, and password to this file.

pom.xml lists all the dependencies that you added while creating the Spring Boot project.

## Spring Annotations
Annotations are used for standard components. If a Annotation doesn't exist a user can define one using JavaConfig.

@SpringBootApplication
- When Spring starts up it will start in the package that has this annotation.
- Package: com.camoakley.flashcard
	- Note that Controller classes should be located beneath this package so that it can be found by Spring. For instance, com.camoakley.flashcard.controllers
- This annootation is used for convenience and is equivalent to having the @ComponentScan, @Configuration, and @EnableAutoConfiguration declared.

@SpringBootTest
-
- Must declare a random port for server to listen on.

@Autowired
- Plugs in an instance of a class into the application context. Useful in tests where we don't need full context of the entire app and just need an instance of a selection of the possible classes.
- Is called 'dependency injection', because we are programmatically declaring that we need an instance of this class in order for the unit test to work.

@ComponentScan 
- Allows Spring Boot to scan the package for components like Service, Controller, Repository, etc. and register beans for each of those classes.

@Configuration 
- It specifies a configuration class, where you’ll provide all the bean definitions that your application is using. Spring Boot will use the bean definitions provided in the configuration class to instantiate them at runtime.

@Controller
- Defines a controller class that is used to receive HTTP request and determine some kind of response.

@EnableAutoConfiguration 
- This will enable the auto-configuration feature of Spring Boot discussed earlier.

@GetMapping
- Whenever Spring gets an HTTP GET request with the specified mapping it forwards the request and given parameters to the method.
- This is an annotation from Spring MVC.

@RestController
- Annotation for a controller class that should receive more than GET requests. Meaning it can receive GET, POST, PUT/PATCH, and DELETE.
- From my CCNA studies, REST is used to transfer data between two programs. Typically the requestor is requesting some data that the backend server can provide. 
- A thing worth mentioning is data serialization. This is the format for requesting / receiving data. It allows for any programming language to interpret the data.
	- It is important to note that programming languages and even different versions of a programming language don't store variables in the same format. Formats like JSON and XML can be used to send data between two programs.
- Return data is automatically serialized when this annotation is used.



## Git Commands
'git add .'
'git commit -m "whatever text"'
'git push'
- 'git push -u origin *branch name*'
'git branch -M branch1'

## Terminology
** Terms are sorted in alphabetical order. **

Application Context
- I believe this is the instantiation of objects in memory used for dependency injection. Classes are added to the applciation context when Spring starts up. Again, Spring starts with at the @SpringBootApplication annotation and finds Controller classes from there.
- When performing dependency injection, it is determined if there is already a bean instantiation in memory.

Artifact
- This is the name of your project. Since you are creating an application for accessing and manipulating employee details, you can provide “employee”.

Backend / Server Side
- Backend logic consist of recieing JSON data in the form of an HTTP request, performing some logic, and returning data.
- Nowadays, there is a seperation between backend and frontend. Some developers offer a service that provides data and outside developers create an app that interprets data. Classic example, when iPhone was launched they built an app that integrated with map data.

Bean
- 'Plain Old Java Object' (POJO), basically any Java object. The word 'bean' is supposed to be a play on words, so don't let this confuse you.
- Better wording from Baeldung: "In Spring, a bean is an object that the Spring container instantiates, assembles, and manages".

Bean Factory vs. Application Context
- Application context loads many beans on Spring startup almost all weren't defined. It is 'eager', meaning it loads things into application context that you didn't ask for. This is used for web services.
- Contrast with the Bean factory, where you only load Beans that you need to use. This is used for CLI apps.
- The difference between the two is startup time. The amount of Beans in the Web Application Context doesn't impact performance once we begin getting requests.
- Good read, https://www.baeldung.com/spring-beanfactory-vs-applicationcontext

Controller 
- This is the topmost layer, called when a request comes for a particular REST API. The controller will process the REST API request, calls one or more services and returns an HTTP response to the client.
- Basic idea: receive HTTP requests and either forward the request and send an HTTP response.

DAO (data access layer)
- This provides an interface to connect with the database and access the data stored in the database. A single DAO class can deal with queries retrieving different types of entities.

Declarative Services
- Spring annotations used before methods to define which services can reference it. Spring provides abstraction and hides the details of incoming messages and calling the correct method.
- @Transactional was the example provided to me.

Dependency injection
- The basic idea of this is that Spring instantiates our object in memory that way when we create a new object we can plug arguments directly to copy in memory.
- Interfaces directly with ApplicationContext.

Git
- This is soemthing called a version control system used to track changes within a repo. You can create as many braches from the master branch and merge them seamlessly. 
- Using Git should be second nature to any one working on large scale projects.
- Idea was created my Linus Torvalds.

Git Bash 
- App for the Windows OS that provides emulation for Git. I believe that Git can't work natively on Windows, since Windows strayed away from its UNIX roots.
- Linux or MacOS users wouldn't need to install Git Bash.

Gradle
- Build tool.

Group
- This is the base package name indicating the organization or group that is creating the project. This follows the Java package naming convention. You can keep it as a default value.

index.html
- Special file that acts as a home page. When someone enters the hostname with no parameters Spring serches for files labeled as index.html and serves it if found. Otherwise, the controller returns an Error 404 message.

Integration testing
- Testing pieces of a Spring app and verifying they have an expected output. Typically, integration tests will test a single class with each method testing a single functionality.

JDK (Java Development Kit)
- The Java Development Kit is a distribution of Java Technology by Oracle Corporation. It implements the Java Language Specification and the Java Virtual Machine Specification and provides the Standard Edition of the Java API.

Junit
- Is the most popular testing framework in Java and has been for a long time.
- Jupiter was released with junit ver. 5 and provides extra functionality. The keyword "Jupiter" is a dead giveaway that we are working with Junit 5.
- Spring has Junit built-in to the framework and is expecting the project to be tested with it. Note that Spring was designed to have automatic tests ran.

JPA (Java Persistence API) 
- This is a Java Specification that maps Java objects to database entities, also known as ORM (Object Relational Mapping). 
- Digging a bit deeper, the Spring Data JPA is an abstraction over JPA that provides utility methods for various operations on databases such as creating, deleting, and updating a record. It eliminates the need of writing queries as you do with JDBC.

Maven
- Build tool.

Model 
- The model contains all the Java objects that will be mapped to the database table using. The DAO will fetch the data from the database and populate the respective model with that data and return it to the service layer and vice versa.
- Basic idea: use a templating engine like Thymeleaf to plug-in data to the file sent in response.
- Model is called from the controller and the view handles the plugging-in of data.

Mockito
- Mocking framework used for testing and can implement specific features of a class.

MVC (Model View Controller)
- Software design pattern where

Name
- This is the display name for your application which Spring Boot will use when creating the entry point for the project. You can keep it the same as the artifact name, "employee".

Repository 
- This layer is similar to the DAO layer which connects to the database and accesses the data. However the repository layer provides a greater abstraction compared to the DAO layer. Every class is responsible for accessing and manipulating one entity. This tutorial will use the repository layer.

Service 
- This layer calls the DAO layer to get the data and perform business logic on it. The business logic in the service layer could be - performing calculations on the data received, filtering data based on some logic, etc.
