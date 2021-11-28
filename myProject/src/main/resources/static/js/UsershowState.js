$(document).ready(function(){
    $.ajax({
        url:"/users/get_by_uid",
        type:"GET",
        data:$("#LogSignup").serialize(),
        dataType:"JSON",
        success : function(json){
            if(json.state==200){
                $("#userShow").val(json.data.username);
                $("#userOutgg").val(json.data.signstatus);
            }else { alert("data does not exist");}
        }
    });
});


$("#userOut").click(function () {
    let result =confirm("Do you want to sign out ?");
    if (result){
        location.href="/users/session_clear";
    }

});

    // $("#userOut").click(function () {
    //     let result =confirm("Do you want to sign out ?");
    //     if (result){
    //         location.href="/users/session_clear";
    //     }
    //
    // });
