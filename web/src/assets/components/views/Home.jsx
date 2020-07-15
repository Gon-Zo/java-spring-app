import React from "react";

export default () => {
    return (
        <div className="common-wrap home-content mt-5">
            <div className="grid-items m-2">

               <div className="grid-item">

                   <div className="grid-item-title">
                       <span>Today's Work</span>
                   </div>

                   <div className="grid-item-body">
                       <ul>
                           <li className="mt-3">
                               Today work1
                           </li>

                           <li className="mt-3 item-active on">
                               Today work2
                           </li>
                       </ul>
                   </div>

               </div>

            </div>
            <div className="grid-items m-2">
               <div className="grid-item">

               </div>
            </div>
            <div className="grid-items m-2">3</div>
            <div className="grid-items m-2">4</div>
            <div className="grid-items m-2">5</div>
            <div className="grid-items m-2">6</div>
            <div className="grid-items m-2">7</div>
            <div className="grid-items m-2">8</div>
        </div>
    )
}
