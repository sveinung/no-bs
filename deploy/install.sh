#!/bin/bash

pushd /vagrant/

source deploy/daemon-functions.sh

APP_JAR="/vagrant/build/libs/${APP_NAME}.jar"
APP_LIB_DIR="${APP_LOCATION}/lib"

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

sudo mkdir -p $APP_LIB_DIR
sudo cp deploy/daemon-functions.sh $APP_LIB_DIR/

popd

exit 0
