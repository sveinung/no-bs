#!/bin/bash
pushd /vagrant/infrastructure

sudo apt-get update

sudo apt-get --yes --quiet install openjdk-7-jre

pushd nginx
source init.sh
popd

popd
