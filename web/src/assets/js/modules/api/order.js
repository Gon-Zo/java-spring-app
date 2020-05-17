import {setFrom, setList, setOffset, setOrders, setScrollTop, setTo} from "../reducer/order";
import axios from 'axios';

export function setDay(dispatch , payload) {
    if(payload.type == 'F'){
       dispatch(setFrom(payload.day))
    }else{
       dispatch(setTo(payload.day))
    }
}

export function $httpOrders(dispatch) {
    axios.get(`/manager/order/`)
        .then(res => dispatch(setOrders(res.data)))
        .catch(err => console.log(err))
}

export function $setList(dispatch , payload) {
    dispatch(setList(payload))
}

export function $setOffset(dispatch , payload) {
    dispatch(setOffset(payload))
}

export function $setScrollTop (dispatch , payload) {
    dispatch(setScrollTop(payload))
}
