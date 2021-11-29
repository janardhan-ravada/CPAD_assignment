import React from 'react';
import { Divider, Header, Segment, Icon } from 'semantic-ui-react';
import { getFarmerInventory } from '../../apis/APIUtil';

class Inventory extends React.Component {
  constructor(props) {
    super(props);
    this.state = { products: [] };
  }

  getInventory() {
    getFarmerInventory().then((response) => {
      this.setState({ products: response });
    });
  }

  componentDidMount() {
    this.getInventory();
  }
  render() {
    let products = this.state.products.map((product) => (
      <>
        <Header as="h3">{product.name}</Header>
        <div>
          Packet Price :<Icon size="small" name="rupee sign" />
          {product.packPrice}
        </div>
        <div>
          Discount offered :{product.discountOnPack}{' '}
          {product.discountType === 'PERCENTAGE' ? '%' : 'Rupees'}
        </div>
        <div>Packet Price with Discount : {product.packPriceWithDiscount}</div>
        <div>Available Packets : {product.remainingPacks}</div>

        <Divider section />
      </>
    ));
    return <Segment>{products}</Segment>;
  }
}

export default Inventory;
