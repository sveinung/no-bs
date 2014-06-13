#!/bin/bash

source deploy/constants.sh

APP_JAR="${APP_NAME}.jar"
APP_LIB_DIR="${APP_LOCATION}/lib"

echo "Create app folder"
sudo mkdir -p $APP_LOCATION

echo "Installing service script..."
sudo cp deploy/init.d/no-bs /etc/init.d/
sudo mkdir -p $APP_LIB_DIR
sudo cp deploy/constants.sh $APP_LIB_DIR/

sudo service no-bs stop

echo "Installing app..."
if [ -f $APP_JAR ]; then
  sudo cp $APP_JAR $APP_LOCATION
else
  echo "${APP_JAR} not found. Build it!"
  return 1
fi

sleep 5
sudo service no-bs start

