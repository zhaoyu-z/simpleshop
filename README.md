# simpleshop

## Description

**A simple e-commerce web application**

## Languages

- **Java**
- **Node.js**
- **TypeScript**
- **HTML**
- **SASS**

## Frameworks & Libraries

- **Spring Boot**
- **React**

## Database

- **Postgresql**

## Build Tools

- **Gradle**
- **npm**
- **Docker**

## Development Tools

- **IntelliJ IDEA**
- **pgAdmin4**
- **Chrome**
- **Postman**

## Prerequisites

- **Windows 10 or above**
- **Java 17 or above**
- **Docker Desktop**
- **Gradle**
- **Postgresql**
- **Intellij** (or your favourite IDE)

## How to run for the first time

- Clone this project
- Open intellij and wait for indexing finishes
- Run->Edit Configuration->Spring Boot
- Run->Edit Configuration->Docker Compose->link *docker-compose.yml* file
- Run->Edit Configuration->Compound->choose *docker compose* and *spring boot*
- Open Docker Desktop, install `postgres` image and `pgadmin4` extension
- go to pgadmin4 extension, set the master password, register a new server with name `simpleshop`
- then go to connection tab, type `host.docker.internal` as host name, `55555` as port and change username/password to
  the one defined in `application.properties`
- check `save password` and hit save, you should now be able to see the database
- Hit run button in your intellij, and you are all set!
