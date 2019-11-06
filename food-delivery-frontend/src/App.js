import React from 'react';
import './App.css';
import HomePage from './components/HomePage';
import axios from 'axios';
import { connect } from 'react-redux';
import {
	sendLoginOtp,
	authCustomer,
	customerReg,
	switchToSignUpForm,
	switchToLoginForm
} from './actions/loginAction';

class App extends React.Component {
	render() {
		return (
			<div className="App">
				<HomePage sendLoginOtp={this.props.sendLoginOtp}
					authCustomer={this.props.authCustomer}
					customerReg={this.props.customerReg}
					switchToSignUpForm = {this.props.switchToSignUpForm}
					switchToLoginForm = {this.props.switchToLoginForm}
					status={this.props.status}
					displayingForm={this.props.displayingForm}
				/>
			</div>
		);
	}
}

const mapStateToProps = (state) => {
	console.log(state.loginReducer.status)
	return {
		status: state.loginReducer.status,
		displayingForm: state.loginReducer.displayingForm
	};
}

const mapDispatchToProps = (dispatch) => {
	return {
		sendLoginOtp: (email) => {
			axios.post('http://localhost:8080/customer/gen-login-otp', email)
				.then(res => {
					dispatch(sendLoginOtp())
				}
				);
		},

		authCustomer: (credentials) => {
			axios.post('http://localhost:8080/customer/auth-customer', credentials)
				.then(res => {
					dispatch(authCustomer(res.data));
				});
		},

		customerReg: (customer) => {
			axios.post('http://localhost:8080/customer/register-customer', customer)
				.then(res => {
					dispatch(customerReg(res.data));
				});
		},

		switchToSignUpForm: () => {
			dispatch(switchToSignUpForm());
		},

		switchToLoginForm: () => {
			dispatch(switchToLoginForm());
		},
	}
}
export default connect(mapStateToProps, mapDispatchToProps)(App);
