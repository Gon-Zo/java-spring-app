import Vue from "vue";
import Vuex from 'vuex'
Vue.use(Vuex);

import user from "./modules/domain/user";
import blog from "./modules/domain/blog";
import table from "./modules/domain/table";

const store = new Vuex.Store({
  modules: {
    user,
    blog,
    table,
  }
})

export default store
