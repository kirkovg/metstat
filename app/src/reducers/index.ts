import {combineReducers} from 'redux';
import {reducer as formReducer} from 'redux-form';
import {authReducer} from './auth';

export const rootReducer = combineReducers({
    auth: authReducer,
    form: formReducer
});

export type RootState = ReturnType<typeof rootReducer>;
