import React, {useState} from 'react'
import {useDispatch, useSelector} from "react-redux";
import {$fetchUsers , $onPage } from "../../modules/api/user";
import {Button, ButtonGroup} from "react-bootstrap";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import * as i from '@fortawesome/free-solid-svg-icons'

export default (props) => {

    let initUser = useSelector(state => state.userReducer, []);
    let dispatch = useDispatch()

    let page = props.page
    let cnt = props.count;
    let numPage = props.numPage;

    let theme = initUser.isTheme ? "primary" : "dark";
    let theme2 = initUser.isTheme ? "light" : "secondary";

    if (typeof numPage == 'undefined') {
        return null
    }

    let temp = new Array();

    for (let i = 0; i < numPage; i++) {
        temp.push(i + 1)
    }

    let first = temp[0]
    let last = temp[temp.length-1]

    let _onClick = (val) => {
        $onPage(dispatch , val)
        $fetchUsers(dispatch , initUser)
    }

    let _angleEvent = (type)=> {
        let val = page
        if (type === 'L') {
            if (first != page) {
                val = page - 1
                _onClick(val)
            }
        } else {
            if (last !== page) {
                val = page + 1
                _onClick(val)
            }
        }
    }

    let _angleDouble = (type)=>{
        let val = type === 'L' ? first : last;
        _onClick(val)
    }

    return (
        <div className="row">
            <div className="col">
                <div>
                    <h6 className="pagination-sm-title main-ft">전체 수 <span>{cnt}</span>
                    </h6>
                </div>
            </div>
            <div className="col">
                <ButtonGroup className="pagination pagination-wrap" role="aria-label">
                    <Button variant={theme} type="button" onClick={()=>_angleDouble('L')}>
                        <FontAwesomeIcon icon={i.faAngleDoubleLeft}/>
                    </Button>
                    <Button variant={theme} type="button" onClick={()=>_angleEvent('L')}>
                        <FontAwesomeIcon  icon={i.faAngleLeft}/>
                    </Button>
                    {
                       temp.map((m,i)=>(
                           <Button variant={m == page ? theme2 : theme} type="button" key={i}
                                   onClick={() => _onClick(m)} >{m}</Button>
                       ))
                    }
                    <Button variant={theme} type="button" onClick={()=>_angleEvent('R')}>
                        <FontAwesomeIcon icon={i.faAngleRight}/>
                    </Button>
                    <Button variant={theme} type="button" onClick={()=>_angleDouble('R')}>
                        <FontAwesomeIcon icon={i.faAngleDoubleRight}/>
                    </Button>
                </ButtonGroup>
            </div>
        </div>
    )

}
