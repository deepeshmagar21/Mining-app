$pptx = 'C:\Users\user\Downloads\SampleMockup.pptx'
Add-Type -AssemblyName System.IO.Compression
$fs = New-Object System.IO.FileStream($pptx, [System.IO.FileMode]::Open, [System.IO.FileAccess]::Read, [System.IO.FileShare]::ReadWrite)
$zip = New-Object System.IO.Compression.ZipArchive($fs, [System.IO.Compression.ZipArchiveMode]::Read)
$slides = $zip.Entries | Where-Object { $_.FullName -match 'ppt/slides/slide\d+\.xml$' } | Sort-Object { [int]($_.FullName -replace '[^\d]', '') }
foreach ($e in $slides) {
    $stream = $e.Open()
    $reader = New-Object System.IO.StreamReader($stream)
    $text = $reader.ReadToEnd()
    $reader.Dispose()
    $stream.Dispose()
    Write-Host "=== $($e.FullName) ==="
    $matches = [regex]::Matches($text, '<a:t[^>]*>(.*?)</a:t>')
    $lines = @()
    foreach ($m in $matches) {
        $lines += $m.Groups[1].Value.Trim()
    }
    $lines -join ' | '
}
$zip.Dispose()
$fs.Dispose()
