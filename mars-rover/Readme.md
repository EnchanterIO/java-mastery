# How to build an executable jar file

./gradlew build

Generates an executable JAR file in: ./build/libs/*.jar

# How to run the application

./gradlew bootRun

# How to simulate Heroku locally

heroku local

# How to deploy to Heroku

heroku jar:deploy build/libs/inner-circle-0.0.0-SNAPSHOT.jar --app ll-inner-circle

Deploys the JAR file to a Heroku app called: "ll-inner-circle".

# How to configure the app:

Edit file: "./src/main/resources/application.properties"