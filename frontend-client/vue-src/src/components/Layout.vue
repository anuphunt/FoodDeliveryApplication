<template>
    <div>
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
                          <li> <a href="myaccount.html">Account</a>
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
                                <a href="index.html"><img src="/logo.png" alt="logo"></a>
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
                                <span class="cart-count">10</span>
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
        <section class="main-body"><router-view/></section>
        <footer>
            <div class="foot-top">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-md-3 mrgb-30">
                            <h3>Information</h3>
                            <ul>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Delivery Information</a></li>
                                <li><a href="#">Privacy and Policy</a></li> 
                                <li><a href="#">Contact Us</a></li>
                                <li><a href="#">FAQ’s</a></li>
                                <li><a href="#">Blog</a></li>
                            </ul>
                        </div>                      
                        <div class="col-sm-4 col-md-3 mrgb-30">
                            <h3>Customer Service</h3>
                            <ul>
                                <li><a href="#">Returns</a></li>
                                <li><a href="#">Site Map</a></li>
                                <li><a href="#">Order History</a></li> 
                                <li><a href="#">Other Services</a></li>
                                <li><a href="#">Sitemap</a></li>
                                <li><a href="#">Topography</a></li>
                            </ul>
                        </div>                      
                        <div class="col-sm-4 col-md-3 mrgb-30">
                            <h3>My Account</h3>
                            <ul>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Signin</a></li>
                                <li><a href="#">Signup</a></li> 
                                <li><a href="#">Cart</a></li>
                                <li><a href="#">Checkout</a></li>
                                <li><a href="#">Wishlist</a></li>
                            </ul>
                        </div>                      
                        <div class="col-sm-12 col-md-3 mrgb-30">
                            <h3>Contact</h3>
                            <address class="mrgb-20">
                                <div class="foot-continfo mrgb-20">
                                    <div class="icon-cont">
                                        <i class="fa fa-paper-plane"></i>
                                    </div>
                                    <div class="add-info">
                                        ur business address is 1063 Free ype and scrambled it to make
                                    </div>    
                                </div>
                                <div class="foot-continfo mrgb-20">
                                    <div class="icon-cont">
                                        <i class="fa fa-phone-square"></i>
                                    </div>
                                    <div class="add-info">
                                        + 977- 010000000
                                    </div>   
                                </div>
                                <div class="foot-continfo mrgb-20">
                                    <div class="icon-cont">
                                        <i class="fa fa-envelope"></i>
                                    </div>    
                                    <div class="add-info">
                                        support@snapb.com
                                    </div>    
                                </div>
                            </address>                          
                            <ul class="social-link">
                                <li><a href="#" target="_blank"><img src="images/icons/fb.png" alt="fb"></a></li>
                                <li><a href="#" target="_blank"><img src="images/icons/youtube.png" alt="youtube"></a></li>
                                <li><a href="#" target="_blank"><img src="images/icons/gplus.png" alt="gplus"></a></li>
                                <li><a href="#" target="_blank"><img src="images/icons/instagram.png" alt="instagram"></a></li>
                            </ul>
                        </div>
                        
                    </div>
                </div>
            </div><!-- footer top end -->           
            <div class="foot-btm">
                <div class="container">
                    <p>© 2019 LockDownFood.com | All Right Reserved.</p>
                </div>
            </div>
            
        </footer><!-- footer end -->
        
    </div>
</template>
<script>
import './../assets/bootstrap-3.3.7-dist/css/bootstrap.min.css'
import './../assets/src/css/menu.css'
import './../assets/src/css/style.css'
import './../assets/src/css/font-awesome.min.css'

export default {
    name: 'Layout',
    props: {
        msg: String
    },

}
</script>