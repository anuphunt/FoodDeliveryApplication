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
                <form method="post" action="./">
                    <div class="row">
                      <div class="col-sm-6 col-md-6">
                        <div class="clearfix mrgb-30">
                          <h3 class="mrgb-20">Personal Information</h3>                            
                            <label for="firstName">First Name</label>
                            <input type="text" name="firstName" class="form-control mrgt-10 mrgb-10"/>
                          
                            <label for="lastName">Last Name</label>
                            <input type="text" name="lastName" class="form-control mrgt-10 mrgb-10"/>
                            
                            <label>Email</label>
                            <input type="text" name="email" class="form-control mrgt-10 mrgb-10"/>
                            
                            <label>Teliphone</label>
                            <input type="text" name="teliphone" class="form-control mrgt-10 mrgb-10"/>
                          
                          <hr/>
                          <label>Password</label>
                          <input type="password" name="password" class="form-control mrgt-10 mrgb-10"/>
                          
                          <label>Password Confirm</label>
                          <input type="password" name="confirmpassword" class="form-control mrgt-10 mrgb-10"/>
                          
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
    props: {
        msg: String
    }
}
</script>