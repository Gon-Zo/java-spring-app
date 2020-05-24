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

            </div>
        </div>
    )
}
