<%--
  Created by IntelliJ IDEA.
  User: Alena
  Date: 19.11.2020
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>

function isEmpty(value)
{
    var val = value.trim();
    if (val.length == 0){
        return false;
    }
    return true;
}

function checkForm() {
    var allFilled = nameAndSurnameCorrect() && loginAndPasswordCorrect();
    allFilled = allFilled && isEmpty(document.getElementById("login").value);
    allFilled = allFilled && isEmpty(document.getElementById("password").value);
    allFilled = allFilled && isEmpty(document.getElementById("repeat_password").value);
    allFilled = allFilled && isEmpty(document.getElementById("name").value);
    allFilled = allFilled && isEmpty(document.getElementById("surname").value);
    allFilled = allFilled && passwordsMatch();
    if (allFilled){
        document.getElementById("submit").disabled = 0;
    }
    else{
        document.getElementById("submit").disabled = 1;
    }
}


function  loginAndPasswordCorrect(){
    return !(/\W/.test(document.getElementById("login").value) || /\W/.test(document.getElementById("password").value));
}

function passwordsMatch(){
    var x = document.getElementById("repeat_password").value;
    if(document.getElementById("repeat_password").value!=document.getElementById("password").value){
        return false;
    }else{
        return true;
    }
}
