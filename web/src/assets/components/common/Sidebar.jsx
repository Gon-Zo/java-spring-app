import React, {useEffect} from "react";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import * as solid from '@fortawesome/free-solid-svg-icons'
import * as regular from '@fortawesome/free-regular-svg-icons'
import {Link} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {_setMenus} from "../../modules/action/common";
import {getNowUrl} from "../../modules/constant/app-function";
import TEST from '../../img/test.jpg'

let menus = [
    {title: "홈", icon: "faHome:S", url: "/home", isOn: false},
    {title: "유저관리", icon: "faUser:R", url: "/user/management", isOn: false},
    {title: "상품관리", icon: "faCookieBite:S", url: "/product/management", isOn: false},
    {title: "커뮤니티관리", icon: "faComments:R", url: "/comment/management", isOn: false},
    {title: "설정", icon: "faCog:S", url: "/setting", isOn: false},
]

export default () => {

    const dispatch = useDispatch()

    const initCommon  = useSelector(state => state.Common , [])

    useEffect(() => {
        const url = getNowUrl()
        _setMenus(dispatch , {data : menus , url : url})
    }, [])

    return (
        <nav id="sidebar" className="p-5 ">
            <div className="sidebar-header">
                <h5>Doc App</h5>
            </div>

            <ul className="list-unstyled components mt-3">
                <MenuGroup
                    dispatch={dispatch}
                    payload={initCommon.menus}/>

                <UserItem
                    dispatch={dispatch}
                    payload={initCommon.menus}/>

            </ul>
        </nav>
    )
}

function UserItem(props) {

    const myInfo = "/my-info"

    const payload = props.payload

    const data = payload.data

    const dispatch = props.dispatch

    return (
        <li className="menu-items m-2 ">
            <Link id={myInfo} to={myInfo} onClick={()=>{
                const element = document.getElementById(myInfo)
                const href = element.getAttribute("href")
                const url = href.replace("/#" , "")
                _setMenus(dispatch , {data : data , url : url})
            }}>

                {/*<FontAwesomeIcon className="bell-icon" icon={regular['faBell']}/>*/}

                <div className={"img-box"}>
                    <img id={"imgIcon"}  src={TEST}/>
                </div>
                <div className="icon-text mt-3">
                    <span>테스터 1</span>
                </div>
            </Link>
        </li>
    )

}

function MenuGroup(props) {

    const payload = props.payload

    const dispatch = props.dispatch

    if (payload.length == 0) {
        return (<></>)
    }

    const data = payload.data

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
                        _setMenus(dispatch , {data : data , url : url})
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
        <li className="menu-items">
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
