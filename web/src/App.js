import React from 'react';
import Root from "./assets/js/Root";
import {BrowserRouter} from 'react-router-dom';
import AppLogin from "./assets/js/views/AppLogin";
import {useSelector} from "react-redux";

function App() {

    let isLogin = useSelector(state => state.userReducer, []).isLogin

    return (
        <BrowserRouter
            basename="/#"
            forceRefresh={true}>
            {/*<Root/>*/}
            <MarketApp login={isLogin}/>
        </BrowserRouter>
    )
}

function MarketApp(props) {
    let isLogin = props.login

    if(isLogin){
       return(
           <Root/>
       )
    }else{
        return (
            <AppLogin/>
        )
    }
}

export default App;
