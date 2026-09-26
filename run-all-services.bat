@echo off
start "Discovery Service" /D "%~dp0" cmd /k "mvn -pl discovery-service spring-boot:run"
timeout /t 5
start "Gateway Service" /D "%~dp0" cmd /k "mvn -pl gateway-service spring-boot:run"
start "Cow Service" /D "%~dp0" cmd /k "mvn -pl cow-service spring-boot:run"
start "Insurance Service" /D "%~dp0" cmd /k "mvn -pl insurance-service spring-boot:run"

:: Each start command opens a terminal for one Maven service.