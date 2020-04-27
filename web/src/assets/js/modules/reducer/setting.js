let SETSTORE = "setting/setStore";

export const setStore = (data) => ({type: SETSTORE, data: data});

let initSetting = {
    store: null
};

const settingReducer = (state = initSetting, action) => {
    switch (action.type) {
        case SETSTORE :
            state.store = action.data;
            break;
    }
    return state
};

export default settingReducer
