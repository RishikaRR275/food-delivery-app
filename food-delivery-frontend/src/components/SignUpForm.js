import React from 'react'
import { Grid, TextField, Button, Typography, Link } from '@material-ui/core';

class SignUpForm extends React.Component {
	constructor() {
		super();
		this.state = {
			contact: '',
			name: '',
			email: '',
			password: '',
		};
	}

	handleChange = (evt) => {
		this.setState({[evt.target.name]: evt.target.value})
	}

	handleSubmit = () => {
		this.props.customerReg({
			name: this.state.name,
			email: this.state.email,
			contact: this.state.contact,
			password: this.state.password
		})
	}

	handleLink = (evt) => {
		evt.preventDefault();
		this.props.switchToLoginForm();
	}

	render() {
		return (
			<div>
				<Grid
					container
					direction="column"
				>
					<Typography
						variant="h4">
						Sign Up
					</Typography>

					<Typography>
						<Link href="#" onClick={this.handleLink} >
							Or login to your account
     					 </Link>
					</Typography>
					{/* CONTACT */}
					<TextField
						id="contact"
						name = "contact"
						label="Contact"
						placeholder="Contact"
						margin="normal"
						variant="outlined"
						style={{ width: 200 }}
						value={this.state.contact}
						onChange={this.handleChange}
					/>

					{/* NAME */}
					<TextField
						id="name"
						name= "name"
						label="Name"
						placeholder="Name"
						margin="normal"
						variant="outlined"
						style={{ width: 200 }}
						value={this.state.name}
						onChange={this.handleChange}
					/>

					{/* EMAIL */}
					<TextField
						id="email"
						name = "email"
						label="Email"
						placeholder="Email"
						margin="normal"
						variant="outlined"
						style={{ width: 200 }}
						value={this.state.email}
						onChange={this.handleChange}
					/>
					<TextField
						id="outlined-password-input"
						name = "password"
						label="Password"
						type="password"
						autoComplete="current-password"
						margin="normal"
						variant="outlined"
						value={this.state.password}
						onChange={this.handleChange}
					/>

					<Button
						variant="outlined"
						onClick={this.handleSubmit}
					>
						Sign Up
				</Button>
					<div id="ErrorMessage">

					</div>
				</Grid>

			</div>
		)
	}

}

export default SignUpForm;