import React from 'react';
import Modal from '@material-ui/core/Modal';
import { Button, makeStyles } from '@material-ui/core';
import LoginForm from './LoginForm';
import SignUpForm from './SignUpForm';

function getModalStyle() {
	const top = 50;
	const left = 50;

	return {
		top: `${top}%`,
		left: `${left}%`,
		transform: `translate(-${top}%, -${left}%)`,
	};
}
const useStyles = makeStyles(theme => ({
	paper: {
		position: 'absolute',
		width: 400,
		backgroundColor: theme.palette.background.paper,
		border: '2px solid #000',
		boxShadow: theme.shadows[5],
		padding: theme.spacing(2, 4, 3),
	},
}));



export default function LoginModal(props) {
	const classes = useStyles();
	const [modalStyle] = React.useState(getModalStyle);
	const [open, setOpen] = React.useState(false);

	const handleOpen = () => {
		setOpen(true);
	};

	const handleClose = () => {
		setOpen(false);
	};

	let loginForm = <LoginForm sendLoginOtp={props.sendLoginOtp}
		authCustomer={props.authCustomer}
		status={props.status}
		switchToSignUpForm={props.switchToSignUpForm}
	/>

	let signUpForm = <SignUpForm customerReg={props.customerReg}
		switchToLoginForm={props.switchToLoginForm}
	/>
	let form = (props.displayingForm === 'login') ? loginForm : signUpForm;

	return (
		<div>

			<Button onClick={handleOpen}>
				Sign In
      		</Button>

			<Modal
				aria-labelledby="simple-modal-title"
				aria-describedby="simple-modal-description"
				open={open}
				onClose={handleClose}
			>
				<div style={modalStyle} className={classes.paper}>
					{form}
				</div>
			</Modal>
		</div>
	);
}

