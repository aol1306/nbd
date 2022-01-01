db.people.mapReduce(
    // map
    function() {
        var value = {
            weight: this.weight,
            height: this.height,
        }
        emit(this.sex, value)
    },
    // reduce
    function(keyId, value) {
        ret = {
            avgWeight: 0, avgHeight: 0
        }
        for ( var i=0; i < value.length; i++) {
            ret.avgWeight += value[i].weight
            ret.avgHeight += value[i].height
        }
        ret.avgWeight /= value.length
        ret.avgHeight /= value.length
        return ret
    },
    { out: "MR1" }
)

printjson(db.MR1.find().toArray())
