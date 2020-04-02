<template>
    <div class="container container-height">
        <div class="row">
          <div class="col-sm-4" v-for="(restaurent, index) in restaurents" :key="index">
            <div class="panel panel-default">
              <div class="panel-body">
                  <img src="/dummy.jpg">
                     {{restaurent.firstName}}
                   </div>
              </div>
          </div>
        </div>
    </div>
</template>
<script type="text/javascript">
export default {
  name: 'Landing',
  props: {
    msg: String
  },
  data(){
    
    return {
      restaurents:[]
    }
  },
  mounted(){
    if(this.helper.getUserInfo().username == ''){
            this.helper.unsetUserInfo();
            this.$router.push('/login');
    }else{
        console.log(this.helper.getUserInfo());
        if(this.helper.getUserInfo().role == this.helper.userRole.user){

                        this.helper.request({
                              type: 'get',
                              withData:'json',
                              url: this.api.getAllRestaurentApi(),
                              dataType:'json',
                              complete:()=>{
                              },
                              success:(resp)=>{
                                this.restaurents = resp;
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