
const loginReducer = (state = {
	status: '',
	displayingForm: 'login',
	regStatus: '',
},
	action) => {
	switch (action.type) {
		case "SEND_LOGIN_OTP":
			state = {
				...state,
			}
			break;

		case "AUTH_CUSTOMER":
			state = {
				...state,
				status: action.payload,
			}
			break;

		case "CUSTOMER_REG":
			state = {
				...state,
				regStatus: action.payload,
			}
			break;

		case "SWITCH_TO_SIGNUP":
			state = {
				...state,
				displayingForm: 'signUp'
			}
			break;

		case "SWITCH_TO_LOGIN":
			state = {
				...state,
				displayingForm: 'login'
			}
			break;

		default:
			break;
	}
	return state;
}

export default loginReducer;