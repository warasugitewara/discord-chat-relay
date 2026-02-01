#!/bin/bash

# Discord Chat Relay Mod - Build Script
# Java 25対応ビルドスクリプト

echo ""
echo "========================================"
echo "Discord Chat Relay Mod - Build Script"
echo "========================================"
echo ""

# Check if gradlew exists
if [ ! -f "gradlew" ]; then
    echo "ERROR: gradlew not found!"
    exit 1
fi

# Parse arguments
if [ $# -eq 0 ]; then
    echo "Usage: ./build.sh [clean] [build] [run]"
    echo ""
    echo "Examples:"
    echo "  ./build.sh build           - Build the mod"
    echo "  ./build.sh clean           - Clean build artifacts"
    echo "  ./build.sh clean build     - Clean and build"
    echo ""
    exit 0
fi

# Run gradle with arguments
echo "Running: ./gradlew $@"
./gradlew "$@"

if [ $? -eq 0 ]; then
    echo ""
    echo "========================================"
    echo "Build completed successfully!"
    echo "========================================"
    if [ -f "build/libs/discord-chat-relay-1.0.0.jar" ]; then
        echo "Output: build/libs/discord-chat-relay-1.0.0.jar"
    fi
else
    echo ""
    echo "========================================"
    echo "Build FAILED!"
    echo "========================================"
    exit 1
fi
