import Vue from 'vue'
import Router from 'vue-router'
import blog from "../components/blog/blog";
import user from "../components/user/user";

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(Router);
Vue.use(BootstrapVue);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'blog',
      component: blog
    },
    {
      path: '/user',
      name: 'user',
      component: user
    }
  ]
})
