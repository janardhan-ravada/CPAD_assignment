import React from 'react';

import Product from './Product';
import { Redirect } from 'react-router-dom';
import { getProducts } from '../../apis/APIUtil';

class ProductList extends React.Component {
  constructor(props) {
    super(props);
    this.state = { products: [] };
  }

  componentDidMount() {
    getProducts().then((res) => this.setState({ products: res }));
  }

  render() {
    if (this.props.isAuthenticated && this.props.userType === 'FARMER') {
      return (
        <Redirect
          to={{
            pathname: '/my-inventory',
            state: { from: this.props.location },
          }}
        />
      );
    }
    let products = this.state.products.map((product) => {
      return (
        <Product
          key={product.id}
          product={product}
          addToCart={this.props.addToCart}
          productAlreadyInCart={this.props.productAlreadyInCart}
          isAuthenticated={this.props.isAuthenticated}
        />
      );
    });

    return <div className="ui cards">{products} </div>;
  }
}

export default ProductList;
