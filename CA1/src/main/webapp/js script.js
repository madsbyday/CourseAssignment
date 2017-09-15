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
        printGetPerson.innerHTML = json.firstName;

    });
}

postPerson.onclick = function (e) {
    e.preventDefault();
    var firstName = document.querySelector("#postPerson input[name ='postFirstName']");
    var lastName = document.querySelector("#postPerson input[name ='postLastName']");
    var email = document.querySelector("#postPerson input[name ='postEmail']");

    console.log(firstName.value);

    var body = {
        "firstName": "test", //firstName.value,
        "lastName": "test", //lastName.value,
        "email": "test" //email.value
    };

    var data = new FormData();
    data.append("json", JSON.stringify(body));
    var prom = fetch("api/person/", { method: "POST", body: data });

    prom.then(function (response) {
        return response.json();
    });

}





