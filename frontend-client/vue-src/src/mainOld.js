import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

var Api = require('./apis.js');
let api = new Api();
Vue.prototype.api = api;

var Helper = require('./helper.js');
let helper = new Helper();
helper.setAxios(axios);

Vue.prototype.helper = helper;

Vue.prototype.axios = axios;

new Vue({
	router,
	render: h => h(App),
}).$mount('#app-root-container')
