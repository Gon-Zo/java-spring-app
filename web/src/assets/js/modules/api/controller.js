import axios from "axios";
import {setMenus, setRoles, setUrls, setUsers} from "../reducer/controller";

class Param {
    constructor( page , size , sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }
}

export function $httpGetMenus(dispatch) {
    let param = new Param(0, 10, '')
    axios.get(`/admin/menu` , {
        params : param
    })
        .then(res => dispatch(setMenus(res.data)))
        .catch(err => console.log(err))
}

export function $httpGetUsers(dispatch) {
    let param = new Param(0, 10, '')
    axios.get(`/admin/user`, {
        params: param
    })
        .then(res => dispatch(setUsers(res.data)))
        .catch(err => console.log(err))

}

export function $httpGetRoles(dispatch) {
    let param = new Param(0, 10, '')
    axios.get(`/admin/role`, {
        params: param
    })
        .then(res => dispatch(setRoles(res.data)))
        .catch(err => console.log(err))

}

export function $httpGetUrls(dispatch) {
    let param = new Param(0, 10, '')
    axios.get(`/admin/url`, {
        params: param
    })
        .then(res => dispatch(setUrls(res.data)))
        .catch(err => console.log(err))
}