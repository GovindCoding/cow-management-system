# gateway-service

Quick start

Required environment variables (defaults shown for downstream services):
- DB_URL, DB_USERNAME, DB_PASSWORD — used by downstream services, not the gateway itself.

Run locally (Windows cmd):

```bat
mvn spring-boot:run
```

Run locally (PowerShell):

```powershell
mvn spring-boot:run
```

Notes
- Service port: 8080
- This gateway uses service discovery (Eureka). Make sure the discovery service is running at `http://localhost:8761`.
- To start all services using the repo script: run `run-all-services.bat` from the project root (it will write logs to `logs\<service>.log`).
