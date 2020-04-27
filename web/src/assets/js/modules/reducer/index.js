import {combineReducers} from 'redux';
import userReducer from "./user";
import productReducer from './product'
import settingReducer from "./setting";
import categoryReducer from "./category";
import orderReducer from "./order";

const rootReducer = combineReducers({
    userReducer, productReducer, settingReducer, categoryReducer, orderReducer
});

export default rootReducer;
