<template>
    <div>
        <div class="container">
              <div class="row">
                <div class="col-sm-12 col-md-12 mrgb-30">
                    <div class="heading-all mrgb-20">
                          <div class="clearfix">
                                <h1>Login</h1>
                            </div>
                            <div class="hding-sept"></div>
                        </div>
                        <div class="row">
                        <div class="col-sm-6 col-md-6">
                          <div class="clearfix mrgb-30">
                            <h3 class="mrgb-10">I am a returning customer</h3>
                            <form method="post" @submit="doSignup" action="./">
                              <span >Login Id or email address</span>
                              <input type="text" v-model="username"  name="username" class="form-control mrgt-10 mrgb-10"/>
                              <span class="mrgb-20">Password</span>
                              <input type="password" v-model="password"  name="password" class="form-control mrgt-10 mrgb-10" />
                              <span>
                                <router-link class="font-14 active-text" to="/forgot-password">Forget Password</router-link>
                            </span>
                              <div class="btn-wrap">
                                <input type="submit" name="btnsubmit" value="login" class="btn-all mrgt-10 mrgb-10 pull-right"/>
                              </div>
                            </form>
                          </div><!--right closed-->
                      </div>
                   </div><!-- row end -->  
               </div>
          </div>
          <router-view/>
        </div>
    </div>
</template>
<script>
    export default ({
        name:'Login',
        data(){
          console.log('here');
          return {
            username:null,
            password:null
          }
        },
        methods:{

          doSignup:()=>{
              this.errors = [];
              var i = 0;

              if (!this.username) {
                this.errors.push({
                    key:i++,
                    value:'Username is required'
                });
              }
              if (!this.password) {
                this.errors.push({
                    key:i++,
                    value:'Password is required'
                });
              }
              if (this.errors.length == 0) {
                var formData = new FormData();
                    formData.append('username', this.username);
                    formData.append('password', this.password);

                    this.helper.request({
                          method: 'post',
                          withData:'json',
                          url: this.api.getLoginApi(),
                          dataType:'json',
                          data: formData,
                          success:()=>{
                            this.$router.push('/message');
                          },
                          error:()=>{
                              alert('request not completed.');
                          }

                    })
              }
          }
        }
    })
</script>