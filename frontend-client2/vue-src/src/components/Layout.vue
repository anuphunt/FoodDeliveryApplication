<template>
	<div>
		<nav>
			<router-link to="/">Home</router-link>
			<router-link to="/login">Login</router-link>
			<router-link to="/signup">Signup</router-link>
		</nav>
		<router-view/>
	</div>
</template>
<script>
export default {
	name: 'Layout',
	props: {
		msg: String
	}
}
</script>