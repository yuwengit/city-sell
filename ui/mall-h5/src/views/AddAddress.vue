<template>
  <el-row style="width:50%;margin: 0px auto">
    <el-form ref="form"
             :model="form"
             label-width="80px"
             style="width:30%;margin: 20px auto;">
      <el-form-item label="姓名">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="电话">
        <el-input v-model="form.phone"></el-input>
      </el-form-item>
      <el-form-item label="收货地址">
        <el-input v-model="form.shippingAddr"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary"
                   @click="onSubmit">立即创建</el-button>
        <el-button @click="toAddrList">取消</el-button>
      </el-form-item>
    </el-form>
  </el-row>
</template>

<script>
export default {
  data () {
    return {
      form: {
        username: '',
        phone: '',
        shippingAddr: ''
      }
    }
  },
  methods: {
    onSubmit () {
      console.log('submit!');
    },
    toAddrList () {
      this.$router.push('/address')
    }
  }
}
</script>