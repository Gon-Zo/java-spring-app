import React, {useEffect, useState} from "react";
import {Button, Tab, Tabs} from 'react-bootstrap'
import {$httpGetMenus, $httpGetRoles, $httpGetUrls, $httpGetUsers} from "../modules/api/controller";
import {useDispatch, useSelector} from "react-redux";
import Table from "../components/app/Table";
import {_bindData} from "../modules/static/support";
import Pagination from "../components/app/Pagination";

export default () => {

    let [key, setKey] = useState('Menus');

    let [payload, setPayload] = useState([])

    let dispatch = useDispatch()

    let initData = useSelector(state => state.controllerReducer, [])

    let _selectKey = (k) => {
        switch (k) {
            case "Users":
                $httpGetUsers(dispatch)
                break;
            case "Menus":
                $httpGetMenus(dispatch)
                break;
            case "Roles":
                $httpGetRoles(dispatch)
                break;
            case "Urls":
                $httpGetUrls(dispatch)
                break;
        }
        setKey(k)
    }

    // useEffect(()=>{
    //     $httpGetMenus(dispatch)
    //     return () =>{
    //         console.log("TEST SUCCESS")
    //     }
    // } , [])

    useEffect(() => {
        $httpGetMenus(dispatch)
    }, []);

    let _onReFresh = () => {
    }
    let _onEdit = () => {
    }
    let _onDelete = () => {
    }

    return (
        <div>
            <Tabs defaultActiveKey={key}
                  id="uncontrolled-tab-example"
                  onSelect={(k) => _selectKey(k)}>

                <Tab eventKey="Menus" title="Menus">
                    <div  className="container-main">

                        <Table data={_bindData(initData.menus, filterBy(key)).data}
                               keys={_bindData(initData.menus, filterBy(key)).key}
                               update={_onEdit}
                               delete={_onDelete}
                        />

                        <Pagination count={_bindData(initData.menus, filterBy(key)).count}
                                    numPages={_bindData(initData.menus, filterBy(key)).numPages}
                                    showPages={_bindData(initData.menus, filterBy(key)).showPages}
                                    refresh={_onReFresh}
                                    // page={initUser.page}
                                    page={1}
                        />

                    </div>
                </Tab>

                <Tab eventKey="Users" title="Users">
                    <div  className="container-main">

                        <Table data={_bindData(initData.users, filterBy(key)).data}
                               keys={_bindData(initData.users, filterBy(key)).key}
                               update={_onEdit}
                               delete={_onDelete}
                        />
                        <Pagination count={_bindData(initData.users, filterBy(key)).count}
                                    numPages={_bindData(initData.users, filterBy(key)).numPages}
                                    showPages={_bindData(initData.users, filterBy(key)).showPages}
                                    refresh={_onReFresh}
                                    page={1}
                        />

                    </div>
                </Tab>


                <Tab eventKey="Roles" title="Roles">
                    <div>
                        <span>TEST3</span>
                    </div>
                </Tab>

                <Tab eventKey="Urls" title="Urls">
                    <div>
                        <span>TEST4</span>
                    </div>
                </Tab>

            </Tabs>
        </div>

    )
}


let filterBy = (k) => {
    let filter;
    switch (k) {
        case "Menus":
            filter = [
                {key: 'title', name: '메뉴명'},
                {key: 'url', name: "주소"},
                {key: 'icon', name: "아이콘"}
            ]
            break;
        case "Users":
            filter = [
                {key: 'email', name: "이메일"},
                {key: 'birthDate', name: "생년월일"},
                {key: 'address', name: "주소"},
                {key: 'isUse', name: "상태"},
                {key: 'createdAt', name: "등록일"}
            ]
            break;
    }
    return filter;
}


