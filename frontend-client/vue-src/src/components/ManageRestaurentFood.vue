<template>
    <div class="container container-height">
        <div class="row">
          <RestaurentNav/>
          <div class="form-group">
            <router-link class="btn btn-success" to="/restaurent-add-food">Add New Food</router-link>
          </div>
          <div class="">
            <table cellspacing="0" id="tech-companies-1" class="table table-small-font table-bordered table-striped">
              <thead>
                <tr>
                  <th>Food Name</th>
                  <th>Unit Price</th>
                  <th>Image</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(food, index) in foods" :key="index">
                  <td>{{food.name}}</td>
                  <td>$100</td>
                  <td><img height="120" v-bind:alt="food.name" src="/dummy-food.jpg"></td>
                  <td width="120">
                    <a href="" class="btn btn-xs btn-primary">Edit</a>
                    &nbsp;<a href="" class="btn btn-xs btn-danger">Delete</a>
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
  name: 'RestaurentProducts',
  props: {
    msg: String
  },
  components:{
    RestaurentNav
  },
  data(){
    var apiFoods = []
    return {
      foods:apiFoods
    }
  },
  methods:{
    addToCart:function(foodId,quantity,food){
      food.quantity = quantity;
      this.helper.addToCart(foodId,food);
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