#!/bin/bash

APP_NAME=no-bs
APP_LOCATION="/opt/${APP_NAME}"
LOGS=/var/log/${APP_NAME}
PID_FILE="/var/run/${APP_NAME}.pid"

echo "Starting app..."
nohup java -jar "${APP_LOCATION}/${APP_NAME}.jar" &
PID=$!
echo "Started app with PID: ${PID}"
sudo echo "$PID" > sudo ${PID_FILE}

