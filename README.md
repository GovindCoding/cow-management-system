===========================================================
CowManager – Intelligent Cow Management System
===========================================================

CowManager is a modular, cloud-ready livestock management platform built using Spring Boot microservices. It enables dairy and cattle farms to efficiently manage cow health, breeding, milk production, feed inventory, staff, and calves through a scalable and data-driven architecture.

-----------------------------------------------------------
📦 Project Structure
-----------------------------------------------------------

Each module is a standalone Spring Boot microservice:
0. user-service          - Manages user authentication and roles
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
📄 License
-----------------------------------------------------------

This project is licensed under the MIT License.

-----------------------------------------------------------
👨‍💻 Maintainer
-----------------------------------------------------------

FarmTech [cowmanager@farmtech.com]