import React, {Component} from 'react';
import {Field, reduxForm} from 'redux-form';
import {compose} from 'redux';
import {connect} from 'react-redux';
import * as actions from '../../actions';


class SignUp extends Component<any, any> {

  onSubmit = (formProps: any) => {
    this.props.signUp(formProps, () => {
      this.props.history.push('/');
    });
  };

  render() {
    const {handleSubmit} = this.props;

    return (
      <form onSubmit={handleSubmit(this.onSubmit)}>
        <fieldset>
          <label>Username</label>
          <Field
            name="username"
            type="text"
            component="input"
            autoComplete="none"
          />
        </fieldset>
        <fieldset>
          <label>Password</label>
          <Field
            name="password"
            type="password"
            component="input"
            autoComplete="none"
          />
        </fieldset>
        <fieldset>
          <label>First name</label>
          <Field
            name="firstName"
            type="text"
            component="input"
            autoComplete="none"
          />
        </fieldset>
        <fieldset>
          <label>Last name</label>
          <Field
            name="lastName"
            type="text"
            component="input"
            autoComplete="none"
          />
        </fieldset>
        <div>{this.props.errorMessage}</div>
        <button>Sign up</button>
      </form>
    );
  }
}

function mapStateToProps(state: any) {
  return {errorMessage: state.auth.errorMessage};
}

export default compose(
  connect(mapStateToProps, actions),
  reduxForm({form: 'signup'})
)(SignUp);