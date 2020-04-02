<template>
    <div class="container container-height">
        <div class="row">
          <div class="col-sm-4" v-for="(food, index) in foods" :key="index">
            <router-link :to="{path: '/foods/' + food.foodId}" >
              <div class="grid-item">
                        <div class="p-item mrgb-30">
                            <div class="p-item-img">
                                <div class="p-item-img">
                                  <img alt="3" src="/dummy.jpg">
                                  <a class="qv-btn" href="#">Buy Now</a>
                                </div>
                            </div>
                            <div class="p-item-info">
                                <div class="price-tag">
                                    <span class="reg-price">$690.00</span>
                                    <!-- <span class="cut-price">$690.00</span> -->
                                </div>
                                <h2><a href="#">{{food.name}}</a></h2>
                                <button class="btn-all">Add to Cart</button>
                            </div>
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
                        //var resId = this.$route.params.id;
                        var resId = 12;
                        this.helper.request({
                              type: 'get',
                              withData:'json',
                              auth:false,
                              url: this.api.getRestaurentFoods()+'/'+resId,
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