# Current Architecture

| Service | Responsibility |
|---|---|
| discovery-service | service discovery |
| gateway-service | edge routing |
| cow-service | cow domain |
| milk-service | milk/production domain |
| health-service | health domain |
| auth-service | authentication/authorization |
| insurance-service | insurance domain |

Supporting areas: `frontend-react/`, `docker/`, `postman/`, `DEPLOYMENT_GUIDE_AWS.md`, `docs/SRS.md`.

Documentation may describe future-state services. A service is considered implemented only when its module/code exists in the repository.

Cross-service data should move through APIs/events rather than direct database access.
