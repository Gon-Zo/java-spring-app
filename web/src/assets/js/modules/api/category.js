import axios from "axios";
import {isOpenToCategory, setCategory} from "../reducer/category";

export function $setCategory(dispatch) {
    axios.get(`/manager/category` , {
        page : 0 ,
        size : 10 ,
        sort : '---',
    })
        .then((res) => dispatch(setCategory(res.data)))
        .catch(err => console.log(err))
}

export function $updateCategory(dispatch , payload) {
    let seq = payload.seq;
    axios.put(`/manager/category${seq}` , payload)
        .then((res)=>console.log(res.status))
        .catch(err=>console.log(err))
}

export function $deleteCategory(dispatch , payload) {
    let seq = payload.seq
    axios.delete(`/manager/category${seq}`)
        .then((res)=>console.log(res.status))
        .catch(err=>console.log(err))
}

export function $createCategory(dispatch, payload) {
    axios.post(`/manager/category`)
        .then((res) => console.log(res.status))
        .catch(err => console.log(err))
}

export function openToCategory(dispatch) {
    dispatch(isOpenToCategory())
}
