
# E-Voting Back-End

This E-Voting back-end is built on a micro-service architecture, you can find more info below




## Services

#### Service Discovery
**Eureka** Server for service discovery

#### API Gateway
**NodeJS** server running as a proxy/api-gateway

#### Micro Services
| Service | Port     | Database                |Created By                       |Documentation|
| :---------- | :----- | :------  | :------------------------------------------- |:--------------------------------------------------------------- |
| Auth        | `8000` |  H2      |[Yassine Trabelsi](https://github.com/Yass525)|[Click here](https://github.com/amineamri3/evoting-microservices)|
| User        | `8001` |  MySQL   |[Yassine Trabelsi](https://github.com/Yass525)|[Click here](https://github.com/amineamri3/evoting-microservices)|
| Election    | `8002` |  MongoDB |[Bader Moussa](https://github.com/moussabader)|[Click here](https://github.com/amineamri3/evoting-microservices)|
| Vote        | `8003` |  MySQL   |[Bader Moussa](https://github.com/moussabader)|[Click here](https://github.com/amineamri3/evoting-microservices)|
| Candidature | `8004` |  MySQL   |[Amine ElAmri](https://github.com/amineamri3) |[Click here](https://github.com/amineamri3/evoting-microservices)|
| Electeur    | `8005` |  MongoDB |[Amine ElAmri](https://github.com/amineamri3) |[Click here](https://github.com/amineamri3/evoting-microservices)|
| Data/Stats  | `8006` |  MongoDB |[Asma Bensaid](https://github.com/Asma87-esp) |[Click here](https://github.com/amineamri3/evoting-microservices)|
| LiveFeed    | `8007` |  MongoDB |[Asma Bensaid](https://github.com/Asma87-esp) |[Click here](https://github.com/amineamri3/evoting-microservices)|
| ChatBot     | `8008` |  MySQL   |[Ichraf Ayari](https://github.com/ichraf91)   |[Click here](https://github.com/amineamri3/evoting-microservices)|
| Notification| `8009` |  MySQL   |[Ichraf Ayari](https://github.com/ichraf91)   |[Click here](https://github.com/amineamri3/evoting-microservices)|



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

