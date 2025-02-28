# Project Setup Guide

## Requirements
- Docker
- Docker Compose
- JDK 21 (Amazon Corretto 21)

## Steps to Run the Project

1. Ensure that you have Docker, Docker Compose, and JDK 21 (Amazon Corretto 21) installed.

2. Build the project to generate the JAR file:

   ./gradlew build

3. Build the Docker images:

   docker-compose build

4. Start the project using Docker Compose:

   docker-compose up

5. The project will be accessible at `http://localhost:8080`.

- To remove the containers:

  docker-compose down
