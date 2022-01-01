db.people.mapReduce(
    // map
    function() {
        for (var i=0; i<this.credit.length; i++) {
            var value = {
                currency: this.credit[i].currency,
                balance: this.credit[i].balance,
            }
            emit(value.currency, value.balance)
        }
    },
    // reduce
    function(keyId, value) {
        return Array.sum(value)
    },
    { out: "MR2" }
)

printjson(db.MR2.find().toArray())
