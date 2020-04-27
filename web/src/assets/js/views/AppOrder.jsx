import React, {useState} from "react";
import Table from "react-bootstrap/Table";
import DayPickerInput from 'react-day-picker/DayPickerInput';
import {useDispatch, useSelector} from "react-redux";
import MomentLocaleUtils, {
    formatDate,
    parseDate,
} from 'react-day-picker/moment';
import {setDay} from "../modules/api/order";

export default () => {

    let testArray = Array.from(Array(10))

    let theme = useSelector(state => state.userReducer, []).isTheme;

    let order = useSelector(state => state.orderReducer, []);

    let dispatch = useDispatch()

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
                        value = {order.startDay}
                        onTodayButtonClick={(day, modifiers) => console.log(day, modifiers)}
                        onDayChange={day => setDay(dispatch, {type: 'F', day: day})}
                        todayButton="Go to Today"
                    ></DayPickerInput>
                    <DayPickerInput
                        onDayChange={day => setDay(dispatch, {type: 'T', day: day})}
                    ></DayPickerInput>

                    {/*<Button*/}
                    {/*    size="sm"*/}
                    {/*    variant={AppTheme()}*/}
                    {/*    onClick={() => setDay(dispatch, {type: 'F', day: null})}*/}
                    {/*>*/}
                    {/*    <FontAwesomeIcon icon={i.faRedo}/>*/}
                    {/*</Button>*/}

                </div>

                <div className="tableFixHead mt-3" >
                    <Table striped bordered hover variant={theme ? "light" : "dark"}>
                        <thead>
                        <tr>
                            <th className="table-hd-bg">#</th>
                            <th className="table-hd-bg">First Name</th>
                            <th className="table-hd-bg">Last Name</th>
                            <th className="table-hd-bg">Username</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            testArray.map((m, i) => (
                                <tr key={i}>
                                    <td>{i + 1}</td>
                                    <td>Mark{i + 1}</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                            ))
                        }
                        </tbody>
                    </Table>
                </div>
            </div>
        </div>
    )
}
