import React  from 'react';
import axios from 'axios';
import {setProducts, setProduct, isOpenProd, setType, setIsSold} from '../reducer/product'
import {decodeJwt} from "../static/auth";

/**
 * 상품 리스트 호출
 * @param dispatch
 * @returns {Promise<void>}
 */
export function $httpProduct(dispatch , payload ) {
    axios.get(`/admin/product`, {
        params : {
            pageNum : 10 ,
            page : payload.page ,
            storeNo : 1,
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
    payload['user_no'] = decodeJwt().seq
    axios.post(`/admin/product`, payload)
        .then(res =>{
            $httpProduct(dispatch)
            dispatch(isOpenProd())
        })
        .catch(error => console.log(error))
}

/**
 * 상품 호출
 * @param dispatch
 * @param seq
 * @returns {Promise<void>}
 */
export function getProduct(dispatch, seq) {
    axios.get(`/admin/product/${seq}`)
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
    axios.put(`/admin/product/${payload.seq}`, parserParam(payload))
        .catch(err=>console.log(err))
}

/**
 * 상품 삭제
 * @param dispatch
 * @param seq
 * @returns {Promise<void>}
 */
export function $deleteByProd(dispatch, payload , seq) {
    axios.delete(`/admin/product/${seq}`)
        .then(res => $httpProduct(dispatch , payload))
        .catch(err => console.log(err))
}

/**
 * 모달 오픈
 * @param dispatch
 * @returns {Promise<void>}
 */
export function $isOpen(dispatch) {
    dispatch(isOpenProd())
}

export function $setMethod(dispatch , payload) {
    dispatch(setType(payload))
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
