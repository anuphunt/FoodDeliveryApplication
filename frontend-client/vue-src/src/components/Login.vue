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
                            <h3 class="mrgb-10">I am a new customer</h3>
                            <h4 class="font-14 mrgb-10">Register Account</h4>
                            <p class="mrgb-20">By creating an account you will be able to order faster, be up to date on  an order's
                              status, keep track of the order you have previously made. </p>
                            <!-- <a href="#" class="btn-all">Register</a>  -->
                            <router-link class="btn-all" to="/signup">Register</router-link>
                          </div>
                        </div>
                        <div class="col-sm-6 col-md-6">
                          <div class="clearfix mrgb-30">
                            <h3 class="mrgb-10">I am a returning customer</h3>
                            <form method="post" action="./">
                              <span >Login Id or email address</span>
                              <input type="text" name="email" class="form-control mrgt-10 mrgb-10"/>
                              <span class="mrgb-20">Password</span>
                              <input type="password" name="loginpassword" class="form-control mrgt-10 mrgb-10" />
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
        name:'Login'
    })
</script>