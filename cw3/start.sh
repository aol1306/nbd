#!/bin/sh
set -xe

docker run -d --env=NEO4J_AUTH=none --publish=7474:7474 --publish=7687:7687 -v `pwd`:/mydata --name="pjatk-nbd-neo4j" neo4j
#docker exec -it pjatk-nbd-neo4j bash
