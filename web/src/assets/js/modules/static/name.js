// import name from "../../../static/json/name";
// const name = require("../../../static/json/name.json");

import _ from 'lodash'


export default {
    changeNameByProd(data) {
        return setChangeNameByProd(data)
    },
    sortProduct() {
        return setSortProduct()
    }
}

let setChangeNameByProd = (data) => {
    // let array = name.product;
    // let temp = _.sortBy(array, 'order');
    // let result = temp.find((f) => f.key === data);
    // return result.name
};

let setSortProduct = () => {
    // let array = name.product;
    // return _.sortBy(array, 'order').map(a => a.key)
};
