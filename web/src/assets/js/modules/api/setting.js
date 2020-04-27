import {setStore} from "../reducer/setting";
import axios from 'axios'

/**
 * store list
 *
 * @param dispatch
 * @param payload
 */
export function $getStore(dispatch, payload) {
    axios.get(`/admin/store/1`)
        .then(res => dispatch(setStore(res.data)))
        .catch(err => console.log(err))
}

/**
 * store update
 *
 * @param dispatch
 * @param payload
 */
export function $updateStore(dispatch, payload) {
    let temp = payload
    delete temp.user
    axios.put(`/admin/store/1`, temp)
        .then(res => {
            $getStore(dispatch, payload)
        })
        .catch((error) => console.log(error))
}
