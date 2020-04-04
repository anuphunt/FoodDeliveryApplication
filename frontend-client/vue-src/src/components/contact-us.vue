<template>
<section class="main-body">
   <div class="container">
      <div class="row">
         <div class="col-sm-12 col-md-12 mrgb-30">
            
            <div class="heading-all mrgb-20">
               <div class="clearfix">
                  <h1>Contact us</h1>
               </div>
               <div class="hding-sept"></div>
            </div>
            <div class="row">
               <div class="col-sm-6 col-md-6 mrgb-30 clearfix">
                  <h3>Contact Form</h3>
                  <hr/>
                  <form action="./" method="post">
                     <label for="cName">Name</label>
                     <input type="text" v-model="name" id="cName" class="form-control mrgb-10 mrgt-10" />
                     <label for="cName">Email<Required/></label>
                     <input type="text" v-model="email" name="txtemail" class="form-control mrgb-10 mrgt-10" />
                     <label for="cName">Message<Required/></label>
                     <textarea v-model="message" class="form-control mrgb-10 mrgt-10"></textarea>
                     <input type="submit" name="btnsubmit" value="Send" class="btn-all pull-right" />
                  </form>
               </div>
               <div class="col-sm-6 col-md-6 clearfix contact-dtl">
                  <h3>Contact Address</h3>
                  <hr/>
                  <address class="contact-address mrgb-30">
                     <p><span>Adress:</span>ur business address is 1063 Free ype and <br/> scrambled it to make</p>
                     <p><span>Phone:</span>+ 977- 010000000</p>
                     <p><span>Email:</span>snapb@lossm.com</p>
                  </address>
                  <div class="clearfix mrgb-30">
                     <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d56516.31397712412!2d85.3261328!3d27.708960349999998!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2snp!4v1441094691946" width="100%" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- row end -->  
   </div>
   <!-- container end -->
</section>
</template>
<script>
import Required from './Required'
export default {
        components:{
        Required
        },
        data() {
        return {
          errors:[],
          
        }
    }
}
</script>
		