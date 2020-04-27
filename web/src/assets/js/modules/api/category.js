import axios from "axios";
import {isOpenToCategory, setCategory} from "../reducer/category";

export function $setUpCategory(dispatch) {
    axios.get(`/admin/category`)
        .then((res) => dispatch(setCategory(res.data)))
        .catch(err => console.log(err))
}

export function $updateCategory(dispatch , payload) {
    let seq = payload.seq;
    axios.put(`/admin/category${seq}` , payload)
        .then((res)=>console.log(res.status))
        .catch(err=>console.log(err))
}

export function $deleteCategory(dispatch , payload) {
    let seq = payload.seq
    axios.delete(`/admin/category${seq}`)
        .then((res)=>console.log(res.status))
        .catch(err=>console.log(err))
}

export function $createCategory(dispatch, payload) {
    axios.post(`/admin/category`)
        .then((res) => console.log(res.status))
        .catch(err => console.log(err))
}

export function openToCategory(dispatch) {
    dispatch(isOpenToCategory())
}
