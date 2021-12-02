import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'

Vue.config.productionTip = false;

Vue.use(ElementUI);
Vue.prototype.axios = axios;
Vue.prototype.jumpView = function (addr) {
  this.$router.push(addr)
}

window.addEventListener("beforeunload", () => {
  sessionStorage.setItem("store", JSON.stringify(store.state))
})

new Vue({
  router,
  store,
  render: (h) => h(App),

}).$mount("#app");
