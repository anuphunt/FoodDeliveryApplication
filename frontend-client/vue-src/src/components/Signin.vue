<template>
<div class="container">
      <div class="row">
      <div class="col-sm-12 col-md-12 mrgb-30">
        <div class="heading-all mrgb-20">
                  <div class="clearfix">
                        <h1>Register</h1>
                    </div>
                    <div class="hding-sept"></div>
                </div>
                <form @submit="checkForm" method="post" action="./">
                     <p v-if="errors.length" class="text-danger">
                        <b>Please correct the following error(s):</b>
                        <ul>
                          <li v-for="error in errors"   :key="error.key">{{ error.value }}</li>
                        </ul>
                      </p>
                      <div class="row">
                      <div class="col-sm-6 col-md-6">
                        <div class="clearfix mrgb-30">
                          <h3 class="mrgb-20">Personal Information</h3>                            
                            <label for="firstName">First Name</label>
                            <input type="text" v-model="firstName" name="firstName" class="form-control mrgt-10 mrgb-10"/>
                          
                            <label for="lastName">Last Name</label>
                            <input type="text" v-model="lastName"  name="lastName" class="form-control mrgt-10 mrgb-10"/>
                            
                            <label>Email</label>
                            <input type="text" v-model="email" name="email" class="form-control mrgt-10 mrgb-10"/>
                            
                            <label>Phone Number</label>
                            <input type="text"  v-model="phoneNumber"  name="phoneNumber" class="form-control mrgt-10 mrgb-10"/>
                          
                          <hr/>
                          <label>Password</label>
                          <input type="password"  v-model="password" name="password" class="form-control mrgt-10 mrgb-10"/>
                          
                          <label>Password Confirm</label>
                          <input type="password"   v-model="confirmPassword" name="confirmPassword" class="form-control mrgt-10 mrgb-10"/>
                          
                          <hr/>
                          <button class="btn-all pull-right">Register</button>
                        </div>
                      </div>
                    </div><!-- row end -->   
                </form>
           </div>
        </div>
       </div>
</template>
<script type="text/javascript">

export default {
    name: 'Signup',
    data() {
        var usertype = this.$route.params.usertype;

        return {
          errors:[],
          firstName:null,
          lastName:null,
          email:null,
          phoneNumber:null,
          password:null,
          confirmPassword:null,
          role:((usertype == 'user')?'USER':((usertype == 'driver')?'DRIVER':'RESTAURENT'))
        }
    },
    methods:{
    checkForm: function (e) {

      if (this.firstName && this.lastName && this.email && this.phoneNumber && this.password && this.confirmPassword) {

            var formData = new FormData();
            formData.append('firstName', this.firstName);
            formData.append('lastName', this.lastName);
            formData.append('email', this.email);
            formData.append('phoneNumber', this.phoneNumber);
            formData.append('username', 'foo');
            formData.append('password', 'foo');
            formData.append('role', this.role);
            formData.append('confirmPassword', this.confirmPassword);


            this.helper.request({
                  method: 'post',
                  url: this.api.getLoginApi(),
                  dataType:'json',
                  data: formData,
                  success:(resp)=>{
                    console.log(resp);
                  },
                  error:()=>{
                      alert('request not completed.');
                  }

            })
      }

      this.errors = [];
      var i = 0;

      if (!this.firstName) {
        this.errors.push({
            key:i++,
            value:'First name is required'
        });
      }
      if (!this.lastName) {
        this.errors.push({
            key:i++,
            value:'last name is required'
        });
      }
      if (!this.email) {
        this.errors.push({
            key:i++,
            value:'Email is required'
        });
      }
      if (!this.password) {
        this.errors.push({
            key:i++,
            value:'Password is required'
        });
      }
      if (!this.confirmPassword) {
        this.errors.push({
            key:i++,
            value:'Confirm Password is required'
        });
      }
      e.preventDefault();
    }
}
}
</script>