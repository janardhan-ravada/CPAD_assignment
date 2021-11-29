import React from 'react';

import { Link } from 'react-router-dom';
import { Icon, Button } from 'semantic-ui-react';

const Header = (props) => {
  let isAuthenticated = props.isAuthenticated;
  let userType = props.userType;
  let header = ``;

  if (isAuthenticated && userType === 'FARMER') {
    header = (
      <>
        <div className="item">
          <Link to="/product/new">Add a Product</Link>
        </div>
        <div className="item">
          <Link to="/my-inventory">MyInventory</Link>
        </div>
        <div className="item">
          <Link to="/farmer-orders">Received Orders</Link>
        </div>
        <div className="item">
          <Button className="primary" onClick={props.onLogout}>
            Logout
          </Button>
        </div>
      </>
    );
  } else if (isAuthenticated && userType === 'CONSUMER') {
    header = (
      <>
        <div className="item">
          <Link to="/">All Products</Link>
        </div>
        <div className="item">
          <Link to="/cart">
            <Icon size="big" name="shopping cart" style={{ color: 'purple' }}>
              {props.cartLength}
            </Icon>
          </Link>
        </div>
        <div className="item">
          <Link to="/orders">Orders</Link>
        </div>
        <div className="item">
          <Button className="primary" onClick={props.onLogout}>
            Logout
          </Button>
        </div>
      </>
    );
  } else {
    header = (
      <>
        <div className="item">
          <Link to="/">Products</Link>
        </div>
        <div className="item ">
          <Link to="/farmer-signup">Register as Farmer</Link>
        </div>
        <div className="item ">
          <Link to="/consumer-signup">Register as Consumer</Link>
        </div>
        <div className="item right">
          <Link to="/signin">SignIn</Link>
        </div>
      </>
    );
  }
  return (
    <React.Fragment>
      <div className="ui stackable menu">
        <div className="item"></div>
        {header}
      </div>
    </React.Fragment>
  );
};

export default Header;
