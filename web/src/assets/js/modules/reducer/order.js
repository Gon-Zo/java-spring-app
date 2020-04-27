let SETFROM = "order/setFrom"
let SETTO = "order/setTo"

export const setFrom = (from) => ({type: SETFROM, start: from})
export const setTo = (to) => ({type: SETTO, end: to})

let initOrder = {
   startDay : '',
   endDay : '',
   orders : undefined ,
   order : undefined ,
}

let orderReducer = (state = initOrder, action) => {

   switch (action.type) {
      case SETFROM :
         state.startDay = action.start;
         break;
      case SETTO :
         state.endDay = action.end
   }

   return state;
}

export default orderReducer