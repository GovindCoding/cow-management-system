# Security Instructions

Authentication is centered in `auth-service`; `gateway-service` is the edge/security enforcement point where applicable. Never commit secrets. Never log credentials or JWTs. Check authorization, CORS, public exposure, validation, and sensitive error leakage when endpoints change.
