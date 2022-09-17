## Docker

Build application docker 

```shell
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=dmytrowng/metrics-tutorial
```

Start docker images

```shell
docker compose up
```

### Grafana

Open Grafana home page: http://localhost:3000.

**Username**: admin

**Password**: pass

User dashboards:

- [Prometheus 2.0 Overview](https://grafana.com/grafana/dashboards/3662-prometheus-2-0-overview/)
- [Spring Boot 2.1 System Monitor](https://grafana.com/grafana/dashboards/11378-justai-system-monitor/)