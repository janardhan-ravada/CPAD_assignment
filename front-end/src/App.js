import 'semantic-ui-css/semantic.min.css';
import './App.css';
import React from 'react';
import ProductList from './components/products/ProductList';
import ProductCreate from './components/products/ProductCreate';
import Header from './components/Header';

import { Router, Route, Switch } from 'react-router';

import history from './components/history';
import Cart from './components/card/Cart';
import SignIn from './components/SignIn';
import FarmerSignUp from './components/farmer/FarmerSignUp';
import ConsumerSignUp from './components/consumer/ConsumerSignUp';
import PrivateRoute from './components/PrivateRoute';
import AddressSelection from './components/consumer/AddressSelection';

import { getCurrentUser, addToCart, getCart } from './apis/APIUtil';
import Orders from './components/consumer/Orders';
import Inventory from './components/farmer/Inventory';
import { createProduct } from './apis/APIUtil';

import FarmerOrders from './components/farmer/FarmerOrders';
import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';

import AddressForm from './components/consumer/AddressForm';

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      cart: {
        products: [],
        cartId: '',
        cartPrice: 0,
        cartPriceWithDiscount: 0,
      },
      isAuthenticated: false,
      userType: '',
      currentUser: null,
    };
  }

  loadCurrentlyLoggedInUser() {
    this.setState({
      loading: true,
    });

    getCurrentUser()
      .then((response) => {
        this.setState({
          currentUser: response,
          isAuthenticated: true,
          userType: response.userType,
        });
      })
      .catch((error) => {
        this.setState({
          loading: false,
        });
      });
  }

  addToCart = (product, orderedQuantity) => {
    let cartPrice = this.state.cart.cartPrice;
    let cartPriceWithDiscount = this.state.cart.cartPriceWithDiscount;

    cartPrice = cartPrice + orderedQuantity * product.packPrice;
    cartPriceWithDiscount =
      cartPriceWithDiscount + orderedQuantity * product.packPriceWithDiscount;
    addToCart({
      ...product,
      productId: product.id,
      orderedQuantity: orderedQuantity,
      cartPrice: cartPrice,
      cartPriceWithDiscount: cartPriceWithDiscount,
    }).then((response) => {
      this.setState({
        cart: response,
      });
      Alert.success('Product added to your cart');
    });
  };

  getCartProducts = () => {
    getCart().then((response) => {
      debugger;
      this.setState({ cart: response });
    });
  };

  setAuthentication = (isAuthenticated) => {
    this.setState({ isAuthenticated: isAuthenticated });
  };

  setUserType = (userType) => {
    this.setState({ userType: userType });
  };

  productAlreadyInCart = (productId) => {
    const product = this.state.cart.products.find(
      (product) => product.id === productId
    );
    if (product) {
      return true;
    }

    return false;
  };
  resetCart = () => {
    this.setState({
      cart: {
        products: [],
        cartId: '',
        cartPrice: 0,
        cartPriceWithDiscount: 0,
      },
    });
  };

  handleLogout = () => {
    localStorage.removeItem('accessToken');
    this.setState({
      isAuthenticated: false,
      userType: null,
      cart: {
        products: [],
        cartId: '',
        cartPrice: 0,
        cartPriceWithDiscount: 0,
      },
    });
  };

  createProduct = (requestBody) => {
    createProduct(requestBody).then(() => {
      Alert.success('Product added to your Inventory');
      history.push('/my-inventory');
    });
  };

  componentDidMount() {
    this.loadCurrentlyLoggedInUser();
  }

  render() {
    return (
      <div className="ui container">
        <Alert
          stack={{ limit: 3 }}
          timeout={3000}
          position="top-right"
          effect="slide"
          offset={65}
        />
        <Router history={history}>
          <Header
            cartLength={this.state.cart.products.length}
            {...this.state}
            onLogout={this.handleLogout}
          />
          <Switch>
            <Route
              path="/"
              exact
              component={() => (
                <ProductList
                  addToCart={this.addToCart}
                  productAlreadyInCart={this.productAlreadyInCart}
                  isAuthenticated={this.state.isAuthenticated}
                  userType={this.state.userType}
                />
              )}
            />
            <PrivateRoute
              authenticated={this.state.isAuthenticated}
              path="/product/new"
              exact
              component={ProductCreate}
              createProduct={this.createProduct}
            />

            <PrivateRoute
              path="/cart"
              authenticated={this.state.isAuthenticated}
              exact
              component={() => <Cart cart={this.state.cart} />}
            />

            <PrivateRoute
              path="/select-address"
              authenticated={this.state.isAuthenticated}
              exact
              component={() => (
                <AddressSelection
                  cart={this.state.cart}
                  resetCart={this.resetCart}
                  currentUser={this.state.currentUser}
                />
              )}
            />

            <PrivateRoute
              path="/add-address"
              authenticated={this.state.isAuthenticated}
              exact
              component={() => (
                <AddressForm currentUser={this.state.currentUser} />
              )}
            />

            <PrivateRoute
              path="/my-inventory"
              authenticated={this.state.isAuthenticated}
              exact
              component={() => <Inventory />}
            />

            <PrivateRoute
              path="/farmer-orders"
              authenticated={this.state.isAuthenticated}
              exact
              component={() => <FarmerOrders />}
            />

            <Route
              path="/signin"
              exact
              component={() => (
                <SignIn
                  setAuthentication={this.setAuthentication}
                  setUserType={this.setUserType}
                  getCartProducts={this.getCartProducts}
                />
              )}
            />

            <Route path="/orders" exact component={() => <Orders />} />
            <Route
              path="/farmer-signup"
              exact
              component={() => <FarmerSignUp />}
            />
            <Route
              path="/consumer-signup"
              exact
              component={() => <ConsumerSignUp />}
            />
          </Switch>
        </Router>
      </div>
    );
  }
}
export default App;
