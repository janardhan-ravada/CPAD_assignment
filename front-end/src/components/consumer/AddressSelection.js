import React from 'react';
import Address from './Address';
import { Button } from 'semantic-ui-react';

import { getConsumer, placeOrder } from '../../apis/APIUtil';
import history from '../history';

import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';

import { Link } from 'react-router-dom';

class AddressSelection extends React.Component {
  constructor(props) {
    super(props);
    this.state = { addresses: [] };
  }

  placeOrder = () => {
    let cartId = this.props.cart.cartId;
    let selectedAddress = this.state.addresses.find(
      (address) => address.selected
    );
    if (!selectedAddress) {
      Alert.warning('Select One Address');
      return;
    }
    placeOrder(
      cartId,
      selectedAddress.id,
      this.props.cart.cartPrice,
      this.props.cart.cartPriceWithDiscount
    ).then((response) => {
      this.props.resetCart();
      history.push('/');
      Alert.success('Order Placed');
    });
  };

  getConsumerAddress = () => {
    getConsumer().then((consumer) => {
      this.setState({ addresses: consumer.addresses });
    });
  };

  setAddress = (addressId) => {
    this.state.addresses.map((address) => {
      if (address.id === addressId) {
        address.selected = true;
      } else {
        address.selected = false;
      }
      return address;
    });
    this.setState({ addresses: [...this.state.addresses] });
  };
  componentDidMount() {
    this.getConsumerAddress();
  }
  render() {
    debugger;
    if (this.state.addresses.length === 0) {
      return <div>No addresses</div>;
    }
    let addresses = this.state.addresses.map((address) => (
      <Address
        key={address.id}
        address={address}
        setAddress={this.setAddress}
      />
    ));
    return (
      <>
        <div className="ui content center aligned selection list">
          {addresses}
        </div>
        <Link to="/add-address">Add new address</Link>
        <div className="ui center aligned">
          <Button
            className="positive ui"
            onClick={() => {
              this.placeOrder();
            }}
          >
            Continue
          </Button>
        </div>
        <Alert
          stack={{ limit: 3 }}
          timeout={3000}
          position="top-right"
          effect="slide"
          offset={65}
        />
      </>
    );
  }
}

export default AddressSelection;
