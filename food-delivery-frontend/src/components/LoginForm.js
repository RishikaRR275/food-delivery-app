import React from 'react'
import TextField from '@material-ui/core/TextField'
import { Button, Grid, Link, Typography, } from '@material-ui/core';

class LoginForm extends React.Component {
	constructor() {
		super();
		this.state = {
			email: '',
			otp: '',
			otpFieldType: "hidden",
			otpSent: false,
			textFieldDisabled: false,
		};
	}

	componentDidUpdate = (prevProps, prevState) => {

		if (prevProps.status !== this.props.status) {
			console.log(this.props.status);
			if (this.props.status === 'invalid credentials') {
				document.getElementById('ErrorMessage').innerHTML = "Invalid Credentials";
				this.setState({ email: '' });
				this.setState({ otp: '' });
				this.setState({ otpFieldType: "hidden" });
				this.setState({ otpSent: false });
				this.setState({ textFieldDisabled: false });
			}

			if (this.props.status === 'login success') {

			}
		}
	}
	handleEmailChange = (evt) => {
		this.setState({ email: evt.target.value });
	}

	handleOTPChange = (evt) => {
		this.setState({ otp: evt.target.value });
	}

	handleSubmit = (evt) => {
		if (!this.state.otpSent) {
			//sendOtp
			let email = this.state.email;
			this.props.sendLoginOtp(email);
			this.setState({ otpSent: true });
			this.setState({ otpFieldType: "" });
			this.setState({ textFieldDisabled: true });
		}
		if (this.state.otpSent) {
			this.props.authCustomer({ email: this.state.email, otp: this.state.otp })
		}
	}

	handleLink = (evt) => {
		evt.preventDefault();
		this.props.switchToSignUpForm();
	}

	render() {
		return (
			<div>
				<Grid
					container
					direction="column"
				>
					<Typography
					variant = "h4">
						Login
					</Typography>

					<Typography>
						<Link href="#" onClick={this.handleLink} >
							Or create an account
     					 </Link>
					</Typography>

					{/* EMAIL */}
					<TextField
						disabled={this.state.textFieldDisabled}
						id="email"
						label="Email"
						placeholder="Email"
						margin="normal"
						variant="outlined"
						style={{ width: 200 }}
						value={this.state.email}
						onChange={this.handleEmailChange}
					/>

					{/* PASSWORD */}
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

					<Button
						variant="outlined"
						onClick={this.handleSubmit}
					>
						Login
					</Button>
					<div id="ErrorMessage">

					</div>
				</Grid>

			</div>
		)
	}
}

export default LoginForm;