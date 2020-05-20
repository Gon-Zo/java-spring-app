import {$setList, $setOffset} from "../../modules/api/order";
import Table from "react-bootstrap/Table";
import React from "react";

export default (props) => {

    let data = props.data

    let theme = props.theme

    let _onScroll = props.scroll

    let key = props.key

    if (typeof data == 'undefined') {
        return null;
    }

    return(
        <div id="test1" className="tableFixHead mt-3" onScroll={() => _onScroll}>

            <Table id="rowHeight" striped bordered hover variant={theme ? "light" : "dark"}>
                <thead>
                <tr>
                    <th className="table-hd-bg">#</th>
                    {
                        key.map((k, i) => (
                            <th className="table-hd-bg" key={i}>{k}</th>
                        ))
                    }
                </tr>
                </thead>
                <tbody>
                {
                    data.map(( k , z ) => (
                        <tr key={z}>
                            <td>{z + 1}</td>
                            {
                                key.map((d , i) =>(
                                    <td key={i}>
                                        { k[`${d}`]}
                                    </td>
                                ))
                            }
                        </tr>
                    ))
                }
                </tbody>
            </Table>

        </div>
    )

}
