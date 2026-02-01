@echo off
REM Discord Chat Relay Mod - Build Script
REM Java 25対応ビルドスクリプト

setlocal enabledelayedexpansion

echo.
echo ========================================
echo Discord Chat Relay Mod - Build Script
echo ========================================
echo.

REM Check if gradlew.bat exists
if not exist "gradlew.bat" (
    echo ERROR: gradlew.bat not found!
    exit /b 1
)

REM Parse arguments
if "%1"=="" (
    echo Usage: build.bat [clean] [build] [run]
    echo.
    echo Examples:
    echo   build.bat build           - Build the mod
    echo   build.bat clean           - Clean build artifacts
    echo   build.bat clean build     - Clean and build
    echo.
    exit /b 0
)

REM Run gradle with arguments
echo Running: gradlew.bat %*
call gradlew.bat %*

if %ERRORLEVEL% equ 0 (
    echo.
    echo ========================================
    echo Build completed successfully!
    echo ========================================
    if exist "build\libs\discord-chat-relay-1.0.0.jar" (
        echo Output: build\libs\discord-chat-relay-1.0.0.jar
    )
) else (
    echo.
    echo ========================================
    echo Build FAILED!
    echo ========================================
    exit /b 1
)
