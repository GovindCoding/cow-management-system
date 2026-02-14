# discovery-service (Eureka)

Quick start

No database required for the discovery server.

Run locally (Windows cmd):

```bat
mvn spring-boot:run
```

Run locally (PowerShell):

```powershell
mvn spring-boot:run
```

Notes
- Service port: 8761
- Open the Eureka dashboard at `http://localhost:8761` once started.
- To start all services using the repo script: run `run-all-services.bat` from the project root (it will write logs to `logs\<service>.log`).
