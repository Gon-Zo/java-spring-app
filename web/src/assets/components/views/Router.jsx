import React from "react";
import {Switch, Route , BrowserRouter} from 'react-router-dom';

import Sidebar from "../common/Sidebar";

import Home from './Home'
import Dashboard from './Dashboard'
import Setting from './Setting'
import Management from './Management'

export default () => {
    return (

        <div className="wrapper">

            <Sidebar/>

            <div id="content">

                <div className="container-fluid">
                    <Switch>
                        <Route exact path="/home" component={Home}/>
                        <Route path="/management" component={Management}/>
                        <Route path="/dashboard" component={Dashboard}/>
                        <Route path="/setting" component={Setting}/>
                    </Switch>
                </div>

            </div>

        </div>

    )
}
