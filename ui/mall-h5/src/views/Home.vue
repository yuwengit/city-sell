<template>
  <el-container>
    <el-header>
      <form action="">
        <input type="text">
        <input type="submit"
               value="搜索" />
      </form>
    </el-header>
    <el-main>
      <img v-for="prod in prodData"
           :key="prod.id"
           :src="prod.requirePath"
           @click="goToDetail(prod.id)"
           class="show-img"
           alt="img">
    </el-main>

    <el-footer>
      <p>@copyright yuwen</p>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  data () {
    return { prodData: [] }
  },
  methods: {
    /**
     * 获取商品数据
     */
    prodList () {
      let _this = this
      this.axios.get("/citysell/prod/list").then(function (response) {
        response.data.data.records.forEach(item => {
          // 把图片地址转换一下
          item.requirePath = require('../assets/images/' + item.imgPath)
        })
        _this.prodData = response.data.data.records
      })
    },

    /**
     * 去商品详情页
     */
    goToDetail (id) {
      // 使用vuex传递id
      this.$store.state.prodId = id
      this.$router.push('/productDetail')
    }
  },
  /**
   * 页面加载就执行该方法
   */
  mounted () {
    this.prodList()
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
