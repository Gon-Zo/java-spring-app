import React from "react";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import * as regular from '@fortawesome/free-regular-svg-icons'

export default () => {

    const user_test = ['0','0','0','0','0', '0','0','0','0','0']

    return (
        <div className="content-wrap mt-5">

            <div className="grid-item">
                <div className="content-card p-3">
                    <div className="content-title mt-2">
                        <span>유저 관리</span>
                        <button className="mr-2" onClick={() => {
                            alert("pop up")
                        }}>
                            <FontAwesomeIcon
                                className="icon"
                                icon={regular["faWindowMaximize"]}/>
                        </button>
                    </div>

                    {/*content-title*/}
                    <div className="content-body mt-4">

                        {
                            user_test.map((data , num)=>(
                                <div key={num} className="mt-3">
                                    <FontAwesomeIcon icon={regular['faUser']}/>
                                    <span className="ml-1">Tester 1</span>
                                    <span className="ml-2">2020-01-01</span>
                                    <span className="ml-2">Manager</span>
                                    <span className="ml-2">
                                        <input type={"checkbox"} defaultChecked={true} disabled={true}/>
                                    </span>
                                </div>
                            ))
                        }

                    </div>

                </div>
           </div>
           {/*grid-item 1*/}

           <div className="grid-item">
               <div className="content-card p-3">
                   <div className="content-title mt-2">
                       <span>물품 관리</span>
                       <button className="mr-2" onClick={() => {
                           alert("pop up")
                       }}>
                           <FontAwesomeIcon
                               className="icon"
                               icon={regular["faWindowMaximize"]}/>
                       </button>
                   </div>


               </div>
           </div>

           <div className="grid-item">3</div>
           <div className="grid-item">4</div>
           <div className="grid-item">5</div>
           <div className="grid-item">6</div>
           <div className="grid-item">7</div>
           <div className="grid-item">8</div>
       </div>
   )
}
