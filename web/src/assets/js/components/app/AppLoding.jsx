import React ,{ useState} from "react";
import Alert from "react-bootstrap/Alert";
import Button from "react-bootstrap/Button";

function LoginView(props) {
    return (
        <div>
           <span>로딩중</span>
        </div>
    )
}


let catchLogin = (data) =>{
    console.log("data" , data)
    if(data == null){
       return(
           <LoginView/>
       )
    }
}

export {catchLogin}

