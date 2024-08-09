
async function getPerson(){
    const nroIdentification = document.getElementById('nroIdentification').value;
    const url = `http://localhost:8090/api/getPersonByNroIdentification/${nroIdentification}`;
    try {
        const response = await fetch(url);
        if(!response.ok){
            throw new Error("Error with the network connection")
        }
        const person = await response.json();
        console.log(JSON.stringify(person,null,2));
        document.getElementById('result').innerText = JSON.stringify(person,null,2);
    } catch (error) {
        document.getElementById('result').innerText = `Error: ${error.message}`;
    }
}
async function createPerson() {
    const url = 'http://localhost:8090/api/createPerson';

    // Get values from input fields
    const firstname = document.getElementById("firstnameInput").value;
    const lastname = document.getElementById("lastnameInput").value;
    const identificationNumber = parseInt(document.getElementById("nroIdentificationInput").value);

    // Create data object
    const data = {
        firstname: firstname,
        lastname: lastname,
        identificationNumber: identificationNumber
    };

    try {
        // Send POST request
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json', 
            },
            body: JSON.stringify(data) 
        });

        // Check if response is successful
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const result = await response.json(); 
        alert('Success: ' + JSON.stringify(result, null, 2)); 
    } catch (error) {
        alert('Error: ' + error.message); 
    }
}