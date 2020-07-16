import React from "react";
import {Switch, Route , BrowserRouter} from 'react-router-dom';

import Sidebar from "../common/Sidebar";

import Home from './Home'
import Setting from './Setting'
import UserManagement from './UserManagement'
import ProductManagement from "./ProductManagement";
import CommentManagement from "./CommentManagement";
import MyInfo from './MyInfo'

export default () => {

    return (

        <div className="wrapper">

            <Sidebar/>

            <div className="container-fluid">
                <Switch>
                    <Route exact path="/home" component={Home}/>
                    <Route path="/user/management" component={UserManagement}/>
                    <Route path="/product/management" component={ProductManagement}/>
                    <Route path="/comment/management" component={CommentManagement}/>
                    <Route path="/setting" component={Setting}/>
                    <Route path="/myinfo" component={MyInfo}/>
                </Switch>
            </div>

        </div>

    )

}
