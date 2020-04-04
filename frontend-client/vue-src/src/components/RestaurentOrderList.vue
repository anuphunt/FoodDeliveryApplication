<template>
    <div class="container container-height">
        <div class="col-lg-12">
        <div class="row">
          <RestaurentNav/>
          <table cellspacing="0" id="tech-companies-1" class="table table-small-font table-bordered table-striped">
                        <thead>
                          <tr>
                            <th>Order Items</th>
                            <th>Order Date</th>
                            <th>Customer name</th>
                            <th>Price</th>
                            <th>Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr v-for="(order,index) in orders" :key="index">
                            <td>Order Items</td>
                            <td>09/23/2019</td>
                            <td>John</td>
                            <td>$340</td>
                            <td>
                              <a href="" class="btn btn-xs btn-success">Accept</a>
                              &nbsp;<a href="" class="btn btn-xs btn-danger">Reject</a>
                            </td>
                          </tr>
                        </tbody>
                      </table>
        </div>
        </div>
    </div>
</template>
<script type="text/javascript">
  import RestaurentNav from './RestaurentNav';
export default {
  name: 'RestaurentOrderList',
  props: {
    msg: String
  },
  components:{
    RestaurentNav
  },
  data(){

    return {
      orders:[],
      orderType:this.$route.params.type
    }
  },
  mounted(){
    if(this.helper.getUserInfo().username == ''){
            this.helper.unsetUserInfo();
            this.$router.push('/login');
    }else{
      
        if(this.helper.getUserInfo().role == this.helper.userRole.restaurant){
              // var resId = 3;
              var apiUrl = '';
              var resId = this.helper.getUserInfo().id;
              if(this.orderType == 'new'){
                apiUrl = this.api.getRestaurentPendingOrderApi()+'/'+resId;
              }else{
                apiUrl = this.api.getRestaurentPendingOrderApi()+'/'+resId;
              }
              this.helper.request({
                    type: 'get',
                    withData:'json',
                    // auth:false,
                    url: apiUrl,
                    dataType:'json',
                    complete:()=>{
                    },
                    success:(resp)=>{
                      this.orders = resp;
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