#!/bin/sh
set -xe

docker exec -it pjatk-nbd-mongo sh -c 'for zapytanie in $(ls /data/zapytanie*.js) ; do num=$(echo $zapytanie | tr -dc "0-9"); mongo nbd $zapytanie > /data/wyniki_$num.json ; done'