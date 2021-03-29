From openjdk:8
copy ./controller/target/hello-world-1.0.0.jar hello-world-1.0.0.jar
CMD ["java","-jar","hello-world-1.0.0.jar"]
