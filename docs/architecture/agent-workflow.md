# AI Agent Workflow

Requirement
→ repository-architect
→ microservice-architect (if boundaries are affected)
→ api-designer / database-agent
→ springboot-developer
→ test-engineer
→ security-agent
→ code-reviewer
→ devops-agent (when deployment/configuration changes)

Architecture agents and code-reviewer are read-only by default.

Example: cow vaccination management should normally extend `health-service`, unless an explicit architecture decision establishes an independently owned vaccination bounded context.
