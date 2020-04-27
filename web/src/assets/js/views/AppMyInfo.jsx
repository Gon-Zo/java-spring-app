import React, {useEffect, Fragment, useState} from "react";
import {Button, Col, Container} from "react-bootstrap";
import {useDispatch, useSelector} from "react-redux";
import {$getStore , $updateStore} from "../modules/api/setting";
import {$updateUser} from "../modules/api/user";
import Row from "react-bootstrap/Row";
import {AlertDismissible} from "../components/app/AppAlert";


export default () => {

    let dispatch = useDispatch();
    let initSetting = useSelector(state => state.settingReducer, []);

    useEffect(() => {
        $getStore(dispatch)
    }, []);

    let store = initSetting.store;

    let $onClick = () => {
        $updateUser(dispatch, initSetting.store)
        $updateStore(dispatch , initSetting.store)
    };

    if (initSetting.store == null) {
        return  (
            <div>
                <span>TEST..</span>
            </div>

        )
    }

    return (
        <div className="container-main">
            <MyInfoForm data={store.user}/>
            <MyStoreInfo data={store}/>
            <div>
                {/*<AlertDismissible isShow={show}/>*/}
                <Button onClick={$onClick} variant="warning">Success</Button>
            </div>
            {/*Button group end*/}
        </div>
    )

}

/**
 * product title componet
 * @param props
 * @returns {*}
 * @constructor
 */
function ProductTitle(props) {
    let title = props.title;
    return(
        <Row>
            <Col>
                <h4>{title}</h4>
            </Col>
        </Row>
    )
}

/**
 * @return {null}
 */
function MyInfoForm(props) {

    let loginUser = props.data;

    let keys = Object.keys(loginUser)
        .filter(f => f !== 'seq' && f !== 'create_at'  && f !== 'is_use' && f !== 'type' && f !== 'img');

    let checkType = (key) => {
        if (key === 'birthDate') {
            return "date"
        }
        return "text"
    };

    let $onChange = (e) => {
        let name = e.target.name;
        loginUser[name] = e.target.value
    };

    let _onChangeImage = (e) => {
        let file = e.target.files[0];
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            let result = reader.result;
            let img = document.getElementById("myProfile");
            loginUser['img'] = result.split(",")[1];
            img.src = result;
        };
        reader.onerror = function (error) {
            console.log('Error: ', error);
        };
    };

    return (
        <Fragment>
            <ProductTitle title={"My Info"}/>
            <Container>
                <Row>
                    <Col>
                        {
                            keys.map((k, i) => (
                                <div className="input-group" key={i}>
                                    <div className="input-group-prepend">
                                        <span className="input-group-text modal-input-box" id="">{k}</span>
                                    </div>
                                    <input type={checkType(k)} className="form-control" defaultValue={loginUser[k]}
                                           name={k}
                                           onChange={$onChange}/>
                                </div>
                            ))
                        }
                        {/*Input Form end*/}
                        <div>
                            <span>Image</span>
                            <label htmlFor="profileInput">
                                <img id="myProfile" src={"data:image/png;base64, " + loginUser['img']}
                                     width="170px" height="170px" alt={"유저 이미지"}/>
                            </label>
                            <input id="profileInput" className="input-none" type="file" onChange={_onChangeImage}/>
                        </div>
                        {/* Image Form*/}
                    </Col>
                </Row>
            </Container>
        </Fragment>
    )
}

/**
 * @return {null}
 */
function MyStoreInfo(props) {

    let data = props.data;

    let keys = Object.keys(data).filter(f => f !== 'user' && f !== 'img' && f !== 'create_at');

    let checkType = (key) => {
        if (key === 'birthDate') {
            return "date"
        }
        return "text"
    };

    let $onChange = (e) => {
        let name = e.target.name;
        data[name] = e.target.value
    };

    let _onChangeImage = (e) => {
        let file = e.target.files[0];
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            let result = reader.result;
            let img = document.getElementById("myStore");
            data['img'] = result.split(",")[1];
            img.src = result;
        };
        reader.onerror = function (error) {
            console.log('Error: ', error);
        };
    };

    return (
        <Fragment>
            <ProductTitle title={"My Store Info"}/>

            <Container>
                <Row>
                    <Col>
                        {
                            keys.map((k, i) => (
                                <div className="input-group" key={i}>
                                    <div className="input-group-prepend">
                                        <span className="input-group-text modal-input-box" id="">{k}</span>
                                    </div>
                                    <input type={checkType(k)} className="form-control" defaultValue={data[k]}
                                           name={k}
                                           onChange={$onChange}
                                    />
                                </div>
                            ))
                        }
                        <div>
                            <span>Image</span>
                            <label htmlFor="storeInput">
                                <img id="myStore" src={"data:image/png;base64, " + data['img']}
                                     width="170px" height="170px" alt={"유저 이미지"}/>
                            </label>
                            <input id="storeInput" className="input-none" type="file" onChange={_onChangeImage}/>
                        </div>
                        {/* Image Form*/}
                    </Col>
                </Row>
            </Container>
        </Fragment>
    )
}
