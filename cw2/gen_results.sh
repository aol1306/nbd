#!/bin/sh
set -xe

docker exec -it pjatk-nbd-mongo sh -c 'for zapytanie in $(ls /data/zapytanie*A.js) ; do num=$(echo $zapytanie | tr -dc "0-9"); mongo nbd $zapytanie > /data/wyniki_${num}_A.json ; done'
docker exec -it pjatk-nbd-mongo sh -c 'for zapytanie in $(ls /data/zapytanie*MR.js) ; do num=$(echo $zapytanie | tr -dc "0-9"); mongo nbd $zapytanie > /data/wyniki_${num}_MR.json ; done'
