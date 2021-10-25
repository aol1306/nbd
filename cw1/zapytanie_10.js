printjson(db.people.update(
        // query
        {
                "job": "Editor"
        },
        // update
        {
                $unset: { "email" : "" }
        },
        {
                multi: true
        }
))