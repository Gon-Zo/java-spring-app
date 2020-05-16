import {combineReducers} from 'redux';
import userReducer from "./user";
import productReducer from './product'
import settingReducer from "./setting";
import categoryReducer from "./category";
import orderReducer from "./order";
import controllerReducer from "./controller";

const rootReducer = combineReducers({
    userReducer,
    productReducer,
    settingReducer,
    categoryReducer,
    orderReducer,
    controllerReducer
});

export default rootReducer;
