const state = {
  test1: 'test1 sueecc',
  pwd: ''
}
const getters = {
  test1: (state) => {
    return state.test1
  }
}
const mutations = {}
const actions = {
  buttonOnclick(context) {
    let title = context.rootState['blog'].title
    // 글로벌 커밋 commit
    context.commit('blog/setTitle', 'test suucc222222222', {root: true})
    // 글로벌 액션
    context.dispatch('blog/actionToBlog', null, {root: true})
  }

};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
}
