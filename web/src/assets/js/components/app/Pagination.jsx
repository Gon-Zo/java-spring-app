import React from "react";
import {Button, ButtonGroup, Col, Row} from "react-bootstrap";
import {AppPageTheme, AppTheme} from "../../modules/static/support";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import * as i from "@fortawesome/free-solid-svg-icons";

export default (props) => {

    let cnt = props.count
    let page = props.page;
    let showPages = props.showPages;

    let _onReFresh = props.refresh;

    let numPage = Array.from(Array(props.numPages).keys()).map(m => m + 1)

    if (typeof cnt === 'undefined' || cnt === 0) {
        return null
    }

    let first = numPage[0]
    let last = numPage[numPage.length-1]

    let _angleEvent = (type)=> {
        let val = page
        if (type === 'L') {
            if (first != page) {
                val = page - 1
                _onReFresh(val)
            }
        } else {
            if (last !== page) {
                val = page + 1
                _onReFresh(val)
            }
        }
    }

    let _angleDouble = (type)=>{
        let val = type === 'L' ? first : last;
        _onReFresh(val)
    }

    return (
        <Row>
            <Col>
                <div>
                    <h6 className="pagination-sm-title main-ft">
                        All is {cnt} ShowPage is {showPages}
                    </h6>
                </div>
            </Col>
            <Col>
                <ButtonGroup className="pagination pagination-wrap">
                    <Button variant={AppTheme()} type="button" onClick={()=>_angleDouble('L')}>
                        <FontAwesomeIcon icon={i.faAngleDoubleLeft}/>
                    </Button>
                    <Button variant={AppTheme()} type="button" onClick={()=>_angleEvent('L')}>
                        <FontAwesomeIcon  icon={i.faAngleLeft}/>
                    </Button>
                    {
                        numPage.map((m, i) => (
                            <Button variant={AppPageTheme(m, page)} key={i} onClick={() => _onReFresh(m)}>{m}</Button>
                        ))
                    }
                    <Button variant={AppTheme()} type="button" onClick={()=>_angleEvent('R')}>
                        <FontAwesomeIcon icon={i.faAngleRight}/>
                    </Button>
                    <Button variant={AppTheme()} type="button" onClick={()=>_angleDouble('R')}>
                        <FontAwesomeIcon icon={i.faAngleDoubleRight}/>
                    </Button>
                </ButtonGroup>
            </Col>
        </Row>
    )
}
