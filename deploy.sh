#!/bin/sh

APP_NAME=no-bs

USER=vagrant
HOST=localhost
PORT=2222
SSH_SOCKET=~/.ssh/$USER@$HOST

ssh -M -f -N -p $PORT -o ControlPath=$SSH_SOCKET $USER@$HOST

scp -o ControlPath=$SSH_SOCKET build/libs/$APP_NAME.jar $USER@$HOST:/home/$USER/

ssh -S $SSH_SOCKET -O exit $USER@$HOST

