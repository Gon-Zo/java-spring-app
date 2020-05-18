import {_bindData} from "../static/support";

let GETMENUS = 'controller/getMenus'
let GETUSERS = 'controller/getUsers'
let GETROLES = 'controller/getRoles'
let GETURLS = 'controller/getUrls'

export const setMenus = (data) => ({type : GETMENUS , data : data})
export const setUsers = (data) => ({type : GETUSERS , data : data})
export const setRoles = (data) => ({type : GETROLES , data : data})
export const setUrls = (data) => ({type : GETURLS , data : data})

let initData = {
    menus: undefined,
    roles: undefined,
    urls: undefined,
    users: undefined,
    payload : [],
}

let controllerReducer = (state = initData , action) => {
    switch (action.type) {

        case GETMENUS:
            state.menus = action.data;
            state.payload =  _bindData(action.data, filterBy(action.type))
            break;

        case GETUSERS:
            state.users = action.data;
            state.payload = _bindData(action.data, filterBy(action.type))
            break;

        case GETROLES:
            state.roles = action.data;
            break;

        case GETURLS:
            state.urls = action.data;
            break;

    }

    return state;

}

let filterBy = (k) => {
    let filter;
    switch (k) {
        case GETMENUS:
            filter = [
                {key: 'title', name: '메뉴명'},
                {key: 'url', name: "주소"},
                {key: 'icon', name: "아이콘"}
            ]
            break;
        case GETUSERS:
            filter = [
                {key: 'email', name: "이메일"},
                {key: 'birthDate', name: "생년월일"},
                {key: 'address', name: "주소"},
                {key: 'isUse', name: "상태"},
                {key: 'createdAt', name: "등록일"}
            ]
            break;
        case GETROLES:
            filter = [
                {key : "title" , name : "권한명"},
            ];
           break;

        case GETURLS:
            filter = [
                { title : "인증 주소"}
            ]
           break;
    }
    return filter;
}


export default controllerReducer