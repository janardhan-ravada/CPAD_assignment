import React from 'react';
import { Grid, Image } from 'semantic-ui-react';

class CartProduct extends React.Component {
  render() {
    return (
      <div>
        <Grid>
          <Grid.Column width={1}></Grid.Column>
          <Grid.Column width={4}>
            <Image
              src={this.props.product.imageURL}
              style={{ width: '150px', height: '150px' }}
            />
          </Grid.Column>
          <Grid.Column width={6}>
            <div>{this.props.product.name}</div>
            <div>Quantity: {this.props.product.orderedQuantity}</div>
            <div>
              Packet Price: {this.props.product.packPriceWithDiscount}{' '}
              <del>{this.props.product.packPrice}</del>
            </div>
            <div>
              Discount Applied : -{this.props.product.discountOnPack}
              {this.props.product.discountType === 'PERCENTAGE' ? '%' : 'RS'}
            </div>
          </Grid.Column>
          <Grid.Column width={3}>
            <div>
              Price :{' '}
              {this.props.product.packPriceWithDiscount *
                this.props.product.orderedQuantity}
            </div>
          </Grid.Column>
        </Grid>
      </div>
    );
  }
}

export default CartProduct;
