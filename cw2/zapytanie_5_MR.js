db.people.mapReduce(
    // map
    function() {
        if (this.sex == "Female" && this.nationality == "Poland") {
            for (var i=0; i<this.credit.length; i++) {
                var value = {
                    currency: this.credit[i].currency,
                    balance: this.credit[i].balance,
                }
                emit(value.currency, value.balance)
            }
        }
    },
    // reduce
    function(keyId, values) {
        var avg = Array.sum(values)
        avg /= values.length
        return {
            avg: avg,
            sum: Array.sum(values)
        }
    },
    { out: "MR5" }
)

printjson(db.MR5.find().toArray())
