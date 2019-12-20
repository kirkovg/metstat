import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './components/app/App';
import {Provider} from 'react-redux';
import {applyMiddleware, createStore} from 'redux';
import reduxThunk from 'redux-thunk';
import {rootReducer} from './reducers';
import {BrowserRouter, Route} from 'react-router-dom';
import Welcome from './components/Welcome';
import SignUp from './components/auth/SignUp';
import SignIn from './components/auth/SignIn';
import SignOut from './components/auth/SignOut';
import Feature from './components/Feature';

const appStore: any = createStore(
    rootReducer,
    {
        auth: {
            authenticated: localStorage.getItem('token')
        }
    },
    applyMiddleware(reduxThunk)
);

ReactDOM.render(
    <Provider store={appStore}>
      <BrowserRouter>
          <App>
              <Route path="/" exact component={Welcome}/>
              <Route path="/signup" exact component={SignUp as any}/>
              <Route path="/signin" exact component={SignIn as any}/>
              <Route path="/signout" exact component={SignOut}/>
              <Route path="/feature" exact component={Feature}/>
          </App>
      </BrowserRouter>
    </Provider>,
    document.getElementById('root')
);