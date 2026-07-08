# Test Script for FreshAnimations and PacksMod

$RootDir = Get-Location
$FreshAnimationsDir = Join-Path $RootDir "FreshAnimations"
$PacksModDir = Join-Path $RootDir "PacksMod"
$RunDir = Join-Path $FreshAnimationsDir "run"
$ModsDir = Join-Path $RunDir "mods"

Write-Host "Building PacksMod..." -ForegroundColor Cyan
Set-Location $PacksModDir
./gradlew build
if ($LASTEXITCODE -ne 0) { Write-Error "PacksMod build failed!"; exit 1 }

Write-Host "Building FreshAnimations..." -ForegroundColor Cyan
Set-Location $FreshAnimationsDir
./gradlew build
if ($LASTEXITCODE -ne 0) { Write-Error "FreshAnimations build failed!"; exit 1 }

# Setup Run Directory
if (-not (Test-Path $ModsDir)) {
    New-Item -ItemType Directory -Force -Path $ModsDir
}

# Copy PacksMod Jar to FA Run Mods
$PMJar = Get-ChildItem "$PacksModDir/build/libs/PacksMod-*.jar" | Where-Object { $_.Name -notmatch "sources" } | Select-Object -First 1
if ($PMJar) {
    Write-Host "Copying $($PMJar.Name) to run/mods..." -ForegroundColor Green
    Copy-Item $PMJar.FullName -Destination $ModsDir -Force
} else {
    Write-Error "Could not find PacksMod jar!"
    exit 1
}

# Copy FA Jar (Optional, since we runClient FA source, but good for completeness if we ran a standalone loader)
# Note: running ./gradlew runClient in FA automatically includes FA source on classpath.
# But "playrun" might imply a standalone run folder. 
# However, runClient is easiest.

Write-Host "Launching Minecraft with Mod Menu..." -ForegroundColor Magenta
Set-Location $FreshAnimationsDir
# runClient task handles Mod Menu download via build.gradle dependencies
./gradlew runClient
