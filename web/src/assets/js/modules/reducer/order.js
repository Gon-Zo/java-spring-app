let SETFROM = "order/setFrom"
let SETTO = "order/setTo"
let SETORDERS = "order/setItem"
let UPDATELIST = "order/setList"
let UPDATEOFFSET = "order/setOffset"
let UPDATESCROLLTOP = "order/setScrollTop"

export const setFrom = (from) => ({type: SETFROM, start: from})
export const setTo = (to) => ({type: SETTO, end: to})
export const setOrders = (data) => ({type: SETORDERS, data: data})
export const setList = (data) => ({type: UPDATELIST, data: data})
export const setOffset = (data) => ({type: UPDATEOFFSET, data: data})
export const setScrollTop = (data) => ({type: UPDATESCROLLTOP, data: data})

let initOrder = {
    startDay: '',
    endDay: '',
    orders: undefined,
    order: undefined,
    list: undefined,
    offset: 10,
    scrollTop: 0,
}

let orderReducer = (state = initOrder, action) => {

    switch (action.type) {
        case SETFROM :
            state.startDay = action.start;
            break;
        case SETTO :
            state.endDay = action.end;
            break;
        case SETORDERS:
            let data = action.data;
            state.orders = data.map(m => {

                let prod = m.product;

                let user = m.user;

                let cnt = m.cnt;

                let createdAt = m.createdAt;

                return {
                    prodTitle: prod.title,
                    userEmail: user.email,
                    cnt: cnt,
                    createdAt: createdAt
                }
            })

            state.list = state.orders.slice(0,10)
            break;

        case UPDATELIST:
            state.list = action.data
            break;
        case UPDATEOFFSET:
            state.offset = action.data
            break;
        case UPDATESCROLLTOP :
            state.scrollTop = action.data
            break;
   }

   return state;
}

export default orderReducer