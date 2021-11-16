import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Blank",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Blank.vue"),
  },
  {
    path: "/home",
    name: "Home",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Home.vue"),
  },
  {
    path: "/productDetail",
    name: "ProductDetail",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/ProductDetail.vue"),
  },
  {
    path: "/shopCar",
    name: "ShopCar",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/ShopCar.vue"),
  },
  {
    path: "/address",
    name: "Address",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Address.vue"),
  },
  {
    path: "/payInfo",
    name: "PayInfo",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/PayInfo.vue"),
  }
];

const router = new VueRouter({
  routes,
});

export default router;
