<template>
  <el-container class="box">
    <el-header>
      <el-link type="success"
               @click="jumpView('/shopCar')">购物车({{shopCarSize}})</el-link>
      &nbsp;&nbsp;&nbsp;
      <el-link type="primary"
               @click="jumpView('/address')">收货地址</el-link>
    </el-header>
    <el-container>
      <el-aside>
        <img class="show-img"
             :src="prod.requirePath">
      </el-aside>
      <el-main class="prod-info">
        <p>{{prod.prodInfo}}</p>
        <p>价格：{{prod.prodPrice}}￥</p>
        <p>送至：芜湖市鸠江区国家级广告产业园B座614</p>
        <p>规格：{{prod.prodUnit}}</p>
        <p>数量:
          <el-input-number v-model="buyNums"
                           :min="1"
                           :max="10"
                           label="购买数量"></el-input-number>
        </p>
        <el-button type="primary"
                   @click="addCarts(prod.id)">加入购物车</el-button>
        <el-button type="success"
                   @click="jumpView('/payInfo')">立即购买</el-button>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      prod: {},
      buyNums: '',
      shopCarSize: 0
    }
  },
  methods: {
    /**
     * 获取产品信息
     */
    getProdInfo (id) {
      let _this = this
      this.axios.get('/citysell/prod/' + id).then(function (resp) {
        _this.prod = resp.data.data
        _this.prod.requirePath = require('../assets/images/' + _this.prod.imgPath)
      })
    },

    /**
     * 添加购物车
     */
    addCarts (prodId) {
      let param = 'prodId=' + prodId + "&buyNums=" + this.buyNums
      let _this = this
      this.axios.post('/citysell/carts/add', param, { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } }).then(function () {
        // 刷新购物车数量
        _this.axios.get('/citysell/carts/count').then(function (resp) {
          _this.shopCarSize = resp.data.data
        })
      })
    }
  },

  mounted () {
    if (sessionStorage.getItem("store") && !this.$store.state.prodId) {
      //this.$store.replaceState是vue官方提供的一个api表示替换 store 的根状态
      //里面的Object.assign()表示将store中的状态和sessionStorage中的状态进行合并
      this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem("store"))))
    }

    // 1.获取产品信息
    this.getProdInfo(this.$store.state.prodId)

    // 2.获取购物车数量
    let _this = this
    this.axios.get('/citysell/carts/count').then(function (resp) {
      _this.shopCarSize = resp.data.data
    })
  }
}
</script>

<style scoped>
.el-main {
  background-color: #e9eef3;
  color: #333;
}

.box {
  width: 50%;
  margin: 0px auto;
}

.prod-info {
  text-align: left;
}
</style>