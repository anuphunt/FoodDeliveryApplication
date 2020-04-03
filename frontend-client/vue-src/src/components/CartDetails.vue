<template>
    <div class="container container-height">
        <div class="row">
        </div>
    </div>
</template>
<script type="text/javascript">
export default {
  name: 'RestaurentProducts',
  props: {
    msg: String
  },
  data(){
    return {
      cartItems:this.helper.getCart()
    }
  },
  methods:{
    addToCart:function(foodId,quantity){
      
      this.helper.addToCart(foodId,quantity);
    }
  },
  mounted(){

    if(this.helper.getUserInfo().username == ''){
            this.helper.unsetUserInfo();
            this.$router.push('/login');
    }else{

        if(this.helper.getUserInfo().role == this.helper.userRole.user || this.helper.getUserInfo().role == this.helper.userRole.restaurant){
                     

        }else{
           this.helper.unsetUserInfo();
           this.$router.push('/login');
        }

    }
        
    
  }
}
</script>