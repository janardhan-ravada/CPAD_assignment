import React from 'react';
import { Accordion } from 'semantic-ui-react';

import Order from './Order';
import { getOrders } from '../../apis/APIUtil';

class Orders extends React.Component {
  state = { activeIndex: -1, orders: [] };

  handleClick = (activeOrder) => {
    let currentActiveIndex = this.state.activeIndex;
    let newIndex = currentActiveIndex === activeOrder ? -1 : activeOrder;
    this.setState({ activeIndex: newIndex });
  };

  componentDidMount() {
    getOrders().then((orders) => {
      this.setState({ orders: orders });
    });
  }

  render() {
    if (this.state.orders.length === 0) {
      return <div>No Orders Yet</div>;
    }
    debugger;
    let orderMarkUp = this.state.orders.map((order) => (
      <Order
        handleClick={this.handleClick}
        key={order.id}
        order={order}
        activeIndex={this.state.activeIndex}
      />
    ));
    return (
      <Accordion fluid styled>
        {orderMarkUp}
      </Accordion>
    );
  }
}

export default Orders;
