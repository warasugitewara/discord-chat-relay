@echo off
REM Visual Studio Code Gradle Build Helper
REM This script helps setup VSCode environment for Gradle builds

setlocal enabledelayedexpansion

echo.
echo ============================================================
echo Discord Chat Relay - VSCode Setup Helper
echo ============================================================
echo.

REM Check if VSCode is installed
for /f "tokens=*" %%i in ('where code 2^>nul') do set VSCODE_PATH=%%i

if defined VSCODE_PATH (
    echo ✓ VSCode found: %VSCODE_PATH%
) else (
    echo × VSCode not found in PATH
    echo   Please install VSCode from https://code.visualstudio.com
    echo.
    pause
    exit /b 1
)

REM Check if Java 21+ is available
echo.
echo Checking Java...
C:\Program Files\java\graalvm-jdk-21.0.9+7.1\bin\java -version 2>&1 | findstr /R "version" >nul
if %ERRORLEVEL% equ 0 (
    echo ✓ Java 21 found
) else (
    echo × Java 21 not found
    exit /b 1
)

REM Open VSCode in current directory
echo.
echo Opening VSCode with Gradle project...
echo.
echo Next steps in VSCode:
echo   1. Wait for Java language server to load (takes 1-2 minutes)
echo   2. Press Ctrl+Shift+B to open tasks
echo   3. Select "gradle build"
echo   4. Wait for build to complete
echo.

cd /d C:\Users\waras\Workspace\DiscordChatRelay
code .

echo.
echo ✓ VSCode launched!
echo.
