printjson(db.people.update(
        // query
        {
                "first_name": "Antonio"
        },
        // update
        {
                $set: { "hobby" : "pingpong" }
        },
        {
                multi: true
        }
))
