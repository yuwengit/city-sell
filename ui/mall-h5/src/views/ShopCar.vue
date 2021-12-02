<template>
  <el-row style="width:50%;margin: 0px auto">
    <el-col :span="24">
      <div class="grid-content bg-purple">
        <el-table :data="shopCarList"
                  stripe
                  border
                  @selection-change="selectProd"
                  style="width: 100%">
          <el-table-column type="selection"
                           align="center"
                           width="55">
          </el-table-column>
          <el-table-column prop="prodName"
                           align="center"
                           label="商品名称">
          </el-table-column>
          <el-table-column prop="prodPrice"
                           align="center"
                           label="商品价格">
          </el-table-column>
          <el-table-column align="center"
                           label="购买数量">
            <template slot-scope="scope">
              <el-input-number v-model="scope.row.buyNums"
                               :min="1"
                               :max="1000"></el-input-number>
            </template>
          </el-table-column>
          <el-table-column align="center"
                           label="价格">
            <template slot-scope="scope">
              {{scope.row.buyNums*scope.row.prodPrice}}￥
            </template>
          </el-table-column>
          <el-table-column fixed="right"
                           label="操作"
                           align="center">
            <template slot-scope="scope">
              <el-button type="danger"
                         size="small"
                         @click="delCarts(scope.row.prodId)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div style="text-align:right;">
          <div>
            总价：{{totalAmount()}}￥
            <el-button type="primary"
                       @click="pay">立即结算</el-button>
          </div>
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script>
export default {
  data: function () {
    return {
      singlePrice: 0,
      shopCarList: [],
      selectedProdIds: []
    }
  },
  methods: {
    /**
     * 计算总价
     */
    totalAmount () {
      return this.shopCarList.map(
        row => row.prodPrice * row.buyNums).reduce(
          (acc, cur) => (cur + acc), 0)
    },

    /**
     * 查询购物车列表
     */
    getShopCarList () {
      let _this = this
      this.axios.get("/citysell/carts/list").then(function (resp) {
        _this.shopCarList = resp.data.data
      })
    },

    /**
     * 删除购物车中的商品
     */
    delCarts (prodId) {
      let param = "prodId=" + prodId
      let _this = this
      this.axios.post('/citysell/carts/del', param, { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } })
        .then(function (resp) {
          if (resp.data.code == 200) {
            _this.getShopCarList()
          }
        })
    },

    /**
     * 选中商品
     */
    selectProd (id) {
      this.selectedProdIds = id
    },

    /**
     * 立即结算
     */
    pay () {
      let param = []
      if (this.selectedProdIds.length == 0) {
        this.$message({
          showClose: true,
          message: '请选择商品'
        });
        return
      }
      this.selectedProdIds.forEach(item => {
        let unit = {}
        unit.id = item.id
        unit.prodId = item.prodId
        unit.buyNums = item.buyNums
        param.push(unit)
      })
      let _this = this
      this.axios.post('/citysell/carts/pay', param).then(function (resp) {
        _this.$store.state.totalPayAmount = resp.data.data
        _this.$router.push('/payInfo')
      })
    }
  },
  mounted () {
    // 加载购物车数据
    this.getShopCarList()
  }
}
</script>