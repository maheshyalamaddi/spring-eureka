## ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) spring-eureka
A simple demo demonstrating usage of Netflix Eureka open source library service registry and discovery.

[working screenshot at start] (https://github.com/maheshyalamaddi/spring-eureka/blob/master/EurekaServerAtstart.jpg)

[working screenshot After Service Start](https://github.com/maheshyalamaddi/spring-eureka/blob/master/AfterUserService%20Start.jpg)

[](https://github.com/maheshyalamaddi/spring-eureka/blob/master/AfterUserService%20Start.jpg)
Netflix Eureka Service Registry Server  : This microservice will provide the service registry and discovery server.

Login Microservice : Which will give authentication based on User entity. It will be a rest based service and most importantly it 	will be a eureka client service, which will talk with eureka service to register itself in the service registry.

User Service : A sample rest ervice – and it will invoke Login service with service look up mechanism. We will not use absolute URL 	of Login service to interact with that service.

## ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) Getting Started
### Built with
	* Java 1.8+
	* Windows
	* Spring Boot 2.1.2.RELEASE+
	* Spring Cloud Greenwich.RELEASE+
	* Maven 3.0+

### Get it live
	* Ensure the Java and Maven is already setup in workstation, If not run 'mvnw.cmd' to add the necessary software.
	* Import this as Maven project in your favourite IDE and run this as "clean install spring-boot:run" OR "clean install"	

Step 1 :
	Start the application "spring-eureka-server" as spring boot application. Open browser and go to http://localhost:8761/,
	At this point no service is registered here which is expected and once we will spin up the client services, this server will automatically updated with the details of the client services.
	
Step 2 :
	Start the project "spring-eureka-user-service" as spring boot application. Now verify that this service has been registered in 	Eureka server automatically. Go to Eureka service console and refresh the page. Now if everything goes well, we will see one entry 	for user-service in the eureka service console. This indicates that both Eureka server and client are aware each other.
	Verify the /getUserDetailsForLogin/{privileged} endpoint is up and running. Go to browser and go to 	http://localhost:8098/getUserDetailsForLogin/Admin, it will give the User details for a particular Admin privileged.
	
Note : Here privileged is either Admin or NonAdmin
	
Step 3 :
	Now Start the "spring-eureka-login-service" service as well. All three services are started. Check the eureka server console. Both 	the user and login services must be registered there.
	This login service discover and invoke user-service without hardcoded URL path.
	Go to browser and go to http://localhost:9098/getLoginUserDetails/{privileged}, it will give the school details for a particular 	privileged user login details. We have invoked user service internally.
