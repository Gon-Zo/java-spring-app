import {useSelector} from "react-redux";

export const isNotEmpty = (data) => {
    return  typeof data !== "undefined" || data !== null
}

export const AppTheme = () =>{
    let theme = useSelector(state => state.userReducer, []).isTheme
    let str = theme ? "primary" :"dark"
    return str
}
export const AppButtonTheme = () =>{
    let theme = useSelector(state => state.userReducer, []).isTheme
    let str = theme ? "light" : "secondary";
    return str
}

export const AppPageTheme = (l , r) =>{
   return l == r ? AppButtonTheme()  : AppTheme()
}

export const AppReversTheme = () => {
    let theme = useSelector(state => state.userReducer, []).isTheme
    let str = theme ? "dark" : "light"
    return str
}

export const _bindData = (payload , keys) => {

    let data = typeof payload === 'undefined' ? undefined : payload.content;

    let count = typeof payload === 'undefined' ? undefined : payload.totalElements

    let numPages = typeof payload === 'undefined' ? undefined : payload.totalPages

    let showPages = typeof payload === 'undefined' ? undefined : payload.size;

    return {
        data: data,
        key: keys,
        count: count,
        numPages: numPages,
        showPages: showPages,
    }

}
