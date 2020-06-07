
# Music Empire

Assignment has been created as Spring boot application using Java 11

The Rest API has been implemented using the Spring MVC pattern, decoupling as much as possible components to be scalable in the future.

The entry point can be found on the MusicController under web package. The controller uses a MusicService to collect and provide all the artist information required.

To collect all data required is needed to call 3 external Rest APIs, for that purpose the process has been decoupled into 3 different components that can be tested individually. The components are named Agents.

* ArtistAgent
* CoverAgent
* ArtistProfileAgent

The service MusicService injects the above agents to build the response.

To optimize the performance of the API it's being implemetned a cache mechanism the ehCache component. Note the caching setup is very basic. 

Note that the assignment does not require persistence, but if so, I would have the project structure organized using a package repositories containing the component to access the database and a domain package with the business model mapped to hibernate configs. As I think it is a good practice to decouple this business model from the web model used to send/receive data (DTO).

# Requirements

The application uses a library Lombok  which I found very handy and useful, but if you wish to run the application on your develop environment it will require the following steps if you haven't had configured yet.

* Install lombok on your ide (eclipse, intellij,etc) from https://projectlombok.org
* Enable Annotation processing on the java compiler on the project or environment depending on which IDE your use, this setup is different.

# Execution
The API can be run by command :
  
   ./mvnw spring-boot:run

# Urls and examples
 
 JUnit test are included to test the API. I have used the tool Postman to perform real test on the API.
 
 Url API: http://localhost:8080/api/v1/artist{mbid}
 
 eg. http://localhost:8080/api/v1/artist/cc197bad-dc9c-440d-a5b5-d52ba2e14234
 
 
 Hope it works everything
 
 Cheers!!
 
 Sergio
 
