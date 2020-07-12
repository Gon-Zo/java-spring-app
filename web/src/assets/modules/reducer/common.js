import {ERROR_MENU, initData, LOAD_MENU, SUCCESS_MENU} from "../store/common";

import {STATE} from "../constant/constant";

export const onLoadMenu = () => ({type: LOAD_MENU})

export const onSuccessMenu = (payload) => ({type: SUCCESS_MENU, data: payload})

export const onErrorMenu = (e) => ({type: ERROR_MENU, error: e})


const reducer = (state = initData, action) => {
    switch (action.type) {
        case LOAD_MENU :
            state.menus.state = STATE.L
            break;
        case SUCCESS_MENU :
            state.menus.state = STATE.S
            state.menus.data = action.data
            break;
        case ERROR_MENU :
            state.menus.state = STATE.E
            state.menus.error = action.error
            break;
    }
    return state
};

export default reducer
