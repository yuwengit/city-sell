<template>
  <div class="container">
    <div class="col-md-12 column">
      <h1>请扫码付款，共计：{{totalPayAmount}}元</h1>
      <img src="@/assets/images/微信收款码.jpg"
           alt="微信收款码.jpg"
           class="img-thumbnail pay-img">
    </div>
  </div>
</template>

<style scoped>
.pay-img {
  width: 30%;
  height: 30%;
}
</style>

<script>
import 'bootstrap/dist/css/bootstrap.min.css'
export default {
  data () {
    return {
      totalPayAmount: ''
    }
  }, mounted () {
    if (sessionStorage.getItem("store") && !this.$store.state.prodId) {
      //this.$store.replaceState是vue官方提供的一个api表示替换 store 的根状态
      //里面的Object.assign()表示将store中的状态和sessionStorage中的状态进行合并
      this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem("store"))))
    }
    this.totalPayAmount = this.$store.state.totalPayAmount
  }
}
</script>