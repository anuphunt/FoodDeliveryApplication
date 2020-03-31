module.exports = class Api {
	getHostUrl(){
		return 'http://localhost:8081';
	}
	getRegisterApi(){
		return this.getHostUrl()+'/authentication/register';
	}
	getLoginApi(){
		return this.getHostUrl()+'/authentication/login';
	}

}