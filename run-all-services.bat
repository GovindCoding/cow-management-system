@echo off
start cmd /k "cd eureka-server && gradlew bootRun"
timeout /t 5
start cmd /k "cd gateway-service && gradlew bootRun"
start cmd /k "cd cow-service && gradlew bootRun"
start cmd /k "cd insurance-service && gradlew bootRun"

:: This is also a comment
:: Each start cmd /k opens a new terminal and runs the service.
:: timeout /t 5 gives Eureka a few seconds to start before others register.
:: Usage:
:: Save as run-all-services.bat in your project root.
:: Double-click to run all services.