#!/bin/sh

APP_NAME=no-bs
APP_LOCATION="/opt/${APP_NAME}"
APP_JAR="/vagrant/build/libs/${APP_NAME}.jar"

echo "Create app folder"
sudo mkdir -p $APP_LOCATION

echo "Installing app..."
if [ -f $APP_JAR ]; then
  sudo cp $APP_JAR $APP_LOCATION
else
  echo "${APP_JAR} not found. Build it!"
  return 1
fi
