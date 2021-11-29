import React from 'react';
import CartProduct from './CartProduct';
import history from '../history';

class Cart extends React.Component {
  navigateToAddressSelection = () => {
    history.push('/select-address');
  };

  render() {
    debugger;
    if (this.props.cart.products.length === 0) {
      return <div>No Products in cart</div>;
    }

    const cartItems = this.props.cart.products.map((item) => (
      <CartProduct key={item.id} product={item} />
    ));
    return (
      <>
        <div>{cartItems}</div>
        <div className="right"></div>
        <div className="ui grid">
          <div className="right floated three wide column ">
            <div className="ui ">
              Total Price : {this.props.cart.cartPriceWithDiscount}
            </div>
            <div className="ui">
              <button
                className="positive ui button"
                style={{ marginTop: '10px' }}
                onClick={() => {
                  this.navigateToAddressSelection();
                }}
              >
                Continue
              </button>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default Cart;
