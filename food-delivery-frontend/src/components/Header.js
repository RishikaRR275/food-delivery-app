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
							justify="flex-end">
							<Button
								color="inherit"
								variant="outlined"
								// className="float-right"
								style={{
									align: "right",
									color: "black",
									"font-size": "18px",
									"font-weight": "bold",
									marginRight: "10px",
								}}
							>
								help
					        </Button>

							{/* <Button
								color="inherit"
								variant="outlined"
								// className="float-right"
								style={{
									align: "right",
									color: "black",
									"font-size": "18px",
									"font-weight": "bold",
									marginRight: "10px",
								}}
							>
								Sign In
							</Button> */}
							<LoginModal/>
						</Grid>
					</Toolbar>
				</AppBar>
			</div>
		)
	}
}

export default Header;