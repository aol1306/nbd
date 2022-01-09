#!/bin/sh
# riak-admin bucket-type create s18211 '{"props":{}}'
# riak-admin bucket-type activate s18211

# 1.
curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"a" : 1, "b": "a", "c": { "c1" : 1.4, "c2" : 2 }}' \
  http://localhost:8098/buckets/s18211/keys/record1?returnbody=true
echo

curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"a" : 2, "b": "b", "c": { "c1" : 1.4, "c2" : 2 }}' \
  http://localhost:8098/buckets/s18211/keys/record2?returnbody=true
echo

curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"a" : 3, "b": "c", "c": { "c1" : 1.4, "c2" : 2 }}' \
  http://localhost:8098/buckets/s18211/keys/record3?returnbody=true
echo

curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"a" : 4, "b": "d", "c": { "c1" : 1.4, "c2" : 2 }}' \
  http://localhost:8098/buckets/s18211/keys/record4?returnbody=true
echo

curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"a" : 5, "b": "e", "c": { "c1" : 1.4, "c2" : 2 }}' \
  http://localhost:8098/buckets/s18211/keys/record5?returnbody=true
echo

# 2.
curl -i http://localhost:8098/buckets/s18211/keys/record1?returnbody=true
echo

# 3.
curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"a" : 5, "b": "e", "c": { "c1" : 1.4, "c2" : 2 }, "d": "nowaWartosc"}' \
  http://localhost:8098/buckets/s18211/keys/record5?returnbody=true
echo

# 4.
curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"a" : 4, "c": { "c1" : 1.4, "c2" : 2 }}' \
  http://localhost:8098/buckets/s18211/keys/record4?returnbody=true
echo

# 5.
curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"a" : 333333, "b": "c", "c": { "c1" : 1.4, "c2" : 2 }}' \
  http://localhost:8098/buckets/s18211/keys/record3?returnbody=true
echo

# 6.
curl -i -X DELETE \
  http://localhost:8098/buckets/s18211/keys/record2?returnbody=true
echo

# 7.
curl -i http://localhost:8098/buckets/s18211/keys/record1111?returnbody=true
echo

# 8.
curl -i -X POST \
  -H "Content-Type: application/json" \
  -d '{"a" : 1234}' \
  http://localhost:8098/buckets/s18211/keys?returnbody=true
echo

# 9.
curl -i http://localhost:8098/buckets/s18211/keys/4ryv5CvoAPGCI1haxWFeJhPTV88
echo

# 10.
curl -X DELETE -i http://localhost:8098/buckets/s18211/keys/4ryv5CvoAPGCI1haxWFeJhPTV88
echo
