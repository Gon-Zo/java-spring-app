import React, {useEffect, useState} from "react";
import {
    $deleteByProd,
    $httpProduct,
    $httpProductChart,
    $setIsSold,
    $setProduct, createProduct, updateProduct
} from '../modules/api/product'
import {useDispatch, useSelector} from "react-redux";
import Pagination from "../components/app/Pagination";
import Table from "../components/app/Table";
import PieChart from "../components/chart/PieChart";
import {_bindData} from "../modules/static/support";
import LineChart from "../components/chart/LineChart";
import _ from 'lodash'
import AppPopUp from "../components/app/AppPopUp";
import {Button} from "react-bootstrap";

export default () => {

    let dispatch = useDispatch();

    let initProd = useSelector(state => state.productReducer, []);

    let [isOpen, setIsOpen] = useState(false);

    let [prodInfo, setProdInfo] = useState(undefined);

    useEffect(() => {
        $httpProduct(dispatch, initProd);
        $httpProductChart(dispatch);
    }, []);

    let _onReFresh = (val) =>{
        initProd.page = val
        $httpProduct(dispatch, initProd);
    }

    let _isSold = (idx, flag) => {
        let data = payload.data[idx]
        $setIsSold(dispatch, data, idx, flag)
    }

    let filter = [
        {key: "title", name: "상품명", type: ''},
        {key: "cnt", name: "수량", type: "number"},
        {key: "price", name: "가격", type: "number"},
        {key: "isSold", name: "품절유무", type: "boolean"},
        {key: "info", name: "정보", type: ""},
    ]

    let payload = _bindData(initProd.products, filter)

    let _onEdit = (idx) => {
        let data = payload.data[idx]
        $setProduct(dispatch, data);
        setIsOpen(true)
        setProdInfo(initProd.product)
    };

    let _onDelete = (idx) => {
        let deleteNo = payload.data[idx].seq;
        $deleteByProd(dispatch  , deleteNo)
            .then((res)=>{
                $httpProduct(dispatch, initProd);
            })
            .catch(err => console.log(err))
    };

    let _lineChartData = (payload) =>{

        if(typeof payload == 'undefined') {
            return undefined;
        }

        return payload.map(m => {

            let data = _.sortBy(m.data.map(d => {
                return {
                    "x": d.createAt,
                    "y": d.val
                }
            }), "x");

            return {
                id: m.id,
                data: data
            }
        })

    }

    let _onHidden = () => {
       setIsOpen(false);
    }

    let _onCreate = () => {
        setIsOpen(true)
        setProdInfo({
            title: "",
            cnt: 0,
            price: 0,
            isSold: false,
        })
    }

    let _onUpdate = (data) => {

        if(typeof data.seq == 'undefined'){
            createProduct(dispatch , data)
                .then(res => {
                    $httpProduct(dispatch, initProd);
                    setIsOpen(false)
                })
                .catch(err => console.log(err))
        }else{
            updateProduct(dispatch , data)
                .then((res)=>{
                    $httpProduct(dispatch, initProd);
                    setIsOpen(false)
                })
                .catch(err => console.log(err))
        }

    }

    return (
        <div className="container-main">

            <AppPopUp open={isOpen}
                      close={_onHidden}
                      data={prodInfo}
                      keys={filter}
                      update={_onUpdate}/>

            <div className="card-group">
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">상품 추이</span>
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

            </div>

            <div className="mt-2 btn-box">
                <Button onClick={_onCreate}>Input</Button>
            </div>

            <div className="mt-2">

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
