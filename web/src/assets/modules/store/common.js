import {STATE} from "../constant/constant";

export const LOAD_MENU = "menu/load";

export const SUCCESS_MENU = "menu/success";

export const ERROR_MENU = "menu/error";

export const initData = {
    menus: {
        state: STATE.L,
        data: [],
        error: null
    }
};
