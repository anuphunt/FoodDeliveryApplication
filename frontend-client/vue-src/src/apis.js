module.exports = class Api {
	getHostUrl(){
		return 'http://localhost:8081';
	}
	getRegisterApi(){
		return this.getHostUrl()+'/register';
	}
	getLoginApi(){
		return this.getHostUrl()+'/login';
	}
	getUserInfoApi(){
		return this.getHostUrl()+'/users';//+{id} with get request
	}
	getUserInfoByUsernameApi(){
		return this.getHostUrl()+'/users/username';//+{id} with get request
	}
	getAllRestaurentApi(){
		return this.getHostUrl()+'/users/restaurants';
	}
	getRestaurentFoods(){
		return this.getHostUrl()+'/foods/restaurant';
	}
	getFoodDetailApi(){
		return this.getHostUrl()+'/foods';//+{id}
	}
	getEditAccountApi()
	{
	return this.getHostUrl()+'/userid';//+{id}

	}
	//http://localhost:8081/foods/89
	//http://localhost:8081/foods/14
}