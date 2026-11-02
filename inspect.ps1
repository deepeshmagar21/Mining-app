$pptx = 'C:\Users\user\Downloads\SampleMockup.pptx'
Add-Type -AssemblyName System.IO.Compression
Add-Type -AssemblyName System.IO.Compression.FileSystem
$fs = New-Object System.IO.FileStream($pptx, [System.IO.FileMode]::Open, [System.IO.FileAccess]::Read, [System.IO.FileShare]::ReadWrite)
$zip = New-Object System.IO.Compression.ZipArchive($fs, [System.IO.Compression.ZipArchiveMode]::Read)
foreach ($e in $zip.Entries) {
    if ($e.FullName -like 'ppt/slides/*.xml') {
        $stream = $e.Open()
        $reader = New-Object System.IO.StreamReader($stream)
        $text = $reader.ReadToEnd()
        $reader.Dispose()
        $stream.Dispose()
        Write-Host "============================="
        Write-Host "FILE: $($e.FullName)"
        Write-Host "============================="
        $matches = [regex]::Matches($text, '<a:t[^>]*>(.*?)</a:t>')
        foreach ($m in $matches) {
            Write-Host "  $($m.Groups[1].Value)"
        }
    }
}
$zip.Dispose()
$fs.Dispose()
