import React from 'react';
import { Form, Button, Input } from 'semantic-ui-react';
import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';
import { addAddress } from '../../apis/APIUtil';
import history from '../history';

class AddressForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      houseNumber: '',
      roadNumber: '',
      street: '',
      area: '',
      mandal: '',
      district: '',
      state: '',
      pincode: '',
      landMark: '',
      phoneNumber: '',
      alternatePhoneNumber: '',
    };

    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleInputChange(event) {
    const target = event.target;
    const inputName = target.name;
    const inputValue = target.value;

    this.setState({
      [inputName]: inputValue,
    });
  }

  handleSubmit(event) {
    debugger;
    event.preventDefault();

    const addressRequest = Object.assign({}, this.state);
    addAddress(addressRequest)
      .then((response) => {
        Alert.success('Address added!');
        history.push('/select-address');
      })
      .catch((error) => {
        Alert.error(
          (error && error.message) ||
            'Oops! Something went wrong. Please try again!'
        );
      });
  }

  render() {
    return (
      <Form onSubmit={this.handleSubmit}>
        <Form.Field>
          <Input
            placeholder="House#"
            required
            name="houseNumber"
            value={this.state.houseNumber}
            onChange={this.handleInputChange}
          />
        </Form.Field>
        <Form.Field>
          <Input
            placeholder="Road #"
            name="roadNumber"
            value={this.state.roadNumber}
            onChange={this.handleInputChange}
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="Street"
            name="street"
            value={this.state.street}
            onChange={this.handleInputChange}
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="Area"
            name="area"
            value={this.state.area}
            onChange={this.handleInputChange}
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="Mandal"
            name="mandal"
            value={this.state.mandal}
            onChange={this.handleInputChange}
            required
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="District"
            name="district"
            value={this.state.district}
            onChange={this.handleInputChange}
            required
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="State"
            name="state"
            value={this.state.state}
            onChange={this.handleInputChange}
            required
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="Pincode"
            name="pincode"
            type="number"
            value={this.state.pincode}
            onChange={this.handleInputChange}
            required
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="Land mark"
            name="landMark"
            value={this.state.landMark}
            onChange={this.handleInputChange}
            required
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="Primary Phone number"
            name="phoneNumber"
            value={this.state.phoneNumber}
            onChange={this.handleInputChange}
            required
          />
        </Form.Field>

        <Form.Field>
          <Input
            placeholder="Alternate Phone number"
            name="alternatePhoneNumber"
            value={this.state.alternatePhoneNumber}
            onChange={this.handleInputChange}
          />
        </Form.Field>

        <Button type="submit">Submit</Button>
      </Form>
    );
  }
}

export default AddressForm;
