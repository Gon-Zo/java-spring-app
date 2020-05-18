
let User = 'user/login';
let LOGOUT = 'user/logout'
let PAGELIST = 'user/pageList'
let SETUSER = 'user/setUser'
let CLICKPAGE = 'user/clickPage'
let ISOPEN  =  'user/isOpen'
let CHANGETHEME = 'user/changeTheme'
let ISUSE = 'user/isUse'
let PUTSORT = 'user/putSort'

export const onLogin = () => ({type: User});
export const onLogout = () => ({type: LOGOUT});
export const onUser = (data) => ({type: PAGELIST, data: data});
export const setUser = (data) => ({type: SETUSER, data: data});
export const clickPage = (data) => ({type: CLICKPAGE , data: data});
export const isOpen = () => ({type: ISOPEN});
export const changeTheme = ()=>({type:CHANGETHEME})
export const isUse = (idx , flag) => ({type: ISUSE, idx: idx , flag : flag})
export const putSort = (data) => ({type: PUTSORT, data: data})

let initUser = {
    isLogin: sessionStorage.getItem("Token") ? true : false,
    isTheme: true,
    page: 1,
    numPage: 10,
    sort : [],
    users: undefined,
    user: undefined,
    isOpen: false,
    test : false ,
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
            state.users.content[action.idx].isUse = action.flag
            break;
        case PUTSORT:
            let data = action.data;

            let temp = state.sort.find(f => f.split(":")[0] == data);

            if (typeof temp == 'undefined') {
                data = `${data}:DESC`
            } else {
                // let idxOf = state.sort.indexOf(temp)
                // state.sort.remove(idxOf)

                let tempArray = temp.split(":")
                let sortting = tempArray[1]
                sortting = sortting == 'ASC' ? 'DESC' : 'ASC'
                data = `${tempArray[0]}:${sortting}`
            }
            state.sort.push(data)
            break;
    }

    return state;
};

export default userReducer
