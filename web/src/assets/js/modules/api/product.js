import React  from 'react';
import axios from 'axios';
import {setProducts, setProduct, isOpenProd, setType, setIsSold, setChartData} from '../reducer/product'

/**
 * 상품 리스트 호출
 * @param dispatch
 * @returns {Promise<void>}
 */
export function $httpProduct(dispatch , payload ) {
    axios.get(`/manager/product`, {
        params : {
            page: payload.page - 1,
            size: payload.numPage,
            sort : '',
            // sort: payload.sort.toString(),
        }
    })
        .then(res => {
            dispatch(setProducts(res.data))
        })
        .catch((err) => console.log(err))
}

/**
 * 상품등록
 * @param dispatch
 * @param payload
 * @returns {Promise<void>}
 */
export function createProduct(dispatch, payload) {
    return axios.post(`/manager/product`, payload)
        .then(res => {})
        .catch(error => console.log(error))
}

/**
 * 상품 호출
 * @param dispatch
 * @param seq
 * @returns {Promise<void>}
 */
export function getProduct(dispatch, seq) {
    axios.get(`/manager/product/${seq}`)
        .then(res => dispatch(setProduct(res.data)))
        .catch(error => console.log(error))
}

/**
 * 상품 수정
 * @param dispatch
 * @param payload
 * @returns {Promise<void>}
 */
export function updateProduct(dispatch, payload) {
    console.log('update', JSON.stringify(payload))
    return axios.put(`/manager/product/${payload.seq}`, parserParam(payload))
        .catch(err=>console.log(err))
}

/**
 * 상품 삭제
 * @param dispatch
 * @param seq
 * @returns {Promise<void>}
 */
export function $deleteByProd(dispatch , seq) {
    axios.delete(`/manager/product/${seq}`)
        .then(res => {} )
        .catch(err => console.log(err))
}

export function $setProduct(dispatch, payload) {
    dispatch(setProduct(payload))
}

export function $setIsSold(dispatch ,data , idx , flag) {
    dispatch(setIsSold(idx, flag))
    updateProduct(dispatch , data)
}

let parserParam = (param) => {
    let keys = Object.keys(param)
    let temp = {}
    keys.filter(f => f !== 'store' && f != 'create_at').map(m => temp[m] = param[m])
    return temp
}


export function $httpProductChart(dispatch) {

    axios.get(`/manager/product/chart`)
        .then((res) => dispatch(setChartData(res.data)))
        .catch(err => console.log(err))

}
