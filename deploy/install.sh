#!/bin/sh

APP_NAME=no-bs
APP_LOCATION="/opt/${APP_NAME}"
APP_JAR="/vagrant/build/libs/${APP_NAME}.jar"
LOGS=/var/log/${APP_NAME}
PID_FILE="/var/run/${APP_NAME}.pid"

echo "Create app folder"
sudo mkdir -p $APP_LOCATION

echo "Installing app..."
if [ -f $APP_JAR ]; then
  sudo cp $APP_JAR $APP_LOCATION
else
  echo "${APP_JAR} not found. Build it!"
  return 1
fi

echo "Installing service script..."
sudo cp /vagrant/deploy/init.d/no-bs /etc/init.d/

exit 0
