<template>
    <div class="container container-height">
        Landing page
    </div>
</template>
<script type="text/javascript">
export default {
  name: 'Landing',
  props: {
    msg: String
  },
  data(){
    if(this.helper.getUserInfo().username == ''){

            this.$router.push('/login');
    }else{
        this.helper.getUserInfo();
    }
    return {

    }
  }
}
</script>