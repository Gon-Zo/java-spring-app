import Vue from 'vue'
import Router from 'vue-router'
import blog from "../components/blog/blog";
import user from "../components/user/user";

Vue.use(Router)

// import Vuex from 'vuex'
// Vue.use(Vuex)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'user',
      component: user
    },
    {
      path: '/blog',
      name: 'blog',
      component: blog
    }
  ]
})
