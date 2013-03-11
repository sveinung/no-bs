#!/bin/bash

APP_NAME=no-bs
PID_FILE="/var/run/${APP_NAME}.pid"

PID=`cat ${PID_FILE}`
echo "Stopping app running with ${PID}"
test -z $PID || kill $PID
