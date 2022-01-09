import requests
import json

headers = {'Content-type': 'application/json'}

# put
obj = {"name" : "Antonio", "age": 123}
r = requests.put("http://localhost:8098/buckets/s18211/keys/record1?returnbody=true", data=json.dumps(obj), headers=headers)
print("PUT")
print(r.text)

# get & print
r = requests.get("http://localhost:8098/buckets/s18211/keys/record1?returnbody=true")
print("GET")
print(r.text)

# modify
obj = {"name" : "Antonio", "age": 12}
r = requests.put("http://localhost:8098/buckets/s18211/keys/record1?returnbody=true", data=json.dumps(obj), headers=headers)
print("PUT")
print(r.text)

# get & print
r = requests.get("http://localhost:8098/buckets/s18211/keys/record1?returnbody=true")
print("GET")
print(r.text)

# delete
r = requests.delete("http://localhost:8098/buckets/s18211/keys/record1?returnbody=true")
print("DELETE")
print(r.text)

# get
r = requests.get("http://localhost:8098/buckets/s18211/keys/record1?returnbody=true")
print("GET")
print(r.text)
