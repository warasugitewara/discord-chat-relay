@echo off
REM 直接Gradleを使ってビルド（wrapper不要）
cd /d "%~dp0"
C:\gradle\gradle-8.8\bin\gradle.bat %*
pause
