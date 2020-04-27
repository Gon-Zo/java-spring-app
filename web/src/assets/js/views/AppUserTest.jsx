import React from "react";
import {useSelector} from "react-redux";

export default ()=>{

    let initUser = useSelector(state => state.userReducer, []);

    if (typeof initUser.users == 'undefined') {
        return (
            <div>
            <span>
                Loading
            </span>
            </div>
        )
    }


    return(
       <div>
           <span>
               TEST
           </span>
       </div>
    )
}