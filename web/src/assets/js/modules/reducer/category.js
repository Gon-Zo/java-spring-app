let SETCATEGORY = 'category/setData';
let OPENINPUT  = 'category/isOpen';

export const setCategory = (data) => ({type: SETCATEGORY, data: data});
export const isOpenToCategory = () => ({type: OPENINPUT})

let initData = {
   category : undefined,
   categories : undefined,
   isOpen : false
}


let categoryReducer = (state = initData , action )=>{

   switch (action.type) {

      case SETCATEGORY :
         state.categories = action.data;
         break;
      case OPENINPUT:
         state.isOpen = !state.isOpen;
         break;

   }

   return state
}


export default categoryReducer
