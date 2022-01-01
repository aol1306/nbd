var result = db.people.aggregate([
    { $group: { _id: null, job: { $addToSet: "$job" } } }
])

printjson(result.toArray())
