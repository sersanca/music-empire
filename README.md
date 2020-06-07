
# ssanta Music Empire

Assignment has been created as Spring boot application using Java 11

The Rest API has been implemented using the Spring MVC pattern, decoupling as much as possible components to be scalable in the future.

The entry point can be found on the MusicController under web package. The controller uses a MusicService to collect and provide all the artist information required.

To collect all data required is needed to call 3 external Rest APIs, for that purpose the process has been decoupled into 3 different components that can be tested individually. The components are named Agents.

* ArtistAgent
* CoverAgent
* ArtistProfileAgent

The service MusicService injects the above agents to build the response.

To optimize the performance of the API it's being implemetned a cache mechanism the ehCache component. Note the caching setup is very basic. 

Note that the assignment does not require persistence, but the project structure has been prepared for it, whereby the package repositories will contain component to access the database and the domain package will contain the business model mapped to hibernate configs. As I think it is a best practice to decouple this model from the web model used to send/receive data (DTO).

# Requirements

The application uses a library Lombok  which I found very handy and useful, but if you wish to run the application on your develop environment it will require the following steps if you haven't configured already.

* Install lombok on your ide (eclipse, intellij,etc) from https://projectlombok.org
* Enable Annotation processing on the java compiler on the project or environment depending on what IDE your use, this setup is different.

# Execution
The API can be run by command :
  
   ./mvnw spring-boot:run

# Urls and examples
 
 To test the API has been using JUnit test including in the application and the tool Postman to perform real test on the API.
 
 Url API: http://localhost:8080/api/v1/artist{mbid}
 
 eg. http://localhost:8080/api/v1/artist/cc197bad-dc9c-440d-a5b5-d52ba2e14234
 
 
 Hope it works everything
 
 Cheers!!
 
 Sergio
 
