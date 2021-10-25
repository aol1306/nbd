printjson(db.people.update(
        // query
        {
                "location.city": "Moscow"
        },
        // update
        {
                $set: { "location.city" : "Moskwa" }
        },
        {
                multi: true
        }
))