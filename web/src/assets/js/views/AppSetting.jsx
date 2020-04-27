import React from "react";

import {Tab, ListGroup, Col , Row } from "react-bootstrap";
import {AppTheme} from "../modules/static/support";

export default ()=>{

    return (
        <div className="container-main">
            <Tab.Container id="list-group-tabs-example" defaultActiveKey="#link1">

                <ListGroup bg={AppTheme()} horizontal>
                    <ListGroup.Item variant={AppTheme()} href="#link1">배너</ListGroup.Item>
                    <ListGroup.Item variant={AppTheme()} href="#link2">ListGroup</ListGroup.Item>
                </ListGroup>

                <Tab.Content>
                    <Tab.Pane eventKey="#link1">
                        {/*<Sonnet />*/}
                        <span>
                            1
                        </span>
                    </Tab.Pane>
                    <Tab.Pane eventKey="#link2">
                        {/*<Sonnet />*/}
                        <span>
                            2
                        </span>
                    </Tab.Pane>
                </Tab.Content>
            </Tab.Container>
        </div>
    );
}
