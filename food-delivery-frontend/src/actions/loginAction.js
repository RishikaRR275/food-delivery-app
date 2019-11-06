
function sendLoginOtp() {
    return {
        type: "SEND_LOGIN_OTP",
        
    }
}

function authCustomer(status){
	return{
		type: "AUTH_CUSTOMER",
		payload: status
	}
}

function customerReg(regStatus){
	return{
		type: "CUSTOMER_REG",
		payload:regStatus,
	}
}

function switchToSignUpForm(){
	return{
		type: "SWITCH_TO_SIGNUP"
	}
}

function switchToLoginForm(){
	return{
		type: "SWITCH_TO_LOGIN"
	}
}


export {sendLoginOtp, authCustomer, customerReg, switchToSignUpForm, switchToLoginForm};
