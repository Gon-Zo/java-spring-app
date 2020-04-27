import React from "react";
import CalendarChart from "../components/chart/CalendarChart";
import BumpChart from "../components/chart/BumpChart";
import PieChart from "../components/chart/PieChart";
import RadarChart from "../components/chart/RadarChart";
import BubbleChart from "../components/chart/BubbleChart";
import HeatMapChart from "../components/chart/HeatMapChart";
import Button from "react-bootstrap/Button";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import * as i from "@fortawesome/free-solid-svg-icons";
import {AppTheme} from "../modules/static/support";
import Popover from "react-bootstrap/Popover";
import OverlayTrigger from "react-bootstrap/OverlayTrigger";
import DayPicker from "react-day-picker";

export default () => {

    let popover = (
        <Popover id="popover-basic">
            <DayPicker/>
            <DayPicker/>
        </Popover>
    );

    return (
        <div className="container-main">
            <div className="text-right pt-3">
                <OverlayTrigger trigger="click" placement="bottom-start" overlay={popover}>
                    <Button variant={AppTheme()}>
                        <FontAwesomeIcon icon={i.faCalendar}/>
                    </Button>
                </OverlayTrigger>
            </div>

            <div className="card-group">
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">TEST1</span>
                   </div>
                    <div className="card-body">
                        <RadarChart/>
                    </div>
                </div>
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">TEST1</span>
                    </div>
                    <div className="card-body">
                        <PieChart/>
                    </div>
                </div>
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">TEST1</span>
                    </div>
                    <div className="card-body">
                        <BubbleChart/>
                    </div>
                </div>
            </div>


            <div className="card-group">
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">TEST1</span>
                    </div>
                    <div className="card-body">
                        <BumpChart/>
                    </div>
                </div>
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">TEST1</span>
                    </div>
                    <div className="card-body">
                        <HeatMapChart/>
                    </div>
                </div>
            </div>

            <div className="card-group">
                <div className="card card-dash card-bg">
                    <div className="card-title ml-2 mt-1">
                        <span className="main-ft">TEST1</span>
                    </div>
                    <div className="card-body">
                        <CalendarChart/>
                    </div>
                </div>

            </div>

        </div>
    )
}
