$ErrorActionPreference = "Stop"

$scriptRoot = Split-Path -Parent $PSCommandPath
$outputJar = Join-Path $scriptRoot "backported_updates.jar"
$gradleWrapper = Join-Path $scriptRoot "gradlew.bat"

if (-not (Test-Path $gradleWrapper)) {
    throw "Gradle wrapper not found at '$gradleWrapper'."
}

# Hardcoded Java 21 path found on system
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.10.7-hotspot"
if (Test-Path $env:JAVA_HOME) {
    $env:Path = "$($env:JAVA_HOME)\bin;$($env:Path)"
    Write-Host "Using Java 21 from: $env:JAVA_HOME"
} else {
    throw "Java 21 not found at expected path: $env:JAVA_HOME"
}

Push-Location $scriptRoot
try {
    Write-Host "Starting build process..."
    & $gradleWrapper --no-daemon clean buildModJar
    if ($LASTEXITCODE -ne 0) {
        throw "Gradle build failed with exit code $LASTEXITCODE"
    }
} finally {
    Pop-Location
}

if (-not (Test-Path $outputJar)) {
    throw "Build completed but jar was not found at '$outputJar'."
}

Write-Host "Built merged jar via Gradle: $outputJar"
Get-Item $outputJar | Select-Object Name, Length, LastWriteTime