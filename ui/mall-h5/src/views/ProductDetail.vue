<template>
  <div class="container">
    <div class="col-md-12 column">
      <p class="menu">
        <router-link to="/shopCar"
                     class="menu-item">购物车(1)</router-link>
        <router-link to="/address"
                     class="menu-item">收货地址</router-link>
      </p>
    </div>
    <div class="row clearfix">
      <div class="col-md-3 column">
        <img class="show-img"
             src="@/assets/images/外套1.png">
      </div>
      <div class="col-md-7 column">
        <p class="prod-info">芊森依 【多款可选】羽绒服女2021新款韩版羽绒外套宽松加厚连帽中长款白鸭绒大毛领 A款-宽松版-西柚红 M【110-130斤】</p>
        <p class="prod-info">价格：199￥</p>
        <p class="prod-info">：芜湖市鸠江区国家级广告产业园B座614</p>
        <p class="prod-info">规格：件</p>
        <p class="prod-info">数量:<input class="form-control"
                 placeholder="数量"
                 type="number"></p>

        <button type="button"
                class="btn btn-danger">加入购物车</button>
        <router-link to="/payInfo"
                     type="button"
                     class="btn btn-success">立即购买</router-link>
      </div>
    </div>
  </div>
</template>


<script>
import 'bootstrap/dist/css/bootstrap.min.css'
export default {

}
</script>

<style scoped>
.prod-info {
  font: 700 16 px Arial, "microsoft yahei";
  color: #666;
  padding-top: 10 px;
  line-height: 28px;
  margin-bottom: 5 px;
  text-align: left;
}
.form-control {
  display: inline-block;
  width: 15%;
  margin-left: 10px;
}
.menu {
  text-align: right;
}
.menu-item {
  margin: 5px 10px;
  text-decoration: underline;
}
.btn {
  margin: 0px 10px;
}
</style>