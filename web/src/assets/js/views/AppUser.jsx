// todo : fetch to change ...

import React, {useEffect, useState} from "react";
import Table from "../components/app/Table";
import {useSelector, useDispatch} from "react-redux";
import {$deleteUser, $fetchUsers, $isUserModalOpen, $setUser, $isUse, $pushSortData} from '../modules/api/user'
import {UserInfoModal} from "../components/app/AppModal";
import Pagination from "../components/app/Pagination";
import LineChart from "../components/chart/LineChart";
import BarChart from "../components/chart/BarChart";

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

    let _bindData = () => {

        let payload = initUser.users;

        // Data
        let data = typeof payload === 'undefined' ?
            undefined : payload.content;

        // keys
        let keys = typeof data == 'undefined' ?
            undefined :
            Object.keys(data[0])
                .filter(m =>
                    m === 'email' ||
                    m === 'updatedAt' ||
                    m === 'email' ||
                    m === 'birthDate' ||
                    m === 'createdAt' ||
                    m === 'isUse' ||
                    m === 'address'
                )

        let count = typeof payload === 'undefined' ? undefined : payload.totalElements

        let numPages = typeof payload === 'undefined' ? undefined : payload.totalPages

        let showPages = typeof payload === 'undefined' ? undefined : payload.size;

        return {
            data: data,
            key: keys,
            count: count,
            numPages: numPages,
            showPages: showPages,
        }

    }

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
        let key = _bindData().key[idx]
        console.log('key', key);
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

                <Table data={_bindData().data}
                       switch={_isUse}
                       keys={_bindData().key}
                       update={_onEdit}
                       delete={_onDelete}
                       sort={_sortTable}
                       sortData={initUser.sort}
                />

                <Pagination count={_bindData().count}
                            numPages={_bindData().numPages}
                            showPages={_bindData().showPages}
                            refresh={_onReFresh}
                            page={initUser.page}
                />

            </div>
        </div>
    )
}
