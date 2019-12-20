import {AUTH_ERROR, AUTH_USER, SignInAction, SignUpAction} from './types';
import axios from 'axios';

export const signUp = (formProps: any, callback: () => void) => async (dispatch: (action: SignUpAction) => void) => {
    try {
        await axios.post('http://localhost:8080/signup', formProps);
        callback();
    } catch (e) {
        dispatch({
            type: AUTH_ERROR,
            payload: 'Error while creating an account'
        });
    }
};

export const signIn = (formProps: any, callback: () => void) => async (dispatch: (action: SignInAction) => void) => {
    try {
        const response = await axios.post('http://localhost:8080/signin', formProps);
        dispatch({
            type: AUTH_USER,
            payload: response.data.token
        });
        localStorage.setItem('token', response.data.token);
        callback();
    } catch (e) {
        dispatch({
            type: AUTH_ERROR,
            payload: 'Invalid username or password'
        });
    }
};

export const signOut = () => {
    localStorage.removeItem('token');
    return {
        type: AUTH_USER,
        payload: null
    }
};