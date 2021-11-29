import React from 'react';

import { Input } from 'semantic-ui-react';
import axios from '../../apis/axios';

class ConsumerSignUp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      phoneNumber: '',
      password: '',
      userType: 'CONSUMER',
      enterpriseName: '',
    };
  }

  addConsumer = () => {
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

        <button type="button" className="ui button" onClick={this.addConsumer}>
          Submit
        </button>
      </form>
    );
  }
}

export default ConsumerSignUp;
