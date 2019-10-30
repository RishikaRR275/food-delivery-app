import React from 'react'
import TextField from '@material-ui/core/TextField'
import { Button, } from '@material-ui/core';
import { connect } from 'react-redux';
import login from '../Actions/login'

class LoginForm extends React.Component {
	constructor() {
		super();
		this.state = {
			contact: '',
			otp: '',
			otpFieldType: "hidden",
		};
	}

	handleContactChange = (evt) => {
		this.setState({ contact: evt.target.value });
	}

	handleOTPChange = (evt) => {
		this.setState({ otp: evt.target.value });
	}
	handleLogin = (evt) => {
		this.setState({ otpFieldType: "" });
	}

	render() {
		return (
			<div>
				<TextField
					id="contact"
					label="Contact"
					placeholder="Contact"
					margin="normal"
					variant="outlined"
					style={{ width: 200 }}
					value={this.state.contact}
					onChange={this.handleContactChange}
				/>

				<br />


				<TextField
					type={this.state.otpFieldType}
					id="OTP"
					//label="OTP"
					placeholder="OTP"
					margin="normal"
					variant="outlined"
					style={{ width: 200 }}
					value={this.state.otp}
					onChange={this.handleOTPChange}
				/>


				<br />
				<Button
					variant="outlined"
					onClick={this.handleLogin}
				>
					Login
				</Button>

			</div>
		)
	}
}

export default connect(null, { login })(LoginForm);