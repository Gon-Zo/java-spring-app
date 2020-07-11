import {onErrorMenu, onLoadMenu, onSuccessMenu} from "../reducer/common";
import {getNowUrl} from "../constant/app-function";

export function _setMenus(dispatch, payload) {
    dispatch(onLoadMenu())

    try {

        // const url = getNowUrl()

        // const href = window.location.href
        // console.log(href)
        // const urlArray = href.split("#")
        // const url = urlArray[1]
        //
        // console.log(url)
        //
        // payload.forEach(f => {
        //     m.isOn = f.url == url
        // })

        dispatch(onSuccessMenu(payload))

    } catch (e) {
        dispatch(onErrorMenu(e))
    }
}
