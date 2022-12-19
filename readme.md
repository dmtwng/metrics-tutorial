Tutorial project on software monitoring topic.

---

## Docker Compose

Start docker compose from root directory:

```shell
docker compose up
```

`docker-compose.yaml` contains definitions for 3 containers:
 
- **Tutorial Application**: Java Spring Boot Application with Actuator and set of custom metrics;

  Actuator endpoint: http://localhost:8080/actuator

- **Prometheus** with scraper configured to scrape metrics from application and itself;

  Home page: http://localhost:9090/graph

- **Grafana** with configured Prometheus as a data source and few dashboards.

  Grafana home page: http://localhost:3000.

  **Username**: admin

  **Password**: pass

  Used dashboards:

  - [Prometheus 2.0 Overview](https://grafana.com/grafana/dashboards/3662-prometheus-2-0-overview/)
  - [Spring Boot 2.1 System Monitor](https://grafana.com/grafana/dashboards/11378-justai-system-monitor/)

## Application

Docker images of application stored [here](https://hub.docker.com/repository/docker/dmtwng/metrics-tutorial).

Build application docker image locally: 

```shell
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=dmtwng/metrics-tutorial
```
