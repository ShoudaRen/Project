function checkname(){
    if (document.getElementById("userShow").value=="Log In"){
        location.href="../templates/LogIn.html";
    }else {
        location.href="../templates/userdata.html";
    }
}

function checksignout(){
    if (document.getElementById("userOutgg").value=="SIGN UP"){


        location.href="../templates/register.html";
    }else {
            let result =confirm("Do you want to sign out ?");
            if (result){
                location.href="/users/session_clear";
                location.reload();
                location.href="../templates/index.html";
            }
    }
}