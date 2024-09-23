# simpleshop

## Description

**A simple e-commerce web application**

## Tech Stack

- **Java**
- **React**
- **TypeScript**
- **HTML**
- **SASS**

## Frameworks & Libraries

- **Spring Boot**
- **Node.js**

## Database

- **MongoDB**

## Build Tools

- **Gradle**
- **Docker**

## Development Tools

- **IntelliJ IDEA**
- **MongoDB Compass**

## Prerequisites

- Windows 10 or above
- Java 17 or above
- Docker Desktop
- Gradle
- MongoDB
- Intellij (or your favourite IDE)

## How to Run

- Clone this project
- Open intellij and wait for indexing finishes
- Run->Edit Configuration->Spring Boot
- Run->Edit Configuration->Docker Compose->link *docker-compose.yml* file
- Run->Edit Configuration->Compound->choose *docker compose* and *spring boot*
- Open Docker Desktop, and open a terminal (not Powershell) with administrator privilege, and run

  `docker network create simpleShopNetwork` to create a network, then

  `docker run --name simpleShop -d --network simpleShopNetwork -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=test -v YOUR_PREFERRED_DATA_LOCATION:/data/db mongo
` to create a container, an image and a volume. Replace *YOUR_PREFERRED_DATA_LOCATION* to a position on your disk
- Hit run button in your intellij, and you are all set!
