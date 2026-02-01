@echo off
REM Build using direct Gradle - wrapper not needed
cd /d "%~dp0"
C:\gradle\gradle-8.8\bin\gradle.bat build
pause
