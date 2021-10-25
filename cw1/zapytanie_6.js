printjson(db.people.insert(
    {
        "sex" : "Male",
        "first_name" : "Jakub",
        "last_name" : "Dzieciątko",
        "job" : "Pentester",
        "email" : "email@email.com",
        "location" : {
                "city" : "Warsaw",
                "address" : {
                        "streetname" : "Union",
                        "streetnumber" : "88"
                }
        },
        "description" : "ac nibh fusce lacus purus aliquet at feugiat non pretium quis",
        "height" : "190.4",
        "weight" : "168.14",
        "birth_date" : "1997-11-04T22:35:37Z",
        "nationality" : "Poland",
        "credit" : [
                {
                        "type" : "jcb",
                        "number" : "5007660999113305",
                        "currency" : "PLN",
                        "balance" : "53248379.58"
                }
        ]
}
))