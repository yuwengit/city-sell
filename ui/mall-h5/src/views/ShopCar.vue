<template>
  <div class="container">
    <div class="col-md-12 column">
      <table class="table table-bordered">
        <thead>
          <tr>
            <td><input type="checkbox"></td>
            <td>物品名称</td>
            <td>价格</td>
            <td>数量</td>
            <td>价格</td>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in shopList"
              :key="item.id">
            <td><input type="checkbox"></td>
            <td>{{item.shopName}}</td>
            <td>{{item.shopPrice}}￥</td>
            <td><input type="number"
                     class="prod-nums"
                     v-model="item.buyNums"></td>
            <td><span>{{item.shopPrice*item.buyNums}}</span>￥</td>
          </tr>
        </tbody>
      </table>
      <div class="car-opera">
        总价：{{totalAmount()}}￥
        <router-link to="/payInfo"
                     type="button"
                     class="btn btn-success">结算</router-link>
      </div>
    </div>
  </div>
</template>

<style scoped>
.prod-nums {
  width: 15%;
  text-align: center;
}
.car-opera {
  text-align: right;
}
</style>

<script>
import 'bootstrap/dist/css/bootstrap.min.css'
export default {
  data: function () {
    return {
      singlePrice: 0,
      shopList: [{
        id: 1,
        shopName: '外套',
        shopPrice: 99,
        buyNums: 1
      },
      {
        id: 2,
        shopName: 'T恤',
        shopPrice: 100,
        buyNums: 2
      }]
    }
  },
  methods: {
    totalAmount () {
      return this.shopList.map(
        row => row.shopPrice * row.buyNums).reduce(
          (acc, cur) => (cur + acc), 1)
    }
  },
  mounted () { window.vue = this }
}
</script>