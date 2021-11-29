import React from 'react';
class Address extends React.Component {
  constructor(props) {
    super(props);
    this.state = { selected: false };
  }

  render() {
    let { address } = this.props;
    return (
      <>
        <div
          className={address.selected ? 'item active' : 'item'}
          style={{ border: '1px solid gray' }}
          onClick={() => {
            this.props.setAddress(address.id);
          }}
        >
          <div className="content">
            <div>{address.houseNumber},</div>
            <div>Road No:{address.road},</div>
            <div>{address.street}</div>
            <div>{address.area}</div>
            <div>{address.mandal}</div>
            <div>{address.district}</div>
            <div>{address.state}</div>
            <div>{address.landMark}</div>
            <div>{address.pincode}</div>
            <div>
              {address.phoneNumber},{address.alternateNumber}
            </div>
          </div>
        </div>
        <br />
      </>
    );
  }
}

export default Address;
