import {setFrom, setTo} from "../reducer/order";

export function setDay(dispatch , payload) {
    if(payload.type == 'F'){
       dispatch(setFrom(payload.day))
    }else{
       dispatch(setTo(payload.day))
    }
}