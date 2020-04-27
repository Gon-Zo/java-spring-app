
let User = 'user/login';
let LOGOUT = 'user/logout'
let PAGELIST = 'user/pageList'
let SETUSER = 'user/setUser'
let CLICKPAGE = 'user/clickPage'
let ISOPEN  =  'user/isOpen'
let CHANGETHEME = 'user/changeTheme'
let ISUSE = 'user/isUse'

export const onLogin = () => ({type: User});
export const onLogout = () => ({type: LOGOUT});
export const onUser = (data) => ({type: PAGELIST, data: data});
export const setUser = (data) => ({type: SETUSER, data: data});
export const clickPage = (data) => ({type: CLICKPAGE , data: data});
export const isOpen = () => ({type: ISOPEN});
export const changeTheme = ()=>({type:CHANGETHEME})
export const isUse = (idx , flag) => ({type: ISUSE, idx: idx , flag : flag})

let initUser = {
    isLogin: sessionStorage.getItem("Token") ? true : false,
    isTheme: true,
    page: 1,
    numPage: 10,
    users: undefined,
    user: undefined,
    isOpen: false,
}

const userReducer = (state = initUser, action) => {
    switch (action.type) {
        case User:
            state.isLogin = true;
            break;
        case LOGOUT:
            state.isLogin = false;
            break;
        case PAGELIST:
            state.users = action.data;
            break;
        case SETUSER:
            state.user = action.data;
            break;
        case CHANGETHEME:
            state.isTheme = !state.isTheme
            break;
        case CLICKPAGE:
            state.page = action.data;
            break;
        case ISOPEN:
            state.isOpen = !state.isOpen;
            break;
        case ISUSE:
            state.users.data[action.idx].is_use = action.flag
            break;
    }

    return state;
};

export default userReducer
