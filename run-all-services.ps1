<#
PowerShell helper to start all services using Maven. It loads environment variables from `.env` (or `.env.example` if `.env` is missing), creates a `logs` directory, and starts each service in its own background process using `cmd.exe /c`.
#>

$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Definition
Set-Location $ScriptDir

# Determine env file
$envFile = Join-Path $ScriptDir '.env'
if (-Not (Test-Path $envFile)) {
    $envFile = Join-Path $ScriptDir '.env.example'
}

Write-Host "Loading environment variables from: $envFile"
if (Test-Path $envFile) {
    Get-Content $envFile | ForEach-Object {
        $line = $_.Trim()
        if ($line -eq '' -or $line.StartsWith('#')) { return }
        $idx = $line.IndexOf('=')
        if ($idx -lt 0) { return }
        $key = $line.Substring(0,$idx).Trim()
        $val = $line.Substring($idx+1).Trim().Trim('"', "'")
        if ($key -ne '') {
            Write-Host "Setting $key"
            [System.Environment]::SetEnvironmentVariable($key, $val, [System.EnvironmentVariableTarget]::Process)
        }
    }
} else {
    Write-Host "No env file found at $envFile; continuing with existing environment variables."
}

# Ensure logs directory exists
$logsDir = Join-Path $ScriptDir 'logs'
if (-Not (Test-Path $logsDir)) { New-Item -ItemType Directory -Path $logsDir | Out-Null }

# Services to start (in order)
$services = @( 'discovery-service', 'gateway-service', 'auth-service', 'cow-service', 'insurance-service', 'milk-service', 'health-service' )

foreach ($svc in $services) {
    $svcDir = Join-Path $ScriptDir $svc
    if (-Not (Test-Path $svcDir)) {
        Write-Host ("Skipping {0}: directory not found at {1}" -f $svc, $svcDir) -ForegroundColor Yellow
        continue
    }

    $logFile = Join-Path $logsDir "$svc.log"
    $cmd = "cd /d `"$svcDir`" && mvn spring-boot:run > `"$logFile`" 2>&1"
    Write-Host ("Starting {0} -> {1}" -f $svc, $logFile)
    Start-Process -FilePath "cmd.exe" -ArgumentList "/c $cmd" -WindowStyle Hidden
    Start-Sleep -Seconds 5
}

Write-Host ("All start commands issued. Check logs in: {0}" -f $logsDir) -ForegroundColor Green

# EOF
