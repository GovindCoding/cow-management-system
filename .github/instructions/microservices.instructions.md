# Microservices Instructions

Current services:
`discovery-service`, `gateway-service`, `cow-service`, `milk-service`, `health-service`, `auth-service`, `insurance-service`.

Do not create a service merely because a feature has a separate noun. Determine domain ownership first. Avoid shared database access, hidden dependency chains, duplicated ownership, and unplanned distributed transactions.
