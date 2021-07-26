async function register(email, password) {
    let response = await fetch("http://localhost:8080/customers/register", {
        method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify({email: email, password: password})
    })

    return response.json();
}

async function onClickRegisterBtn() {
    let username = document.forms["register-form"]["email"].value;
    let password = document.getElementById("register-password").value;
    let response = await register(username, password);
}