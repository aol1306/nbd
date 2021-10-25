printjson(db.people.find(
    // query
    {
        "birth_date": { $gt: "2001-01-01", $lte: "2099-12-31" } 
    },
    // projection
    {
        "first_name": true,
        "last_name": true,
        "location.city": true
    }
).toArray())