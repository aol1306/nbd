db.people.mapReduce(
    // map
    function() {
        emit(null, this.job)
    },
    // reduce
    function(keyId, values) {
        var unique = [];
        values.forEach((value) => {
            if (!unique.includes(value)) {
                unique.push(value)
            }
        })
        return unique
    },
    { out: "MR3" }
)

printjson(db.MR3.find().toArray())
