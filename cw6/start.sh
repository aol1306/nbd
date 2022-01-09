#!/bin/sh
docker run --name=pjatk-nbd-riak -d -p 8087:8087 -p 8098:8098 basho/riak-kv
