import React, {useEffect} from "react";
import {
    $deleteByProd,
    $httpProduct,
    $httpProductChart,
    $isOpen,
    $setIsSold,
    $setMethod,
    $setProduct
} from '../modules/api/product'
import {useDispatch, useSelector} from "react-redux";
import { ProductEditor} from "../components/app/AppModal";
import Pagination from "../components/app/Pagination";
import Table from "../components/app/Table";
import PieChart from "../components/chart/PieChart";
import BubbleChart from "../components/chart/BubbleChart";
import {_bindData} from "../modules/static/support";
import LineChart from "../components/chart/LineChart";

export default () => {

    let dispatch = useDispatch();
    let initProd = useSelector(state => state.productReducer, []);


    useEffect(() => {
        $httpProduct(dispatch, initProd);
        $httpProductChart(dispatch);
    }, []);
    let _onReFresh = (val) =>{
        initProd.page = val
        $httpProduct(dispatch, initProd);
    }

    let _isSold = (idx, flag) => {
        let data = initProd.products.data
        $setIsSold(dispatch, data[idx], idx, flag)
    }

    let filter = [
        {key : "title" , name : "상품명"} ,
        {key : "cnt" , name : "수량"} ,
        {key : "price" , name : "가격"} ,
        {key : "isSold" , name : "품절유무"} ,
    ]

    let payload = _bindData(initProd.products, filter)

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

    let _lineChartData = (payload) =>{

        if(typeof payload == 'undefined') {
            return undefined;
        }

        return payload.map(p => {
            let title = p.title;
            let val = p.val
            return {
                id: p.title,
                color: "hsl(207, 70%, 50%)",
                data: [
                    {
                        x: title,
                        Y: val
                    }
                ]
            }
        })

    }

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
                        <LineChart data={_lineChartData(initProd.chartData)}/>
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

                <Table data={ payload.data}
                          keys={payload.key}
                          delete={_onDelete}
                          update={_onEdit}
                          switch={_isSold}/>

                <Pagination count={payload.count}
                            numPages={payload.numPages}
                            showPages={payload.showPages}
                            refresh={_onReFresh}
                            page={initProd.page}/>

            </div>

        </div>
    )
}
