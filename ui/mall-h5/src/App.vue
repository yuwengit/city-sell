<template>
  <div id="app">
    <div id="nav">
      <router-link to="/home">点击进入</router-link>
      <span>~~~~~</span>
      <router-link to="/">空白页</router-link>
      <span>~~~~~</span>
      <button @click="goOff">返回</button>
    </div>
    <router-view />
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

<script>
export default {
  methods: {
    goOff () {
      if (window.history.length <= 1) {
        this.$router.push({ path: '/' })
        return false
      } else {
        this.$router.go(-1)
      }
    }
  }
}
</script>
