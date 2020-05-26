import React, {useCallback, useEffect, useState} from "react";
import {$setCategory} from "../modules/api/category";
import {useDispatch, useSelector} from "react-redux";
import Table from "../components/app/Table";
import {_bindData} from "../modules/static/support";

export default () => {

    let dispatch = useDispatch

    let initData = useSelector(state => state.categoryReducer, []);

    useEffect(()=>{
      $setCategory(dispatch)
    },[])

    let filter = [
        {key : 'title' , name : '카테고리명'},
        {key : 'order' , name : '순서'}
    ]

    let payload = _bindData(initData.categories, filter)

    return (
        <div className="container-main">

                   {/*// delete={_onDelete}*/}
                   {/*// update={_onEdit}*/}
                   {/*// switch={_isSold}*/}

            <Table data={payload.data}
                   keys={payload.key}
            />

        </div>
    )
}
