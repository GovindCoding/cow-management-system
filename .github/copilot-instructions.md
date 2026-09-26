# Cow Management System — Copilot Instructions

## Current repository structure
This is a Maven multi-module Spring Boot project. Treat implemented code as the source of truth.

Current modules:
- discovery-service — service discovery
- gateway-service — API gateway / edge routing
- cow-service — cow domain
- milk-service — milk/production domain
- health-service — health records and health domain
- auth-service — authentication/authorization
- insurance-service — insurance domain

Supporting areas include `frontend-react/`, `docker/`, `postman/`, `DEPLOYMENT_GUIDE_AWS.md`, and `docs/SRS.md`.

## Critical architecture rule
The README/SRS may describe future or target services. Do NOT assume those services exist. Before creating a microservice:
1. inspect current modules;
2. identify the owning bounded context;
3. prefer extending an existing service;
4. create a new service only with explicit architectural justification.

## Build rules
- Use Maven for all backend builds and dependency management.
- Root Spring Boot version is currently 3.2.0.
- Do not perform unrelated framework/version upgrades.
- Preserve existing package, dependency, configuration, and test conventions.

## Domain ownership
- cow lifecycle/identity/status/breed -> `cow-service`
- milk production/collection -> `milk-service`
- health/treatment/vaccination -> `health-service`
- authentication/authorization/JWT -> `auth-service`
- insurance -> `insurance-service`
- routing/edge concerns -> `gateway-service`
- discovery -> `discovery-service`

Do not access another service's database directly.

## Engineering rules
- Keep controllers thin.
- Put business logic in service classes.
- Validate external input.
- Use DTOs at API boundaries where appropriate.
- Keep error handling consistent.
- Externalize configuration.
- Never commit or log secrets, passwords, or tokens.
- Consider indexes, transactions, pagination, and N+1 queries for persistence work.
- Preserve API compatibility unless a breaking change is explicitly approved.

## Recommended agent lifecycle
1. repository-architect
2. microservice-architect (when boundaries are involved)
3. api-designer / database-agent
4. springboot-developer
5. test-engineer
6. security-agent
7. code-reviewer
8. devops-agent (when deployment/configuration is affected)

Architecture agents and the code reviewer are read-only by default.
