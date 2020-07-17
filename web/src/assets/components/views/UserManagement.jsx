import React from "react";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import * as regular from '@fortawesome/free-regular-svg-icons'

export default () => {

    return (

        <div id="userManagement" className="container-fluid">

            <div id="userRangBox" className="row">
                <span>User Rang</span>
                <div className="col">
                    <FontAwesomeIcon icon={regular["faComment"]}/>
                </div>
                <div className="col">
                    1
                </div>
                <div className="col">
                    1
                </div>
            </div>
        {/* header   */}

        </div>

   )
}
