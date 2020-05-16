// todo : fetch to change ...

import React, {useEffect, useState} from "react";
import Table from "../components/app/Table";
import {useSelector, useDispatch} from "react-redux";
import {$deleteUser, $fetchUsers, $isUserModalOpen, $setUser, $isUse, $pushSortData} from '../modules/api/user'
import {UserInfoModal} from "../components/app/AppModal";
import Pagination from "../components/app/Pagination";
import LineChart from "../components/chart/LineChart";
import BarChart from "../components/chart/BarChart";
import {_bindData} from "../modules/static/support";

export default () => {

    let dispatch = useDispatch()
    let initUser = useSelector(state => state.userReducer, []);

    useEffect(() => {
        $fetchUsers(dispatch, initUser)
    }, []);

    let _onReFresh = (val) => {
        initUser.page = val
        $fetchUsers(dispatch, initUser)
    }

    let filter = [
        {key: 'email', name: "이메일"},
        {key: 'birthDate', name: "생년월일"},
        {key: 'address', name: "주소"},
        {key: 'isUse', name: "상태"},
        {key: 'createdAt', name: "등록일"}
    ]

    let payload = _bindData(initUser.users , filter);

    let _isUse = (idx, flag) => {
        let data = initUser.users.content[idx]
        $isUse(dispatch, idx, data, flag)
    }

    let _onEdit = () => {

    }

    let _onDelete = (idx) => {
        let seq = initUser.users.data[idx].seq;
        $deleteUser(dispatch, {idx: seq, data: initUser})
    }

    let _sortTable = (idx) => {
        let key = payload.key[idx]
        $pushSortData(dispatch, key)
    }

    return (
        <div className="container-main">
            <UserInfoModal initData={initUser} dispatch={dispatch}/>

            <div className="card-group">
                <div className="card card-user card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">사용자 추이</span>
                    </div>
                    <div className="card-body">
                        <LineChart/>
                    </div>
                </div>
                <div className="card card-user card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">사용자 추이</span></div>
                    <div className="card-body">
                        <BarChart/>
                    </div>
                </div>
            </div>

            <div className="mt-4">

                <Table data={payload.data}
                       keys={payload.key}
                       switch={_isUse}
                       update={_onEdit}
                       delete={_onDelete}
                       sort={_sortTable}
                       sortData={initUser.sort}
                />

                <Pagination count={payload.count}
                            numPages={payload.numPages}
                            showPages={payload.showPages}
                            refresh={_onReFresh}
                            page={initUser.page}
                />

            </div>
        </div>
    )
}
