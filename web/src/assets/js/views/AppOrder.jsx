import React, {useEffect, useState , useCallback} from "react";
import Table from "react-bootstrap/Table";
import DayPickerInput from 'react-day-picker/DayPickerInput';
import {useDispatch, useSelector} from "react-redux";
import MomentLocaleUtils, {
    formatDate,
    parseDate,
} from 'react-day-picker/moment';
import {$httpOrders, $setList, $setOffset, $setScrollTop, setDay} from "../modules/api/order";

export default () => {

    let theme = useSelector(state => state.userReducer, []).isTheme;

    let init = useSelector(state => state.orderReducer, []);

    let dispatch = useDispatch()

    useEffect(() => {
        $httpOrders(dispatch)
    }, [])

    function RenderContent() {

        if (typeof init.orders == 'undefined') {
            return null;
        }

        let _onScroll = () =>{

            let element = document.getElementById("test1");

            let scrollHeight =  element.scrollHeight;
            let clientHeight = element.clientHeight;
            let scrollTop = element.scrollTop;
            let height = scrollHeight - clientHeight;

            if(height == scrollTop){
                $setOffset(dispatch, init.offset + 10)
                $setList(dispatch, init.orders.slice(0, init.offset))

            }

        }

        let key = Object.keys(init.list[0])

        return(
            <div id="test1" className="tableFixHead mt-3" onScroll={() => _onScroll()}>

                <Table id="rowHeight" striped bordered hover variant={theme ? "light" : "dark"}>
                    <thead>
                    <tr>
                        <th className="table-hd-bg">#</th>
                        {
                            key.map((k, i) => (
                                <th className="table-hd-bg" key={i}>{k}</th>
                            ))
                        }
                    </tr>
                    </thead>
                    <tbody>
                    {
                        init.list.map(( k , z ) => (
                            <tr key={z}>
                                <td>{z + 1}</td>
                                {
                                    key.map((d , i) =>(
                                        <td key={i}>
                                            { k[`${d}`]}
                                        </td>
                                    ))
                                }
                            </tr>
                        ))
                    }
                    </tbody>
                </Table>

            </div>
        )
    }

    return (
        <div className="container-main">

            <div className="mt-4">

                <div>

                    <DayPickerInput
                        locale="ko"
                        placeholder="Start Day"
                        format="YYYY-MM-DD"
                        formatDate={formatDate}
                        parseDate={parseDate}
                        value = {init.startDay}
                        onTodayButtonClick={(day, modifiers) => console.log(day, modifiers)}
                        onDayChange={day => setDay(dispatch, {type: 'F', day: day})}
                        todayButton="Go to Today"
                    ></DayPickerInput>
                    <DayPickerInput
                        onDayChange={day => setDay(dispatch, {type: 'T', day: day})}
                    ></DayPickerInput>
                </div>
                <RenderContent/>
            </div>
        </div>
    )
}
