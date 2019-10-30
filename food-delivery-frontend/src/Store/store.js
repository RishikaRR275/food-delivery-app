import {createStore, applyMiddleware, combineReducers} from "redux";
import thunkMiddleware from "redux-thunk"
import logger from "redux-logger";
import loginReducer from "../Reducer/loginReducer";

const store = createStore(
    combineReducers({
        loginReducer: loginReducer
    }),
    {},
    applyMiddleware(thunkMiddleware , logger)
);

export default store;