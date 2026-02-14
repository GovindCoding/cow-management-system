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

2. This project has been migrated to Maven. See the "Run the full system (Maven)" section below for build and run instructions. You can build all services from the repository root using the aggregator POM:

```bash
mvn -T1C -DskipTests package
```

3. Start the discovery (Eureka) server first (recommended):

```bat
cd discovery-service
mvn spring-boot:run
```

4. Start all services using the helper script (Windows):

- The repository includes `run-all-services.bat` which starts each service in background using Maven and writes logs to `logs\<service>.log`.

```bat
cd D:\Java_Workspace\cow-management-system\cow-management-system
run-all-services.bat
```

5. If you prefer to run a single service interactively (Windows cmd):

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

6. Inspect logs (the helper script writes per-service logs into `logs/`):

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