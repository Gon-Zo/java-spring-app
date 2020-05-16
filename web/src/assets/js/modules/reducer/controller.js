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
}

let controllerReducer = (state = initData , action) => {
    switch (action.type) {

        case GETMENUS:
            state.menus = action.data;
            break;

        case GETUSERS:
            state.users = action.data;
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

export default controllerReducer