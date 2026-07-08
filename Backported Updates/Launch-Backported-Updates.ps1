$ErrorActionPreference = "Stop"

$scriptRoot = Split-Path -Parent $PSCommandPath
$workspace = Join-Path $scriptRoot "test_instance_v2"
$modsDir = Join-Path $workspace "mods"
$mergedJarPath = Join-Path $scriptRoot "backported_updates.jar"

$pythonCommand = Get-Command py -ErrorAction SilentlyContinue
if (-not $pythonCommand) {
    $pythonCommand = Get-Command python -ErrorAction SilentlyContinue
}

if (-not $pythonCommand) {
    throw "Python was not found in PATH. Install Python or make the launcher available as 'py' or 'python'."
}

if (-not (Test-Path $mergedJarPath)) {
    Write-Host "Error: The merged jar was not found at '$mergedJarPath'." -ForegroundColor Red
    Write-Host "Please run '.\Build-Backported-Updates.ps1' to build the project first." -ForegroundColor Yellow
    Read-Host "Press Enter to exit..."
    exit 1
}

Write-Host "Cleaning mods folder..."
if (-not (Test-Path $workspace)) {
    New-Item -ItemType Directory -Force -Path $workspace | Out-Null
}
if (Test-Path $modsDir) {
    Remove-Item "$modsDir\*" -Force -Recurse
} else {
    New-Item -ItemType Directory -Force -Path $modsDir | Out-Null
}

Write-Host "Copying merged jar to mods folder: $mergedJarPath"
Copy-Item $mergedJarPath "$modsDir\" -Force

Write-Host "Fetching latest Fabric API for 1.21.1 from Modrinth..."
try {
    $apiUrl = 'https://api.modrinth.com/v2/project/fabric-api/version?game_versions=["1.21.1"]'
    $versions = Invoke-RestMethod -Uri $apiUrl
    $latest = $versions[0].files[0]
    $apiPath = "$modsDir\$($latest.filename)"
    
    if (!(Test-Path $apiPath)) {
        Write-Host "Downloading $($latest.filename)..."
        Invoke-WebRequest -Uri $latest.url -OutFile $apiPath
    } else {
        Write-Host "Fabric API already downloaded."
    }
} catch {
    Write-Host "Could not fetch Fabric API automatically. If the game crashes on startup, please drop Fabric API 1.21.1 into $modsDir manually." -ForegroundColor Yellow
}

Write-Host "Installing/Upgrading PortableMC..."
& $pythonCommand.Source -m pip install portablemc --quiet

Write-Host "Launching Minecraft 1.21.1 with Fabric! Please wait while it downloads any necessary assets..."
& $pythonCommand.Source -m portablemc --work-dir $workspace start fabric:1.21.1

Write-Host "Game closed."
Read-Host "Press Enter to exit..."
