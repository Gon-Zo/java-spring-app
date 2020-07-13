import React from "react";
import {Switch, Route , BrowserRouter} from 'react-router-dom';

import Sidebar from "../common/Sidebar";

import Home from './Home'
import Dashboard from './Dashboard'
import Setting from './Setting'
import Management from './Management'
import MyInfo from './MyInfo'

export default () => {

    return (

        <div className="wrapper">

            <Sidebar/>

            <div className="container-fluid">
                <Switch>
                    <Route exact path="/home" component={Home}/>
                    <Route path="/management" component={Management}/>
                    <Route path="/dashboard" component={Dashboard}/>
                    <Route path="/setting" component={Setting}/>
                    <Route path="/my-info" component={MyInfo}/>
                </Switch>
            </div>

        </div>

    )

}
