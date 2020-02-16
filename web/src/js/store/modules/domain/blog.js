const state = {
  title: 'title success',
  content: '',
}
const getters = {
  title: (state) => {
    return state.title
  },
  content: (state) => {
    return state.content
  },
}
const mutations = {

  setTitle: (state, data) => {
    state.title = data
  }

}
const actions = {

  actionToBlog(context) {
    console.log("Action success...")
  }

}
export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
}
