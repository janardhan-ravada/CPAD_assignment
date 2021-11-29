import React from 'react';
import { Input } from 'semantic-ui-react';
import axios from '../../apis/axios';
class FarmerSignUp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      phoneNumber: '',
      password: '',
      userType: 'FARMER',
      enterpriseName: '',
    };
  }

  createFarmer = () => {
    axios.post('/auth/signup', {
      ...this.state,
    });
  };
  render() {
    return (
      <form className="ui form">
        <div className="field">
          <label>Name</label>
          <Input
            placeholder="Farmer name"
            value={this.state.name}
            onChange={(e) => this.setState({ name: e.target.value })}
          />
        </div>
        <div className="field">
          <label>Email</label>
          <Input
            placeholder="Provide Email Address"
            value={this.state.email}
            onChange={(e) => this.setState({ email: e.target.value })}
          />
        </div>
        <div className="field">
          <label>Phone Number</label>
          <Input
            placeholder="Provide Phonenumber"
            value={this.state.phoneNumber}
            onChange={(e) => {
              this.setState({ phoneNumber: e.target.value });
            }}
          />
        </div>

        <div className="field">
          <label>Password</label>
          <Input
            type="password"
            placeholder="Enter Password"
            value={this.state.password}
            onChange={(e) => {
              this.setState({ password: e.target.value });
            }}
          />
        </div>

        <div className="field">
          <label>Publishing Name</label>
          <Input
            placeholder="Publishing Name"
            value={this.state.enterpriseName}
            onChange={(e) => {
              this.setState({ enterpriseName: e.target.value });
            }}
          />
        </div>

        <button type="button" className="ui button" onClick={this.createFarmer}>
          Submit
        </button>
      </form>
    );
  }
}

export default FarmerSignUp;
