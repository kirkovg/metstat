import React, {Component} from 'react';
import {Link} from 'react-router-dom'
import {connect} from 'react-redux';
import './Header.css';

class Header extends Component<any, any> {
  renderLinks() {
    if (this.props.authenticated) {
      return (
        <div>
          <Link to="/signout">Sign out</Link>
          <Link to="/feature">Feature</Link>
        </div>
      )
    } else {
      return (
        <div>
          <Link to="/signup">Sign up</Link>
          <Link to="/signin">Sign in</Link>
        </div>
      );
    }
  }


  render() {
    return (
      <div className="header">
        <Link to="/">Metstat</Link>
        {this.renderLinks()}
      </div>
    );
  }
}

function mapStateToProps(state: any) {
  return {authenticated: state.auth.authenticated};
}

export default connect(mapStateToProps)(Header);