import {createStore, applyMiddleware, combineReducers} from "redux";
import thunkMiddleware from "redux-thunk"
import logger from "redux-logger";
import loginReducer from "../reducer/loginReducer";

const store = createStore(
    combineReducers({
        loginReducer: loginReducer
    }),
    {},
    applyMiddleware(logger)
);

export default store;