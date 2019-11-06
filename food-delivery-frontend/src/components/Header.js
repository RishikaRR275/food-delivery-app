import React from 'react';
import { Grid, Button, AppBar, Toolbar } from '@material-ui/core';
import swiggyLogo from '../swiggyLogo.png'
import LoginModal from './LoginModal';

class Header extends React.Component {
	render() {
		return (
			<div>
				<AppBar position="static"
					style={{ "background-color": "white" }}
				>
					<Toolbar>
						<img src={swiggyLogo}
							alt="swiggyLogo"
							width="80"
							height="75"
						/>

						<Grid
							container
							direction="row"
							justify="flex-end"
						>
							<Button
								color="inherit"
								variant="outlined"
								style={{
									align: "right",
									color: "black",
									marginRight: "10px",
									"font-size": "18px",
									"font-weight": "bold",
								}}
							>
								help
					        </Button>

							<LoginModal sendLoginOtp={this.props.sendLoginOtp}
								authCustomer={this.props.authCustomer}
								customerReg = {this.props.customerReg}
								switchToSignUpForm = {this.props.switchToSignUpForm}
								switchToLoginForm = {this.props.switchToLoginForm}
								status = {this.props.status}
								displayingForm={this.props.displayingForm}
							/>
						</Grid>
					</Toolbar>
				</AppBar>
			</div>
		)
	}
}

export default Header;