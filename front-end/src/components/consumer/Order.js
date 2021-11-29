import React from 'react';
import { Accordion, Icon } from 'semantic-ui-react';
import { Grid, Image } from 'semantic-ui-react';
class Order extends React.Component {
  render() {
    let productsMarkup = this.props.order.products.map((product) => (
      <Grid>
        <Grid.Column width={1}></Grid.Column>
        <Grid.Column width={4}>
          <Image
            src={product.imageURL}
            style={{ width: '150px', height: '150px' }}
          />
        </Grid.Column>
        <Grid.Column width={6}>
          <div>{product.name}</div>
          <div>Quantity: {product.orderedQuantity}</div>
          <div>
            Packet Price: {product.packPriceWithDiscount}{' '}
            <del>{product.packPrice}</del>
          </div>
          <div>
            Discount Applied : -{product.discountOnPack}
            {product.discountType === 'PERCENTAGE' ? '%' : 'RS'}
          </div>
        </Grid.Column>
        <Grid.Column width={3}>
          <div>
            Price : {product.packPriceWithDiscount * product.orderedQuantity}
          </div>
        </Grid.Column>
      </Grid>
    ));

    return (
      <>
        <Accordion.Title
          active={this.props.activeIndex === this.props.order.id}
          onClick={() => {
            this.props.handleClick(this.props.order.id);
          }}
        >
          <Icon name="dropdown" />

          <Grid columns={4} divided>
            <Grid.Row>
              <Grid.Column>Order# {this.props.order.id}</Grid.Column>
              <Grid.Column>Status: {this.props.order.status}</Grid.Column>
              <Grid.Column>
                Price: {this.props.order.totalPriceWithDiscount}
              </Grid.Column>
              <Grid.Column>
                Ordered Date: {this.props.order.createdDate}
              </Grid.Column>
            </Grid.Row>
          </Grid>
        </Accordion.Title>
        <Accordion.Content
          active={this.props.activeIndex === this.props.order.id}
        >
          {productsMarkup}
        </Accordion.Content>
      </>
    );
  }
}

export default Order;
