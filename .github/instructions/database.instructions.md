# Database Instructions

Domain data belongs to its owning service. Inspect existing JPA entities/repositories before adding persistence. Define constraints and useful indexes, avoid N+1 queries, keep transaction boundaries around business operations, and never query another service's database directly.
