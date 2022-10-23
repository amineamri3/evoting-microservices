
# E-Voting Project

This project consists of creating a web application that allows for online voting, this project was built on a micro service architecture.



## Our Team members

- [Yassine Trabelsi](https://github.com/Yass525)
- [Bader Moussa](https://github.com/moussabader)
- [Amine ElAmri](https://github.com/amineamri3)
- [Asma Bensaid](https://github.com/Asma87-esp)
- [Ichraf Ayari](https://github.com/ichraf91)
## Technology stack

#### Frameworks
Our project is built mainly with **Spring Boot**, but we also have a service running in **NodeJS**.
#### Service Discovery
As this project is built on a micro-service architecture, Having a Service Discovery server is important, luckly **Eureka** Exists in the spring environment, it's a powerful and easy to implement tool developed by Netflix to dynamically register services and track their status.
#### Databases
We the following databases in this project:
- H2
- MySQL
- MongoDB
#### Authentification
We opted to use JWT as our mean of securing the communication, mainly as it's the easiest solution to implement across both Spring and NodeJS and because it's lightwight.
#### Routing
To make sure our solution is clean, maintainable and scalable we opted to use a API Gateway to route all our requests, We used **Zuul** in combination with **Eureka** to route requests dynamically to registered services.
#### DevOps
We used **Docker** to assure a smooth running environment, with each micro-service in a seperate container.

