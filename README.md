# Kafka event producer-consumer service

This is a simple springboot service to 
- Publish event to kafka using producer.
- Consume the events from kafka with a consumer.
- Save the consumed data in mongodb.

This save time to setup infra a docker-compose file has been provided for quick setup.
before running this service make sure to spin up this docker-compose so that the application has the needed dependencies.

Run ```docker-compose``` in the project directory

```
docker-compose up -d
```

Once the docker containers are running we can run our service.

The service provides to end points for **POST** and **GET** requests.

1. Publishing event to kafka: **POST** request

```
http://localhost:8080/kafka/publish
```

2. Retrieve saved data from mongo: **GET** request

```
http://localhost:8080/kafka/all/events
```

