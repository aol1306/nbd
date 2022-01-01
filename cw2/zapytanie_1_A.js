// convert to number
/*
db.people.find().forEach(function(data) {
    db.people.update({
        _id: data._id,
    }, {
        $set: {
            weight: parseFloat(data.weight)
            height: parseFloat(data.height)
        }
    });
})
*/

var result = db.people.aggregate([
    { $group: { _id: "$sex", avgWeight: { $avg: "$weight" }, avgHeight: { $avg: "$height" } } }
])

printjson(result.toArray())
