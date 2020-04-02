<template>
  <header>
            <div class="hd-top">
                <div class="container">
                    <div class="hdtop-left pull-left">
                        <p>Welcome <a href="#">Guest !</a></p>
                        <p><i class="fa fa-phone"></i>Call to order 099-412035 / 9809496968</p>
                    </div>
                    <ul class="pull-right top-right-new">
                       <div class="btn-group">
                          <li>
                             <router-link to="/login">Login</router-link>
                          </li>
                          <li>
                             <a href ="" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                             Register
                             </a>
                             <div class="dropdown-menu">
                                <router-link class="dropdown-item" to="/signin/user">
                                    <span class="wrap-word"><i class="fa fa-user-plus" aria-hidden="true"></i> Register As User</span>
                                </router-link>
                                <div class="dropdown-divider"></div>
                                <router-link class="dropdown-item" to="/signin/restaurent">
                                    <span class="wrap-word"><i class="fa fa-cutlery" aria-hidden="true"></i> Register As Restaurent</span>
                                </router-link> 
                                <div class="dropdown-divider"></div>
                                <router-link class="dropdown-item" to="/signin/driver">
                                    <span class="wrap-word"><i class="fa fa-car" aria-hidden="true"></i> Register As Driver</span>
                                </router-link>
                             </div>
                          </li>
                          <li>
                             <a href ="" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                             Account
                             </a>
                             <div class="dropdown-menu">
                                <router-link class="dropdown-item" to="/profile">
                                    <span class="wrap-word"><i class="fa fa-user" aria-hidden="true"></i> Your Profile</span>
                                </router-link>
                                <div class="dropdown-divider"></div>
                                <router-link class="dropdown-item" to="/passwordchange">
                                    <span class="wrap-word"><i class="fa fa-lock" aria-hidden="true"></i> Change your password</span>
                                </router-link> 
                             </div>
                          </li>
                       </div>
                    </ul>

                </div><!-- container end -->
            </div>
            <div class="hd-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-8 col-sm-3 col-sm-3">
                            <div class="logo">
                                <router-link to="/"><img src="/logo.png" alt="logo"></router-link>
                            </div>
                        </div>
                        <div class="col-md-7">
                            <div class="hd-search">
                                <form method="post" action="#">
                                    <input type="text" placeholder="Search what you are looking for?">
                                    <button type="submit"><i class="fa fa-search"></i></button>
                                </form>
                            </div>
                        </div>
                        <div class="col-sm-3 col-md-2">
                            <button class="hd-cart pull-right">
                                <span class="text">CART</span>
                                <span class="cart-count">{{countCart}}</span>
                            </button>
                        </div>
                    </div><!-- row end -->
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-1 mrgb-30"></div>
                    <div class="col-sm-12 col-md-10 mrgb-30"></div>
                    <div class="wsmenucontent overlapblackbg"></div>
                    <div class="wsmenuexpandermain slideRight">
                        <a id="navToggle" class="animated-arrow slideLeft"><span></span></a>
                    </div>
                </div>
            </div><!-- container end -->
        </header><!-- header end -->
</template>
<script type="text/javascript">
  export default{
    data(){
      var getCart = this.helper.getCart();
      return {
        countCart:getCart.length
      }
    },
    methods:{
    }
  }
</script>