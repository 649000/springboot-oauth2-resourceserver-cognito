# Warranty Tracker API service
## Overview
A Spring Boot RESTful API service that helps to track the warranties of your products.

The objective of this project are:
1. Familiarize with the Spring Boot framework
2. Familiarise with building an OAuth2 resource server
3. Explore Identity as a Service products such as AWS Cognito

## Features
This API service document warranties of your products. Users are able to key in their products with the expected warranty expiry date and add details of the companies if technical support is needed. 

This project has also been deployed onto Railway. Railway is an infrastructure platform similar AWS. Railway was chosen because it provides free tier for hobbyist. 


#### Technologies
1. Spring Boot
2. Spring Security
3. Spring Boot OAuth2 Resource Server
4. Lombok
5. Maven
6. MapStruct
7. AWS Java SDK for Amazon DynamoDB 

## Running the project
AWS Access and Secret keys are required and must be set as an environment variable to run this app

Example on setting environment variable on macOS:
```
export aws_accesskey=<KEY GOES HERE>
export aws_secretkey=<KEY GOES HERE>
```

To run the service, navigate to the root of the project and execute the command

```
mvn spring-boot:run
```

## Reflection

This project is similar to the [Subtracker project](https://github.com/649000/subtracker-rest-api) I worked on. In this project, I am using AWS Cognito which is AWS' offering of Identity as a Service. The aim was to familiarise with AWS services which aid in my learning for my AWS certification.
