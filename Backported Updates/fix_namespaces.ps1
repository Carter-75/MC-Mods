$ErrorActionPreference = "Stop"
$srcPath = Join-Path $PSScriptRoot "src\main\resources"
$countIwie = 0
$countVanilla = 0
$countCopper = 0
$filesChanged = [System.Collections.Generic.List[string]]::new()

Get-ChildItem -Path $srcPath -Recurse -File -Filter "*.json" | ForEach-Object {
    $file = $_.FullName
    $content = [System.IO.File]::ReadAllText($file, [System.Text.Encoding]::UTF8)
    if ($null -eq $content -or $content.Length -eq 0) { return }

    $newContent = $content

    $m1 = ([regex]"iwie:").Matches($newContent)
    if ($m1.Count -gt 0) {
        $countIwie += $m1.Count
        $newContent = $newContent.Replace("iwie:", "backported_updates:")
    }

    $m2 = ([regex]"vanillabackport:").Matches($newContent)
    if ($m2.Count -gt 0) {
        $countVanilla += $m2.Count
        $newContent = $newContent.Replace("vanillabackport:", "backported_updates:")
    }

    $m3 = ([regex]"copperagebackport:").Matches($newContent)
    if ($m3.Count -gt 0) {
        $countCopper += $m3.Count
        $newContent = $newContent.Replace("copperagebackport:", "backported_updates:")
    }

    if ($newContent -ne $content) {
        [System.IO.File]::WriteAllText($file, $newContent, [System.Text.Encoding]::UTF8)
        $filesChanged.Add($file)
    }
}

Write-Host "=== NAMESPACE REPLACEMENT COMPLETE ==="
Write-Host "iwie: replacements:           $countIwie"
Write-Host "vanillabackport: replacements: $countVanilla"
Write-Host "copperagebackport: replacements: $countCopper"
Write-Host "Total files modified: $($filesChanged.Count)"
Write-Host ""
Write-Host "--- Files modified ---"
foreach ($f in $filesChanged) {
    Write-Host $f
}
Write-Host "--- Verification: checking for remaining legacy namespaces ---"
$remaining = Get-ChildItem -Path $srcPath -Recurse -File -Filter "*.json" | Select-String -Pattern "iwie:|vanillabackport:|copperagebackport:" -SimpleMatch
if ($remaining.Count -eq 0) {
    Write-Host "PASS: No remaining legacy namespace references found."
} else {
    Write-Host "FAIL: $($remaining.Count) remaining legacy namespace references found:"
    $remaining | ForEach-Object { Write-Host "$($_.Filename):$($_.LineNumber): $($_.Line.Trim())" }
}
