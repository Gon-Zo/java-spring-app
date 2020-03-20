<template>
  <div>
    <div>
      <div v-for=" d in headerData">
        <label>
          {{d.name}}
          <input type="checkbox" v-model="d.isShow"/>
        </label>
      </div>
    </div>

    <table class="table table-dark">
      <thead>
      <tr>
        <th scope="col" v-for=" ( aa , idx ) in headerData ">
          <span v-if="aa.isShow">
            {{aa.name}}
          </span>
        </th>
      </tr>
      <tr>
        <th scope="col" v-for=" aa in headerData">
          <div class="input-group mb-2" v-if="aa.isShow">
            <div class="input-group-prepend">
              <div class="input-group-text">@</div>
            </div>
            <input v-model="aa.inputVal" type="text" class="form-control" placeholder="Username">
          </div>
        </th>
      </tr>
      </thead>
      <tbody>

      <tr v-for="d in tableData">
        <th v-for=" k in headerData">
          <span v-if="k.isShow">
          {{d[k.key]}}
          </span>
        </th>
      </tr>

      </tbody>
    </table>
  </div>
</template>

<script>

  import {mapActions, mapGetters, mapMutations, mapState} from 'vuex'

  export default {
    name: "AppTable",
    created() {
      this.createData();
      this.getTableData()
    },
    computed: mapState({
      headerData(state, getters) {
        return getters[`table/headerData`];
      },
      tableData(state, getters) {
        return getters[`table/tableData`];
      },
    }),
    watch : {
      headerData: {
        handler(val){
          // do stuff
          // console.log("test.." , JSON.stringify(val))
          this.getTableData()
        },
        deep: true
      }
    },
    methods : {
      ...mapActions({
        createData(dispatch){
          return dispatch(`table/createData`)
        },
        getTableData(dispatch){
          return dispatch(`table/getTableData`)
        },
      }),

    }
  }
</script>

<style scoped>

</style>
