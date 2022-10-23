
# E-Voting Back-End

This E-Voting back-end is built on a micro-service architecture, you can find more info below




## Services

#### Service Discovery
**Eureka** Server for service discovery

#### API Gateway
**Zuul** Running as a API Gateway and routing using Eureka's registry

#### Micro Services
| Service     | Port   | Database |Created By                                    |Documentation|
| :---------- | :----- | :------  | :------------------------------------------- |:--------------------------------------------------------------- |
| Auth        | `8080` |  H2      |[Yassine Trabelsi](https://github.com/Yass525)|[Click here](https://github.com/amineamri3/evoting-microservices)|
| User        | `8081` |  MySQL   |[Yassine Trabelsi](https://github.com/Yass525)|[Click here](https://github.com/amineamri3/evoting-microservices)|
| Election    | `8082` |  MySQL   |[Bader Moussa](https://github.com/moussabader)|[Click here](https://github.com/amineamri3/evoting-microservices)|
| Vote        | `8083` |  MongoDB |[Bader Moussa](https://github.com/moussabader)|[Click here](https://github.com/amineamri3/evoting-microservices)|
| Candidature | `8084` |  MySQL   |[Amine ElAmri](https://github.com/amineamri3) |[Click here](https://github.com/amineamri3/evoting-microservices)|
| Inscription | `8085` |  MongoDB |[Amine ElAmri](https://github.com/amineamri3) |[Click here](https://github.com/amineamri3/evoting-microservices)|
| Supervisors | `8086` |  MongoDB |[Asma Bensaid](https://github.com/Asma87-esp) |[Click here](https://github.com/amineamri3/evoting-microservices)|
| Report      | `8087` |  MongoDB |[Asma Bensaid](https://github.com/Asma87-esp) |[Click here](https://github.com/amineamri3/evoting-microservices)|
| Notification| `8088` |  MySQL   |[Ichraf Ayari](https://github.com/ichraf91)   |[Click here](https://github.com/amineamri3/evoting-microservices)|
| ChatBot     | `8089` |  MySQL   |[Ichraf Ayari](https://github.com/ichraf91)   |[Click here](https://github.com/amineamri3/evoting-microservices)|



## Usage/Examples
To run all services
```npm
code example
```

Running a specific service
```npm
code example
```

Running tests
```npm
code example
```



## Roadmap

- Load Balancing

- Add more integrations

