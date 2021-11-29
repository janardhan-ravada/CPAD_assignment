import React from 'react';

import { Dropdown, Input, TextArea } from 'semantic-ui-react';

class ProductCreate extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      description: '',
      packQuantity: 0,
      packUnit: 'KG',
      packPrice: 0,
      totalPacks: 0,
      discountOnPack: 0,
      totalPacksPrice: 0,
      totalPacksPriceWithDiscount: 0,
      grainType: 'Grain',
      packPriceWithDiscount: 0,
      discountType: 'PERCENTAGE',
    };
  }

  calculatePrices = (discount, discountType) => {
    let noOfPacks = this.state.totalPacks;
    let packPrice = this.state.packPrice;
    let totalPacksPrice = noOfPacks * packPrice;

    let packPriceWithDiscount = 0;
    let totalPacksPriceWithDiscount = 0;

    if (discountType === 'PERCENTAGE') {
      packPriceWithDiscount = packPrice - (packPrice * discount) / 100;
    } else {
      packPriceWithDiscount = packPrice - discount;
    }
    totalPacksPriceWithDiscount = packPriceWithDiscount * noOfPacks;
    this.setState({
      totalPacksPrice,
      packPrice,
      packPriceWithDiscount,
      totalPacksPriceWithDiscount,
    });
  };

  render() {
    const units = [
      { key: 'KG', text: 'Kilo Grams', value: 'KG' },
      { key: 'GRAM', text: 'Grams', value: 'GRAM' },
    ];

    const discountTypes = [
      { key: 'PERCENTAGE', text: '%', value: 'PERCENTAGE' },
      { key: 'RUPEES', text: 'Rupees', value: 'Rupees' },
    ];

    return (
      <form className="ui form">
        <div className="field">
          <label>Name</label>
          <Input
            placeholder="Product name"
            value={this.state.name}
            onChange={(e) => this.setState({ name: e.target.value })}
          />
        </div>
        <div className="field">
          <label>Description</label>
          <TextArea
            rows={2}
            placeholder="Tell us more"
            value={this.state.description}
            onChange={(e) => this.setState({ description: e.target.value })}
          />
        </div>
        <div className="field">
          <label>Packet Quantity</label>
          <Input
            label={
              <Dropdown
                defaultValue="KG"
                options={units}
                onChange={(e, data) => {
                  this.setState({ packUnit: data.value });
                }}
              />
            }
            labelPosition="right"
            placeholder="One Packet Quantity"
            type="number"
            onChange={(e, data) => {
              this.setState({ packQuantity: data.value });
            }}
          />
        </div>
        {/*
        <div className="field">
          <label>Unit Price</label>
          <Input
            label={
              <Dropdown
                defaultValue={this.state.unitPriceMeasurement}
                options={unitsWithPKT}
                onChange={(e, data) => {
                  debugger;
                  this.setState({ unitPriceMeasurement: data.value });
                }}
              />
            }
            labelPosition="right"
            placeholder="Unit Price"
            type="number"
            onChange={(e, data) => {
              debugger;
              console.log(data.value);
            }}
          />
        </div>
        */}
        <div className="field">
          <label>Packet Price</label>
          <Input
            placeholder="Packet Price"
            type="number"
            value={this.state.packPrice}
            onChange={(e, data) => {
              this.setState({ packPrice: e.target.value });
            }}
          />
        </div>

        <div className="field">
          <label>Total Packets</label>
          <Input
            placeholder="Total available packets"
            type="number"
            value={this.state.totalPacks}
            onChange={(e) => {
              let noOfPacks = +e.target.value;
              let packPrice = +this.state.packPrice;
              this.setState({
                totalPacks: noOfPacks,
                totalPacksPrice: noOfPacks * packPrice,
              });
            }}
          />
        </div>

        <div className="field">
          <label>Discount on packet</label>
          <Input
            label={
              <Dropdown
                defaultValue={this.state.discountType}
                options={discountTypes}
                onChange={(e, data) => {
                  let discType = data.value;
                  let discValue = this.state.discountOnPack;
                  this.setState({ discountType: discType });
                  this.calculatePrices(discValue, discType);
                }}
              />
            }
            labelPosition="right"
            placeholder="Discount Amount"
            type="number"
            value={this.state.discountOnPack}
            onChange={(e, data) => {
              let discType = this.state.discountType;
              let discValue = e.target.value;
              this.setState({ discountOnPack: discValue });
              this.calculatePrices(discValue, discType);
            }}
          />
        </div>

        <div className="field">
          <label>Packet Price</label>
          <span>{this.state.packPrice}</span>
        </div>

        <div className="field">
          <label>Packet Price after discount</label>
          <span>{this.state.packPriceWithDiscount}</span>
        </div>

        <div className="field">
          <label>Total Packs Price</label>
          <span>{this.state.totalPacksPrice}</span>
        </div>

        <div className="field">
          <label>Total Packs Price after Discount:</label>
          <span>{this.state.totalPacksPriceWithDiscount}</span>
        </div>

        <button
          type="button"
          className="ui button"
          onClick={() => {
            this.props.createProduct({ ...this.state });
          }}
        >
          Submit
        </button>
      </form>
    );
  }
}

export default ProductCreate;
