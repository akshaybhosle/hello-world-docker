From openjdk:8
copy ./target/hello-world-0.0.2-SNAPSHOT.jar hello-world-0.0.2-SNAPSHOT.jar
CMD ["java","-jar","hello-world-0.0.2-SNAPSHOT.jar"]
