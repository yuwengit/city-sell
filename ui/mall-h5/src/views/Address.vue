<template>
  <el-row style="width:50%;margin: 0px auto">
    <el-col :span="24">
      <div style="text-align:left">
        <el-button type="primary"
                   style="margin:10px 0px"
                   @click="toAddAddr">新增地址</el-button>
      </div>
      <div class="grid-content bg-purple">
        <el-table :data="addressList"
                  stripe
                  border
                  style="width: 100%">
          <el-table-column prop="username"
                           label="姓名">
          </el-table-column>
          <el-table-column prop="phone"
                           label="电话">
          </el-table-column>
          <el-table-column prop="shippingAddr"
                           label="地址">
          </el-table-column>
          <el-table-column fixed="right"
                           label="操作">
            <el-button type="warning"
                       size="small">编辑</el-button>
            <el-button type="danger"
                       size="small"
                       @click="delAddr">删除</el-button>
          </el-table-column>
        </el-table>
      </div>
    </el-col>
  </el-row>
</template>

<script>
export default {
  data () {
    return {
      addressList: [{
        username: "俞文",
        phone: "17775284207",
        shippingAddr: "芜湖国家级广告产业园B座614"
      }, {
        username: "俞文",
        phone: "17775284207",
        shippingAddr: "芜湖国家级广告产业园B座614"
      }]
    }
  },
  methods: {
    delAddr () {
      this.$confirm('是否删除该收货地址?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    toAddAddr () {
      this.$router.push('/addAddress')
    }
  }
}
</script>