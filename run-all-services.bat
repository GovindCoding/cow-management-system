@echo off
:: Load environment variables from .env if present, otherwise from .env.example
setlocal enabledelayedexpansion
set ENV_FILE=%~dp0.env
if not exist "%ENV_FILE%" set ENV_FILE=%~dp0.env.example

necho Loading environment variables from %ENV_FILE%
for /f "usebackq tokens=* delims=" %%L in ("%ENV_FILE%") do (
    set "_line=%%L"
    rem skip empty lines and comments
    if not "!_line!"=="" (
        echo !_line! | findstr /b "#" >nul
        if errorlevel 1 (
            for /f "tokens=1* delims==" %%K in ("!_line!") do (
                set "key=%%K"
                set "val=%%L"
                rem remove possible surrounding quotes from val
                set "val=!_line:*==!"
                if "!val:~0,1!"=="\"" set "val=!val:~1,-1!"
                if "!val:~0,1!"=="'" set "val=!val:~1,-1!"
                setx "!key!" "!val!" >nul
                set "!key!=!val!"
            )
        )
    )
)

:: Create logs directory if it doesn't exist
if not exist "%~dp0logs" mkdir "%~dp0logs"

echo Starting services in background using Maven; logs will be in "%~dp0logs"
echo Discovery (Eureka): logs\discovery-service.log
start "discovery" /B cmd /c "cd discovery-service && mvn spring-boot:run > ..\logs\discovery-service.log 2>&1"
timeout /t 5
echo Gateway: logs\gateway-service.log
start "gateway" /B cmd /c "cd gateway-service && mvn spring-boot:run > ..\logs\gateway-service.log 2>&1"
echo Auth: logs\auth-service.log
start "auth" /B cmd /c "cd auth-service && mvn spring-boot:run > ..\logs\auth-service.log 2>&1"
echo Cow: logs\cow-service.log
start "cow" /B cmd /c "cd cow-service && mvn spring-boot:run > ..\logs\cow-service.log 2>&1"
echo Insurance: logs\insurance-service.log
start "insurance" /B cmd /c "cd insurance-service && mvn spring-boot:run > ..\logs\insurance-service.log 2>&1"
echo Milk: logs\milk-service.log
start "milk" /B cmd /c "cd milk-service && mvn spring-boot:run > ..\logs\milk-service.log 2>&1"
echo Health: logs\health-service.log
start "health" /B cmd /c "cd health-service && mvn spring-boot:run > ..\logs\health-service.log 2>&1"

echo All start commands issued. Use "type logs\<service>.log" or PowerShell Get-Content to view logs.
echo Example: type logs\discovery-service.log | more

endlocal

:: End of script
