import React from 'react';
import { getFarmerOrders } from '../../apis/APIUtil';
class FarmerOrders extends React.Component {
  constructor(props) {
    super(props);
    this.state = { orders: [] };
  }
  getOrders = () => {
    getFarmerOrders().then((response) => {
      debugger;
      this.setState({ orders: response });
    });
  };
  componentDidMount() {
    this.getOrders();
  }
  render() {
    return <div>Farmer Orders</div>;
  }
}

export default FarmerOrders;
