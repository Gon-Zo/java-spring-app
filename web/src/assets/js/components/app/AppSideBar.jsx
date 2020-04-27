import React from "react";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import * as i from '@fortawesome/free-solid-svg-icons'

export default () => {
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
                            icon={m.icon}
                            title={m.title}
                        />
                    ))
                }
            </div>
        </div>
    );
}

let menuList = [
    {url: '/home', icon: i.faHome, title: "Home"},
    {url: '/dashboard', icon: i.faChartBar, title: "Dashboard"},
    {url: '/user', icon: i.faUsers, title: "users"},
    {url: '/product', icon: i.faShoppingCart, title: "product"},
    {url: '/category', icon: i.faClipboardList, title: "category"},
    {url: '/order', icon: i.faListAlt, title: "order"},
    {url: '/setting', icon: i.faCog, title: "setting"},
]

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
