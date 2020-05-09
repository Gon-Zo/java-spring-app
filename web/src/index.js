import React from "react";
import ReactDOM from "react-dom";
import * as serviceWorker from './serviceWorker';
import axios from 'axios'
import App from "./App";
import {createStore} from 'redux';
import {composeWithDevTools} from 'redux-devtools-extension';
import rootReducer from './assets/js/modules/reducer';
import {Provider} from 'react-redux';

// ========= CSS import

import './assets/styles/index.scss'
import 'bootstrap/dist/css/bootstrap.min.css';
import "react-day-picker/lib/style.css";

// ========= Axios Config

axios.defaults.baseURL = 'http://localhost:8080'

axios.defaults.timeout = 10000

axios.interceptors.request.use(request => {
    console.log('request', request);

    let authToken = request.headers.common.Authorization;

    if(typeof authToken === 'undefined'){
        let token = sessionStorage.getItem("Token")
        request.headers.common.Authorization = `Bearer ${token}`;
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    }

    return request;
}, error => {
    console.log(error);
    return Promise.reject(error);
});

axios.interceptors.response.use(response => {
    console.log('response', response);
    return response;
}, error => {

    let err = error.response.data

    let code = err.errorCode

    console.log('code', code)

    // if (err.code === 'E001' || err.code === 'E002' || err.code === 'E003') {
    //     alert("세션 만료")
    //     sessionStorage.removeItem("Token")
    //     window.location.reload(true);
    // }

    return Promise.reject(error);
});

// ========= HTML Rendering

const store = createStore(rootReducer, composeWithDevTools());

ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>,
    document.getElementById('root')
);

serviceWorker.unregister();

