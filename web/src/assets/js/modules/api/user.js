import React from "react";
import axios from 'axios'
import {onUser, isOpen, clickPage, setUser, onLogout, onLogin, isUse, putSort} from '../reducer/user'

export const $httpLogout = (dispatch , history) =>{
    axios.defaults.headers.common['Authorization'] = undefined;
    sessionStorage.removeItem('Token');
    history.push("/")
    dispatch(onLogout())
};

export const $httpLogin = (dispatch, payload , history) => {
    axios.post(`/login`, payload)
        .then((res) => {
            let token = res.data.token;
            sessionStorage.setItem("Token", token);
            axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
            dispatch(onLogin())
            history.push('/home')
        })
        .catch(error => {
            console.log(error)
            console.log(error.message)
            // alert("로그인 실패")
        })

};

export const $fetchUsers = (dispatch, payload) => {

    axios.get(`/manager/user`, {
        params: {
            page: payload.page - 1,
            size: payload.numPage,
            sort: payload.sort.toString()
        }
    }).then(res => dispatch(onUser(res.data))
    ).catch((err) => console.log(err))

};

export const $updateUser = (dispatch, payload) => {

    let seq = payload.seq
    let user = buildUser(payload)

    axios.put(`/manager/user/${seq}`, user)
        .then(res => console.log(res))
        .catch(err => console.log(err))

};

export const $deleteUser = (dispatch, payload) => {
    let idx = payload.idx
    let data = payload.data
    axios.delete(`/admin/user/${idx}`)
        .then(res => {
          $fetchUsers(dispatch , data)
        })
        .catch(err => console.log(err))
}

export const $onPage = (dispatch, data) => {
    dispatch(clickPage(data))
}

export const $setUser = (dispatch, data) => {
    dispatch(setUser(data))
}

export const $isUserModalOpen = (dispatch) => {
    dispatch(isOpen())
}

export const $isUse = (dispatch, idx, payload, flag) => {
   payload['isUse'] = flag
    dispatch(isUse(idx , flag))
   $updateUser(dispatch, payload)
}

let buildUser = (payload) => {
    let user = payload
    let keys = Object.keys(user)
    let temp = {}
    keys.filter( m =>
        m === 'email' ||
        m === 'email' ||
        m === 'birthDate' ||
        m === 'isUse' ||
        m === 'address'
    )
        .map(m => temp[m] = user[m]);
    return temp
}

export const $pushSortData = (dispatch , data) => {
    dispatch(putSort(data))
}

export const $signUpUser = (dispatch, payload) => {
    return axios.post(`/sign?roles=M`, payload)
}
