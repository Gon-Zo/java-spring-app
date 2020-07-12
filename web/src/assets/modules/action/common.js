import {onErrorMenu, onLoadMenu, onSuccessMenu} from "../reducer/common";
import {getNowUrl} from "../constant/app-function";

export function _setMenus(dispatch, payload) {

    dispatch(onLoadMenu())

    try {

        const url = payload.url

        const data = payload.data

        const result = data.map(m => {
           return {
               title : m.title ,
               icon : m.icon ,
               url : m.url ,
               isOn : m.url == url
           }
        })

        dispatch(onSuccessMenu(result))

    } catch (e) {
        dispatch(onErrorMenu(e))
    }
}
