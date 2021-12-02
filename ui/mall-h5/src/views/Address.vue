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
          <el-table-column prop="defaultFlag"
                           label="默认地址"
                           align=center>
            <template slot-scope="scope">
              <i class="el-icon-circle-check"
                 v-if="scope.row.defaultFlag == 1"></i>
            </template>
          </el-table-column>
          <el-table-column fixed="right"
                           label="操作">
            <template slot-scope="scope">
              <el-button type="danger"
                         size="small"
                         @click="delAddr(scope.row.id)">删除</el-button>
            </template>
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
      addressList: []
    }
  },
  methods: {
    addrList () {
      let _this = this
      this.axios.get('/citysell/addr/list')
        .then(function (response) {
          _this.addressList = response.data.data
        })
    },
    delAddr (id) {
      this.$confirm('是否删除该收货地址?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let _this = this
        this.axios.get('/citysell/addr/del?id=' + id)
          .then(function (response) {
            let code = response.data.code
            if (code == 200) {
              _this.$message({
                type: 'success',
                message: '删除成功!'
              });
            } else {
              _this.$message({
                type: 'info',
                message: '删除失败'
              });
            }
            _this.addrList()
          })
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
  },
  mounted () {
    this.addrList();
  }
}
</script>