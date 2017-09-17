PersonsRefresh();
document.getElementById("getPersonbt").addEventListener("click", function ()
{
    getPerson();
});
document.getElementById("postPersonbt").addEventListener("click", function ()
{
    postPerson();
});

document.getElementById("UpdatePersonbt").addEventListener("click", function ()
{
    editPerson();
    PersonsRefresh();
});


function PersonsRefresh()
{
    fetch("api/person/complete", {method: "get"})
            .then(function (response) {
                if (!response.ok) {
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json) {
                document.getElementById("TablePersonsBody").innerHTML = "";

                var rows = "";
                var hobbies = json.hobbys;
                var json = json.persons

                for (var p in json)
                {
                    rows += '<tr class="person">';
                    rows += '<td>' + json[p].firstName + '</td>';
                    rows += '<td>' + json[p].lastName + '</td>';
                    rows += '<td>' + json[p].email + '</td>';
                    rows += '<td>' + json[p].address.street + '</td>';
                    rows += '<td>' + json[p].address.additionalInfo + '</td>';
                    rows += '<td>' + json[p].address.city + '</td>';
                    rows += '<td>' + json[p].address.zipcode + '</td>';
                    var innerinrowJ = "";
                    var phones = json[p].phones;
                    for (var j in phones) {
                        innerinrowJ += '<li>(' + phones[j].description + ' = ' + phones[j].number + ')</li>';
                    }
                    rows += '<td class="list"><ul>' + innerinrowJ + '</ul></td>';
                    var innerinrowH = "";
                    var hobbies = json[p].hobbys;
                    for (var h in hobbies) {
                        innerinrowH += '<li>(' + hobbies[h].description + ' = ' + hobbies[h].name + ')</li>';
                    }
                    rows += '<td class="list"><ul>' + innerinrowH + '</ul></td>';
                    rows += '</tr>';
                }
                document.getElementById("TablePersonsBody").innerHTML = rows;
            })
            .catch(function (error) {
                error.response.json().then(function (json) {
                    alert(json.description);

                    document.getElementById("TablePersonsBody").innerHTML = "";
                });
            });
}
function getPerson()
{
    var id = document.getElementById("personid").value;
    fetch("api/person/complete/" + id, {method: "get"})
            .then(function (response) {
                if (!response.ok) {
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json) {
                document.getElementById("pf").value = json.firstName;
                document.getElementById("pl").value = json.lastName;
                document.getElementById("pe").value = json.email;


            })
            .catch(function (error) {
                error.response.json().then(function (json) {
                    alert(json.description);
                });
            });
}
;
function postPerson() {
    var firstName = document.querySelector("#pf");
    var lastName = document.querySelector("#pl");
    var email = document.querySelector("#pe");

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
    function editPerson() {
        var person = {
            firstName: document.getElementById("pf").value,
            lastName: document.getElementById("pl").value,
            email: document.getElementById("pe").value,

        };
        var id = document.getElementById("personid").value;
        fetch("api/person/complete/" + id, {
            method: "put",
            body: JSON.stringify(person),
            headers: new Headers({'content-type': 'application/json'})
        })
    }

