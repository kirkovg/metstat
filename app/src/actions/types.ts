import {Action} from 'redux';

/**
 * Default app action.
 */
export interface AppAction<T> extends Action {
    payload: T;
}

export interface SignInAction extends AppAction<string> {
}

export interface SignOutAction extends AppAction<void> {
}

export interface SignUpAction extends AppAction<string> {
}

export const AUTH_USER = 'AUTH_USER';
export const AUTH_ERROR = 'AUTH_ERROR';