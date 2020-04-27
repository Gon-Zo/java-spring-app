import React from "react";
import AppSideBar from "./components/app/AppSideBar";
import Main from "./views";
import {Switch, Route} from 'react-router-dom';
import AppUser from "./views/AppUser";
import AppDashboard from "./views/AppDashboard";
import AppProduct from "./views/AppProduct";
import AppHeader from "./components/app/AppHeader";
import AppMyInfo from "./views/AppMyInfo";
import AppSetting from "./views/AppSetting";
import AppCategory from "./views/AppCategory";
import {AppTheme} from "./modules/static/support";
import {Container} from "react-bootstrap";
import AppOrder from "./views/AppOrder";
import AppUserTest from "./views/AppUserTest";

function Root() {
        return (
            <div className={`theme-${AppTheme()}`}>
                <div className="d-flex  main-bg" id="wrapper">
                    <AppSideBar/>
                    <Container fluid={true} className="pb-4">
                        <AppHeader/>
                    <Switch>
                        <Route exact path="/home" component={Main}/>
                        <Route path="/user" component={AppUser}/>
                        <Route path="/dashboard" component={AppDashboard}/>
                        <Route path="/product" component={AppProduct}/>
                        <Route path="/myinfo" component={AppMyInfo}/>
                        <Route path="/category" component={AppCategory}/>
                        <Route path="/setting" component={AppSetting}/>
                        <Route path="/order" component={AppOrder}/>
                    </Switch>
                    </Container>
                </div>
            </div>
        )
}

export default Root
