#!/bin/sh

APP_NAME=no-bs

if [ -z $1 ] || [ -z $2 ]; then
    echo "Usage: ./deploy.sh user host"
    exit 1
fi

USER=$1
HOST=$2
PORT=2222
SSH_SOCKET=~/.ssh/$USER@$HOST

ssh -M -f -N -p $PORT -o ControlPath=$SSH_SOCKET $USER@$HOST

scp -o ControlPath=$SSH_SOCKET build/libs/$APP_NAME.jar $USER@$HOST:/home/$USER/
rsync -e "ssh -o 'ControlPath=${SSH_SOCKET}'" \
    --recursive \
    --verbose \
    --delete \
    --executability \
    deploy/ $HOST:/home/$USER/deploy/
ssh -o ControlPath=$SSH_SOCKET -t $USER@$HOST "deploy/install.sh"

ssh -S $SSH_SOCKET -O exit $USER@$HOST

