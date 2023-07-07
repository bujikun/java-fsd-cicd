#get the image of the maven-JDK version
FROM maven
#path of the working directory
WORKDIR /app
#copy the maven wrappers and pom.xl into the working directory
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
RUN mvn dependency:go-offline
RUN mvn install -DskipTests
#run the spring boot app
#ENTRYPOINT ["./mvnw","spring-boot:run"]
#start the application
ENTRYPOINT ["mvn", "spring-boot:run"]