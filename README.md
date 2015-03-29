# Payments project with Spring and Hibernate integration.

 Spring-Hibernate application. Spring MVC application is using MySQL database. The DAO implementation uses Hibernate’s SessionFactory to query against the database.
 
 The following configuration approaches are used for this demo application:

    Spring MVC: Annotations for controller, DAO and Java-based configuration for bean definitions.
    Hibernate: Annotations mapping for model class.
    Web Application: Using Spring’s WebApplicationInitializer to bootstrap the Spring Dispatcher Servlet.

There are two beans - User and Count. Application display list of users and count, also can add new users and edit existed. Also users can be deleted. In the near future to add new bean, such as Cards and new opportunities and interactions between entities represented.
