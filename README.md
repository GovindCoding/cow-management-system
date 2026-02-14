===========================================================
Cow Management - Intelligent Cow Management System
===========================================================

CowManager is a modular, cloud-ready livestock management platform built using Spring Boot microservices. It enables dairy and cattle farms to efficiently manage cow health, breeding, milk production, feed inventory, staff, and calves through a scalable and data-driven architecture.

-----------------------------------------------------------
📦 Project Structure
-----------------------------------------------------------

Each module is a standalone Spring Boot microservice:
1. cow-service           - Manages cow profiles and lifecycle events
2. health-service        - Tracks vaccinations, illnesses, and vet visits
3. breeding-service      - Handles insemination, pregnancy, and calving
4. calf-service          - Manages calf registration, health, and growth tracking
5. milk-service          - Records milk yield and quality
6. feed-service          - Manages feeding schedules and nutrition plans
7. inventory-service     - Tracks feed, medicine, and supply stock
8. staff-service         - Manages farm staff, roles, schedules, and assignments
9. scheduler-service     - Automates recurring tasks (feeding, health checks, milking)
10. notification-service - Sends alerts and reminders
11. analytics-service    - Aggregates and visualizes farm KPIs
12. user-service         - Authentication and role-based access
13. api-gateway          - Centralized routing and security
14. service-registry     - Eureka or Consul for service discovery
15. config-server        - Centralized configuration management
16. user-service          - Manages user authentication and roles
17. notification-service - Sends alerts and reminders
18. analytics-service    - Aggregates and visualizes farm KPIs
19. insurance-service    - Manages insurance policies for cows
20. reporting-service    - Generates reports on farm operations
21. audit-service       - Tracks changes and actions for compliance
22. payment-service     - Manages payments for services and products
23. feedback-service    - Collects feedback from users and vets
24. training-service    - Manages training schedules and materials for staff
25. resource-service    - Manages resources like water, pasture, and equipment
26. weather-service     - Provides weather updates and forecasts
27. marketplace-service - Connects with local markets for selling produce
28. community-service  - Manages community interactions and events

-----------------------------------------------------------
🛠️ Tech Stack
-----------------------------------------------------------

- Java 21+
- Spring Boot 3.x
- Spring Cloud (Eureka, Config, Gateway)
- MySQL (for data storage)
- RabbitMQ or Kafka (optional)
- Docker, Kubernetes (for deployment)
- Prometheus + Grafana (monitoring)
- JWT for authentication

-----------------------------------------------------------
🚀 How to Run
-----------------------------------------------------------

1. Clone the repository:
   git clone https://github.com/GovindCoding/cowmanager.git

2. Build All Services
   ./gradlew clean build

3. Run Core Services
   cd config-server && ./gradlew bootRun
   cd ../service-registry && ./gradlew bootRun

4. Start the config-server:
   cd config-server
   ./gradlew bootRun

5. Start the service registry:
   cd service-registry
   ./gradlew bootRun

6. Start each microservice:
   cd <service-name>
   ./gradlew bootRun

7. Access the API Gateway:
   http://localhost:8080/

-----------------------------------------------------------
🔐 Default Credentials (for testing)
-----------------------------------------------------------

- Admin: admin@farmtech.com / admin123
- Vet: vet@farmtech.com / vet123
- Worker: worker@farmtech.com / worker123

-----------------------------------------------------------
📊 Features
-----------------------------------------------------------

- Cow lifecycle tracking with QR/RFID support
- Health monitoring and vaccination alerts
- Breeding cycle and calving management
- Calf registration, health tracking, and weaning schedules
- Milk yield tracking and analytics
- Feed scheduling and nutrition planning
- Feed and medicine inventory management
- Staff management: roles, shifts, task assignments
- Automated task scheduling (feeding, milking, health checks)
- Role-based access for admins, vets, and workers
- RESTful APIs with Swagger documentation
- Farm-wide analytics dashboard (milk yield, health KPIs, breeding success)

-----------------------------------------------------------
📈 Future Enhancements
-----------------------------------------------------------

- AI-based health anomaly detection
- IoT integration for real-time monitoring
- Mobile app for field workers
- Multilingual support (Marathi, Hindi, English)
- Integration with government livestock databases
- Facial recognition for cow identification
- Staff performance analytics and payroll integration

-----------------------------------------------------------
📚 Run the full system (Maven)
-----------------------------------------------------------

This project has been converted to use Maven for service builds and runs. The following explains how to build and start the core services locally and the environment variables required.

Required environment variables (recommended; defaults are provided in each service):
- DB_URL — Database JDBC URL (default: jdbc:mysql://localhost:3306/cow_db)
- DB_USERNAME — Database username (default: root)
- DB_PASSWORD — Database password (default: admin1234)

These environment variables are used by services that require a database (for example: `auth-service`, `cow-service`, `milk-service`, `health-service`, `insurance-service`). Services that do not use a database (for example: `discovery-service`) ignore these variables.

1) Build all services (from the repository root):

```bash
# from the project root (where this README.md lives)
mvn -T1C -DskipTests package
```

2) Start the discovery (Eureka) server first (recommended):

```bat
cd discovery-service
mvn spring-boot:run
```

3) Start all services using the helper script (Windows):

- The repository includes `run-all-services.bat` which starts each service in background using Maven and writes logs to `logs\<service>.log`.

```bat
cd D:\Java_Workspace\cow-management-system\cow-management-system
run-all-services.bat
```

4) If you prefer to run a single service interactively (Windows cmd):

```bat
set DB_URL=jdbc:mysql://localhost:3306/cow_db
set DB_USERNAME=root
set DB_PASSWORD=admin1234
cd auth-service
mvn spring-boot:run
```

PowerShell equivalent:

```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/cow_db"
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "admin1234"
cd auth-service
mvn spring-boot:run
```

5) Inspect logs (the helper script writes per-service logs into `logs/`):

```bat
type logs\discovery-service.log | more
type logs\auth-service.log | more
```

-----------------------------------------------------------
📝 Using a local .env file
-----------------------------------------------------------

For local development you can copy the example `.env.example` to a `.env` file and edit the values (recommended). Do **not** commit `.env` to source control.

Windows (cmd.exe):

```bat
copy .env.example .env
notepad .env  # edit and save
```

PowerShell:

```powershell
Copy-Item .env.example .env
notepad .env  # or use your preferred editor
```

After editing `.env` you can run the helper script which will load `.env` automatically:

```bat
run-all-services.bat
```

Notes & recommendations
- Do not commit production credentials. Use environment variables, a local `.env` tooling, or a secret manager for production/deployment.
- If you want the helper script to load a `.env` file, I can add a small loader to `run-all-services.bat` that sets environment variables from a `.env` file before launching services.
- If you want a multi-module aggregator `pom.xml` so `mvn -pl :all` or `mvn -am` can build/start everything in one command, I can add that as a next step.

-----------------------------------------------------------
📄 License
-----------------------------------------------------------

This project is licensed under the MIT License.

-----------------------------------------------------------
👨‍💻 Maintainer
-----------------------------------------------------------

FarmTech [cowmanager@farmtech.com]