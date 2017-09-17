var printGetPerson = document.querySelector("#printGetPerson");
var getPerson = document.querySelector("#getPerson button[name ='getPerson']");
var postPerson = document.querySelector("#postPerson button[name ='postPerson']");

getPerson.onclick = function (e) {
    e.preventDefault();
    var input = document.querySelector("#getPerson input[name ='getPersonID']");
    var prom = fetch("api/person/complete/" + input.value, { method: "get" });

    prom.then(function (response) {
        return response.json();
    }).then(function (json) {
        printGetPerson.innerHTML = "Name: " + json.firstName + " " + json.lastName + ", Email: " + json.email + ", id: " + json.id + json.address.street;

    });
}

postPerson.onclick = function (e) {
    e.preventDefault();
    var firstName = document.querySelector("#postPerson input[name ='postFirstName']");
    var lastName = document.querySelector("#postPerson input[name ='postLastName']");
    var email = document.querySelector("#postPerson input[name ='postEmail']");

    console.log(firstName.value);

    var body = {
        "firstName": firstName.value,
        "lastName": lastName.value,
        "email": email.value,
        "address": {
            "street": "test",
            "additionalInfo": "test"
        }

    };

    fetch("api/person/", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
           "Content-Type": "application/json", 
           'Accept': 'application/json'
        }
    
    });

}






