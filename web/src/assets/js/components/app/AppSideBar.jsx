import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import * as icon from '@fortawesome/free-solid-svg-icons'
import axios from "axios";

export default () => {

    let [menuList , setMenuList] = useState([])

    useEffect(()=>{

        axios.get(`/menu`)
            .then(res => {
               setMenuList(res.data)
            })
            .catch(err=>console.log(err))


    } , [])


    return (
        <div className="sidebar-bg" id="sidebar-wrapper">
            <div className="app-wrap surface-bg">
                <a href="/#/home" className="title-ft">
                    Application Manager
                </a>
            </div>

            {/*app title*/}
            <div className="list-group list-group-flush">
                {
                    menuList.map((m, i) => (
                        <MenuItem
                            key={i}
                            url={m.url}
                            icon={icon[`${m.icon}`]}
                            title={m.title}
                        />
                    ))
                }
            </div>
        </div>
    );
}

function MenuItem(props) {

    let url = props.url
    let icon = props.icon
    let title = props.title

    return (
        <Link to={url} className="list-group-item list-group-item-action main-ft sidebar-bg">
            <FontAwesomeIcon icon={icon}/>
            <span className="ml-2">{title}</span>
        </Link>
    )

}
