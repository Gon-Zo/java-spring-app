import React, {useEffect} from "react";
import {$deleteByProd, $httpProduct, $isOpen, $setIsSold, $setMethod, $setProduct} from '../modules/api/product'
import {useDispatch, useSelector} from "react-redux";
import { Product} from "../modules/data/AppDto";
import { ProductEditor} from "../components/app/AppModal";
import Pagination from "../components/app/Pagination";
import Table from "../components/app/Table";
import RadarChart from "../components/chart/RadarChart";
import PieChart from "../components/chart/PieChart";
import BubbleChart from "../components/chart/BubbleChart";

export default () => {

    let dispatch = useDispatch();
    let initProd = useSelector(state => state.productReducer, []);

    useEffect(() => {
        $httpProduct(dispatch, initProd);
    }, []);

    // let $onClick = () => {
    //     $setMethod(dispatch, 'I');
    //     $setProduct(dispatch, new Product());
    //     $isOpen(dispatch)
    // };

    let _onReFresh = (val) =>{
        initProd.page = val
        $httpProduct(dispatch, initProd);
    }

    let _isSold = (idx, flag) => {
        let data = initProd.products.data
        $setIsSold(dispatch, data[idx], idx, flag)
    }

    let _bindData = () =>{
        let payload = initProd.products;
        let count = payload.count;
        let numPages = payload.numPages;
        let showPages = payload.showPages;
        let result = []
        let keys = []

        if (typeof payload.data !== 'undefined') {
            keys = Object
                .keys(payload.data[0])
                .filter(f => f != 'store' && f != 'info' && f != 'seq' && f != 'create_at')
            payload.data
                .forEach(m => {
                    let temp = {}
                    keys.forEach(f => {
                        temp[f] = m[f]
                    })
                    result.push(temp)
                })
        }

        return {
            count: count,
            numPages: numPages,
            showPages: showPages,
            data: result,
            keys: keys
        }
    }

    let _onEdit = (idx) => {
        let payload = initProd.products.data
        $setMethod(dispatch, 'U');
        $setProduct(dispatch, payload[idx]);
        $isOpen(dispatch)
    };

    let _onDelete = (idx) => {
        let data = initProd.products.data
        let deleteNo = data[idx].seq;
        $deleteByProd(dispatch, initProd , deleteNo)
    };

    return (
        <div className="container-main">

            {/*<div className="text-right p-3">*/}
            {/*    <Button variant={AppTheme()} className="ml-2" onClick={$onClick}>등록</Button>*/}
            {/*</div>*/}

            <ProductEditor isOpen={initProd.isOpen}
                           dispatch={dispatch}
                           data={initProd}/>

            <div className="card-group">
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">상품 분석</span>
                    </div>
                    <div className="card-body">
                        <RadarChart/>
                    </div>
                </div>
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">상품 추이</span>
                    </div>
                    <div className="card-body">
                        <PieChart/>
                    </div>
                </div>
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">상품 분석</span>
                    </div>
                    <div className="card-body">
                        <BubbleChart/>
                    </div>
                </div>
            </div>

            <div className="mt-4">

                <Table data={_bindData().data}
                          keys={_bindData().keys}
                          delete={_onDelete}
                          update={_onEdit}
                          switch={_isSold}/>

                <Pagination count={initProd.products.count}
                            numPages={initProd.products.numPages}
                            refresh={_onReFresh}
                            page={initProd.page}/>
            </div>

        </div>
    )
}
