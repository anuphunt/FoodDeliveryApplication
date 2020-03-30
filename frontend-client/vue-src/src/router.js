import Vue from 'vue'
import Router from 'vue-router'
import Landing from './components/Landing.vue'
import Login from './components/Login.vue'
import Signup from './components/Signup.vue'
import ForgotPassword from './components/ForgotPassword.vue'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes:[
		{
			path:'/',
			name:'landing',
			component:Landing
		},
		{
			path:'/login',
			name:'Login',
			component:Login
		},
		{
			path:'/signup',
			name:'Signup',
			component:Signup
		},
		{
			path:'/forgot-password',
			name:'ForgotPassword',
			component:ForgotPassword
		}
	]
})