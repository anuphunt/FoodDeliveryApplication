<template>
    <div class="container container-height">
        <div class="row">
          Restaurent order
        </div>
    </div>
</template>
<script type="text/javascript">
export default {
  name: 'RestaurentOrderList',
  props: {
    msg: String
  },
  data(){
    
    return {
      orders:[]
    }
  },
  mounted(){
    if(this.helper.getUserInfo().username == ''){
            this.helper.unsetUserInfo();
            this.$router.push('/login');
    }else{
      
        if(this.helper.getUserInfo().role == this.helper.userRole.restaurant){

                        // this.helper.request({
                        //       type: 'get',
                        //       withData:'json',
                        //       url: this.api.getAllRestaurentApi(),
                        //       dataType:'json',
                        //       complete:()=>{
                        //       },
                        //       success:(resp)=>{
                        //         this.restaurents = resp;
                        //       }

                        // })
                        console.log('here');


        }else{
           this.helper.unsetUserInfo();
           this.$router.push('/login');
        }
        
    }
  }
}
</script>