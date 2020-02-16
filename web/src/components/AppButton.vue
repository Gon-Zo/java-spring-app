<template>
  <p>
    <button @click="onClick">button</button>
  </p>
</template>

<script>
  import {mapActions, mapGetters, mapMutations, mapState} from 'vuex'

  export default {
    name: "AppButton",
    props: ['storeName'],
    methods: {

      ...mapActions({
        buttonOnclick(dispatch){
          return dispatch(`${this.storeName}/buttonOnclick`)
        }
      }),

      onClick() {
        this.buttonOnclick()
      }
    }
  }
</script>

<style scoped>

</style>
