<template>
  <div class="container">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <form action="">
          <input type="text">
          <input class="btn btn-default"
                 type="submit"
                 value="搜索" />
        </form>
      </div>
    </div>
    <div class="row clearfix">
      <div class="col-md-12 column">
        <img @click="goToDetail(1)"
             class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
        <img class="show-img"
             src="@/assets/images/外套1.png">
      </div>
    </div>
    <div class="row clearfix">
      <div class="col-md-12 column">
        <p>@copyright yuwen
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css'
export default {
  methods: {
    goToDetail (id) {
      console.log(id)
      this.$router.push('/productDetail')
    }
  }
}
</script>

<style scoped>
.show-img {
  margin: 5px;
  cursor: pointer;
  transition: all 0.5s;
}
.show-img:hover {
  transform: scale(1.1);
}
</style>
