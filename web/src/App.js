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
            {/*<MarketApp login={isLogin} />*/}
            {
                isLogin ? (<Root/>)  : (<AppLogin/>)
            }
        </BrowserRouter>
    )
}

// function MarketApp(props) {
//    return props.login ? (<Root/>)  : (<AppLogin/>)
// }

export default App;
