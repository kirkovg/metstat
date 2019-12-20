import {AppAction, AUTH_ERROR, AUTH_USER} from "../actions/types";

interface AuthState {
    authenticated: string;
    errorMessage: string;
}


const initialState: AuthState = {
    authenticated: '',
    errorMessage: ''
};

export function authReducer(state = initialState, action: AppAction<any>) {
    switch (action.type) {
        case AUTH_USER:
            return {...state, authenticated: action.payload};
        case AUTH_ERROR:
            return {...state, errorMessage: action.payload};
        default:
            return state;
    }
}