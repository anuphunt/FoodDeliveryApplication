<template>
    <div class="container container-height">
        <div class="row">
          ds;fkksd;fl
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
      food:null
    }
  },
  mounted(){

    if(this.helper.getUserInfo().username == ''){
            this.helper.unsetUserInfo();
            this.$router.push('/login');
    }else{

        if(this.helper.getUserInfo().role == this.helper.userRole.user || this.helper.getUserInfo().role == this.helper.userRole.restaurant){
                        var foodId = this.$route.params.id;
                        this.helper.request({
                              type: 'get',
                              withData:'json',
                              auth:false,
                              url: this.api.getFoodDetailApi()+'/'+foodId,
                              dataType:'json',
                              complete:()=>{
                              },
                              success:(resp)=>{

                                this.food = resp;
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