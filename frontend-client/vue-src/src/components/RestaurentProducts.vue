<template>
    <div class="container container-height">
        <div class="row">
          <div class="col-sm-4" v-for="(food, index) in foods" :key="index">
            <router-link :to="{path: '/food-details/' + food.foodId}" >
              <div class="panel panel-default">
              <div class="panel-body">
                  <img src="/dummy.jpg">
                     {{food}}
                   </div>
              </div>
            </router-link>
          </div>
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
    var apiFoods = []
    return {
      foods:apiFoods
    }
  },
  mounted(){

    if(this.helper.getUserInfo().username == ''){
            this.helper.unsetUserInfo();
            this.$router.push('/login');
    }else{

        if(this.helper.getUserInfo().role == this.helper.userRole.user || this.helper.getUserInfo().role == this.helper.userRole.restaurant){

                        this.helper.request({
                              type: 'get',
                              withData:'json',
                              url: this.api.getRestaurentFoods()+'/'+this.$route.params.id,
                              dataType:'json',
                              complete:()=>{
                              },
                              success:(resp)=>{

                                this.foods = resp;
                              }

                        })


        }else{
           this.helper.unsetUserInfo();
           this.$router.push('/login');
        }

    }
        
    
  }
}
</script>