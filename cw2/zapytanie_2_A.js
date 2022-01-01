// convert to number
/*db.people.find().forEach(function(data) {
    db.people.update({
        _id: data._id,
    }, {
        $set: {
            credit: data.credit.map(function(credit) {
                return {
                    type: credit.type,
                    number: credit.number,
                    currency: credit.currency,
                    balance: parseFloat(credit.balance)
                };
            })
        }
    });
})*/

var result = db.people.aggregate([
    { $unwind: "$credit" },
    { $group: { _id: "$credit.currency", sum: { $sum: "$credit.balance" } } }
])

printjson(result.toArray())
