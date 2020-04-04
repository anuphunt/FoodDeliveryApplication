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
	getEditAccountApi(){
		return this.getHostUrl()+'/users/update';//+{id}
	}
	getPlaceOrderApi(){
		return this.getHostUrl()+'/orders/new';
	}
	// Order restaurent service
	getRestaurentPendingOrderApi(){
		return this.getHostUrl()+'/orders/restaurants/pendingOrders';//+{restaurantId}
	}
	getRestaurentAddFoodApi(){
		return this.getHostUrl()+'/foods/new';
	}

	//http://localhost:8081/foods/89
	//http://localhost:8081/foods/14
}