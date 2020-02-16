<template>
  <div>
    <span>User</span>
    <p>
      <span>{{test1}}</span>
    </p>
    <p>
      <span>{{title}}</span>
    </p>
    <AppButton :storeName="namespace"/>
  </div>
</template>

<script>
  import {createNamespacedHelpers} from 'vuex'
  import AppButton from "../AppButton";
  const {mapState, mapGetters, mapMutations, mapActions} = createNamespacedHelpers(['user'])

  export default {
    name: "user",
    components: {AppButton},
    data() {
      return {
        namespace : 'user'
      }
    },
    computed: {
      test1() {
        return this.$store.getters[`${this.namespace}/test1`]
      },
      title(){
        return this.$store.getters['blog/title']
      }
    },
    methods: {


    }
  }
</script>

<style scoped>

</style>
