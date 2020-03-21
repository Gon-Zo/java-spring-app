import axios from 'axios'
import name from '../../../../../src/assets/table'

const state ={
  tableData : [],
  headerData : [],
};
const getters ={
  headerData: (state) => {
    return state.headerData
  },
  tableData: (state) => {
    return state.tableData
  },
};
const mutations ={

 buildTableData : (state , data)=>{
   state.tableData = data.data
 },

 setIsOpen : (state , payload)=>{
   state.headerData[payload].isOpen = !state.headerData[payload].isOpen;
 },

  setInputType: (state, payload) => {
    let idx = payload.idx;
    state.headerData[idx].inputType = payload.type;
  }

};
const actions ={

  getTableData : (context , params) =>{

    // fields params
    let fields =
      context.state.headerData
        .filter(f => f.isShow)
        .map(m => m.key)
        .toString();

    //
    // let test1
    let searchVal = context.state.headerData
      .filter(f=>f.inputVal !== '')
      .map(m=>{
      return `${m.key}:${m.inputVal}:${m.inputType}`
    }).toString();

    console.log("search >> " , searchVal);

    axios.get("http://localhost:3030/api/admin/user")
      .then((res)=> context.commit('buildTableData' , res.data))
      .catch(err=>console.log(err))

  },


  createData: (context) => {

    context.state.headerData  = name.map(m=>{
      return {
        key : m.key ,
        name : m.name ,
        isUse : m.isUse ,
        isShow : m.isShow ,
        inputVal : '' ,
        inputType : 'container',
        isOpen : false,
      }
    });

  },


};
export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
}
