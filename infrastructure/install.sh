#!/bin/bash
pushd /vagrant/infrastructure

sudo apt-get update

sudo apt-get --yes --quiet install openjdk-7-jre

source nginx/init.sh

popd
