# health-service

Quick start

Required environment variables (defaults shown):
- DB_URL (jdbc:mysql://localhost:3306/cow_db)
- DB_USERNAME (root)
- DB_PASSWORD (admin1234)

Run locally (Windows cmd):

```bat
set DB_URL=jdbc:mysql://localhost:3306/cow_db
set DB_USERNAME=root
set DB_PASSWORD=admin1234
mvn spring-boot:run
```

Run locally (PowerShell):

```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/cow_db"
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "admin1234"
mvn spring-boot:run
```

Notes
- Service port: 8083
- To start all services using the repo script: run `run-all-services.bat` from the project root (it will write logs to `logs\<service>.log`).
