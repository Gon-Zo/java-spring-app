import React, {useEffect, useState} from "react";
import {Button, Tab, Tabs} from 'react-bootstrap'
import {$httpGetMenus, $httpGetRoles, $httpGetUrls, $httpGetUsers} from "../modules/api/controller";
import {useDispatch, useSelector} from "react-redux";
import Table from "../components/app/Table";
import Pagination from "../components/app/Pagination";

export default () => {

    let [key, setKey] = useState('Menus');

    let dispatch = useDispatch()

    let initData = useSelector(state => state.controllerReducer, [])

    let payload = initData.payload

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

    useEffect(() => {
        $httpGetMenus(dispatch)
    }, []);

    let _onReFresh = () => {
    }
    let _onEdit = () => {
    }
    let _onDelete = () => {
    }


    function RenderingTable(props) {

        let payload = props.data

        return(
            <div  className="container-main">

                <Table data={payload.data}
                       keys={payload.key}
                       update={_onEdit}
                       delete={_onDelete}
                />

                <Pagination count={payload.count}
                            numPages={payload.numPages}
                            showPages={payload.showPages}
                            refresh={_onReFresh}
                    // page={initUser.page}
                            page={1}
                />

            </div>
        )
    }

    return (
        <div>
            <Tabs defaultActiveKey={key}
                  id="uncontrolled-tab-example"
                  onSelect={(k) => _selectKey(k)}>

                <Tab eventKey="Menus" title="Menus">
                    <RenderingTable data={payload}/>
                </Tab>

                <Tab eventKey="Users" title="Users">
                    <RenderingTable data={payload}/>
                </Tab>


                <Tab eventKey="Roles" title="Roles">
                    <RenderingTable data={payload}/>
                </Tab>

                <Tab eventKey="Urls" title="Urls">
                    <RenderingTable data={payload}/>
                </Tab>

            </Tabs>
        </div>

    )
}

