@echo off
REM Discord Chat Relay - Command Line Build Script
REM Simple CLI build without IDE dependencies

setlocal enabledelayedexpansion

set JAVA_HOME=C:\Program Files\java\graalvm-jdk-21.0.9+7.1
set GRADLE_HOME=C:\gradle\gradle-8.8
set GRADLE_OPTS=-Xmx2g

echo.
echo ============================================================
echo Discord Chat Relay - CLI Build Script
echo ============================================================
echo.
echo Java Home: %JAVA_HOME%
echo Gradle: %GRADLE_HOME%
echo.

cd /d C:\Users\waras\Workspace\DiscordChatRelay

echo Running build...
echo.

call %GRADLE_HOME%\bin\gradle.bat build --no-daemon "-Dorg.gradle.java.home=%JAVA_HOME%"

if %ERRORLEVEL% equ 0 (
    echo.
    echo ============================================================
    echo BUILD SUCCESS!
    echo ============================================================
    echo.
    echo Output JAR: build\libs\discord-chat-relay-1.0.0.jar
    echo.
    if exist "build\libs\discord-chat-relay-1.0.0.jar" (
        dir build\libs\discord-chat-relay-1.0.0.jar
    )
) else (
    echo.
    echo ============================================================
    echo BUILD FAILED!
    echo ============================================================
    exit /b 1
)
