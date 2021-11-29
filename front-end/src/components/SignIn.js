import React from 'react';
import { Button, Form, Grid, Header, Segment } from 'semantic-ui-react';

import history from './history';

import axios from '../apis/axios';

import './SignIn.css';

class SignIn extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: '',
    };

    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleSubmit(event) {
    event.preventDefault();
    axios
      .post('/auth/login', {
        ...this.state,
      })
      .then((response) => {
        localStorage.setItem('accessToken', response.data.accessToken);
        this.props.setAuthentication(true);
        this.props.setUserType(response.data.userType);
        if (response.data.userType === 'FARMER') {
          history.push('/my-inventory');
        } else {
          this.props.getCartProducts();
          history.push('/');
        }
      });
  }

  render() {
    return (
      <>
        <Grid
          textAlign="center"
          style={{ height: '100vh' }}
          verticalAlign="middle"
        >
          <Grid.Column style={{ maxWidth: 450 }}>
            <Header as="h2" color="blue" textAlign="center">
              Log-in to your account
            </Header>
            <Form size="large" onSubmit={this.handleSubmit}>
              <Segment stacked>
                <Form.Input
                  fluid
                  icon="user"
                  iconPosition="left"
                  placeholder="E-mail address"
                  value={this.state.email}
                  onChange={(e) => {
                    this.setState({ email: e.target.value });
                  }}
                />
                <Form.Input
                  fluid
                  icon="lock"
                  iconPosition="left"
                  placeholder="Password"
                  type="password"
                  value={this.state.password}
                  onChange={(e) => {
                    this.setState({ password: e.target.value });
                  }}
                />

                <Button color="green" fluid size="large">
                  Login
                </Button>
              </Segment>
            </Form>
          </Grid.Column>
        </Grid>
      </>
    );
  }
}

export default SignIn;
