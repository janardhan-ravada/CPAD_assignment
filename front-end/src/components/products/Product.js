import React from 'react';
import { Button, Rating, Icon, Input } from 'semantic-ui-react';
class Product extends React.Component {
  constructor(props) {
    super(props);
    this.state = { orderedQuantity: 1 };
  }

  render() {
    debugger;
    return (
      <div className="ui card">
        <div className="image">
          <img src={this.props.product.imageURL} alt="Product" />
        </div>
        <div className="content center aligned">
          <div className="header">{this.props.product.name}</div>
          <div className="meta">
            <div className="date">{this.props.product.desription}</div>
          </div>
          <div className="description">
            <Icon size="small" name="rupee sign" />
            {this.props.product.packPriceWithDiscount}&nbsp; &nbsp;
            <del>
              <Icon size="small" name="rupee sign">
                {this.props.product.packPrice}
              </Icon>
            </del>
          </div>
          <div className="content meta center aligned">
            Available Packs : {this.props.product.remainingPacks}
          </div>
        </div>
        {this.props.isAuthenticated &&
        !this.props.productAlreadyInCart(this.props.product.id) ? (
          <div className="content center algned">
            <div className="content center algned">
              <Button
                className="decrease"
                size="mini"
                onClick={() => {
                  this.setState({
                    orderedQuantity:
                      this.state.orderedQuantity - 1 >= 0
                        ? this.state.orderedQuantity - 1
                        : 0,
                  });
                }}
              >
                -
              </Button>
              <Input
                type="text"
                value={this.state.orderedQuantity}
                onChange={(e) => {
                  this.setState({ orderedQuantity: +e.target.value });
                }}
                className="center aligned"
                size="mini"
              />
              <Button
                className="increase"
                size="mini"
                onClick={() => {
                  let newQuantity =
                    this.state.orderedQuantity + 1 >
                    this.props.product.remainingPacks
                      ? this.props.product.remainingPacks
                      : this.state.orderedQuantity + 1;

                  this.setState({
                    orderedQuantity: newQuantity,
                  });
                }}
              >
                +
              </Button>
            </div>
          </div>
        ) : (
          ''
        )}

        <div className="extra content center aligned">
          <Rating
            defaultRating={this.props.product.defaultRating}
            maxRating={this.props.product.maxRating}
            disabled
          />
        </div>

        <div className="meta center aligned">
          <span className="date">
            Farmer : {this.props.product.farmer.name}
          </span>
        </div>
        {this.props.isAuthenticated ? (
          this.props.productAlreadyInCart(this.props.product.id) ? (
            <div className="extra content diable">
              <Button fluid disabled color="teal">
                IN CART
              </Button>
            </div>
          ) : (
            <div className="extra content">
              <Button
                fluid
                primary
                onClick={() => {
                  this.props.product.orderedQuantity =
                    this.state.orderedQuantity;
                  this.props.addToCart(
                    this.props.product,
                    this.state.orderedQuantity
                  );
                }}
              >
                ADD TO CART
              </Button>
            </div>
          )
        ) : (
          ''
        )}
      </div>
    );
  }
}

export default Product;
