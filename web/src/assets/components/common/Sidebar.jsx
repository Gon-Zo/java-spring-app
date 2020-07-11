import React, {useEffect, useState} from "react";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import * as solid from '@fortawesome/free-solid-svg-icons'
import * as regular from '@fortawesome/free-regular-svg-icons'
import {Link} from "react-router-dom";
import {useDispatch} from "react-redux";
import {_setMenus} from "../../modules/action/common";

let menus = [
    {title: "유저", icon: "faUser:R", url: "/home", isOn: false},
    {title: "대쉬보드", icon: "faChartBar:R", url: "/Dashboard", isOn: false},
    {title: "설정", icon: "faCog:S", url: "/Setting", isOn: false},
]

export default () => {

    const dispatch = useDispatch()

    useEffect(() => {
        _setMenus(dispatch , menus)
    }, [])

    return (
        <nav id="sidebar" className="p-5 ">

            <div className="sidebar-header">
                <h5>Doc App</h5>
            </div>

            <ul className="list-unstyled components mt-5">

                <MenuGroup payload={menus}/>

            </ul>

        </nav>
    )
}

function MenuGroup(props) {

    const payload = props.payload

    const [data , setData] = useState(payload)

    if (payload.length == 0) {
        return (<></>)
    }

    return (
        data.map((m, i) =>
            (
                <MenuItems
                    key={i}
                    title={m.title}
                    icon={m.icon}
                    url={m.url}
                    isOn={m.isOn}
                    onClick={()=>{
                        const element = document.getElementById(m.url)
                        const href = element.getAttribute("href")
                        const url = href.replace("/#" , "")
                        console.log("URL" , url)
                        payload.forEach(f => {
                            f.isOn = url == m.url
                        })
                        setData(payload)
                    }}
                />
            )
        )
    )

}

function MenuItems(props) {

    const title = props.title

    const iconArray = props.icon.split(":")

    const url = props.url

    const isOn = props.isOn

    const icon = iconArray[1] == "R" ? regular : solid

    const iconTxt = iconArray[0]

    const onClick = props.onClick

    return (
        <li className="menu-items m-2 ">
            <Link id={url} to={url} onClick={onClick}>
                <div className={isOn ? "icon-box on" : "icon-box"}>
                    <FontAwesomeIcon className="icon" icon={icon[`${iconTxt}`]}/>
                </div>
                <div className="icon-text mt-3">
                    <span>{title}</span>
                </div>
            </Link>
        </li>
    )
}
