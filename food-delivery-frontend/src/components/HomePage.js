import React from 'react';
import Header from './Header';


export default class HomePage extends React.Component {
	render() {
		return (
			<div>
				<Header sendLoginOtp={this.props.sendLoginOtp}
					authCustomer={this.props.authCustomer}
					customerReg = {this.props.customerReg}
					switchToSignUpForm = {this.props.switchToSignUpForm}
					switchToLoginForm = {this.props.switchToLoginForm}
					status = {this.props.status}
					displayingForm={this.props.displayingForm}
				/>
			</div>
		);
	}
}