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

2. Build all backend services from the repository root:
   mvn clean package

3. Start each service in a separate terminal from the repository root:
   mvn -pl discovery-service spring-boot:run
   mvn -pl gateway-service spring-boot:run
   mvn -pl cow-service spring-boot:run
   mvn -pl milk-service spring-boot:run
   mvn -pl health-service spring-boot:run
   mvn -pl auth-service spring-boot:run
   mvn -pl insurance-service spring-boot:run

4. Access the API Gateway:
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