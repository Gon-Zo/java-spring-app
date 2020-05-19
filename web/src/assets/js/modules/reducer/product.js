let SETPRODUCTS = 'product/setProducts'
let SETPRODUCT  = "product/setProduct"
let ISOPEN = 'product/isOpen'
let SETMETHOD = "product/setMethod"
let ISSOLD =  "product/isSold"
let SETCHART = "product/setChart"

export const setProducts = (data) => ({type: SETPRODUCTS , data: data});

export const setProduct = (data) => ({type: SETPRODUCT , data: data});

export const isOpenProd = () => ({type : ISOPEN });

export const setType = (data) => ({type : SETMETHOD  , data : data});

export const setIsSold = (idx , flag) => ({type : ISSOLD , idx : idx , flag : flag})

export const setChartData = (data) => ({type : SETCHART , data : data})

const initProduct = {
    isOpen: false,
    isCategory: false,
    methodType: '',
    products: [],
    product: {},
    category: {},
    page: 1,
    numPage: 10,
    chartData : undefined ,
};

let productReducer = (state = initProduct, action) => {
    switch (action.type) {
        case SETPRODUCTS :
            state.products = action.data;
            break;
        case SETPRODUCT :
            state.product = action.data;
            break;
        case ISOPEN :
            state.isOpen = !state.isOpen;
            break;
        case SETMETHOD :
            state.methodType = action.data;
            break;
        case ISSOLD :
            state.products.data[action.idx].is_sold = action.flag
            break;
        case SETCHART :
            state.chartData = action.data
            break;
    }
    return state;
};

export default productReducer
