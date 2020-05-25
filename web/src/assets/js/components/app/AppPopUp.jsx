import {Button, Modal} from "react-bootstrap";
import React, {useState} from "react";

export default (props) =>{

    let isOpen =props.open

    let $handleClose = props.close

    let data = props.data

    let keys = props.keys

    let _onUpdate = props.update

    if(typeof data == 'undefined'){
        return null
    }

    let _checkedToType = (type) =>{
       switch (type) {
           case "date":
               return "date"
           case "boolean":
               return "checkbox"
           case "email":
               return "email"
           case "password":
               return "password"
           default:
               return "text"
       }
    }

    let _onChange = (name) =>{
        let element = document.getElementById(name);
        let val = element.value
        data[name] = val
    }

    return(
        <Modal
            show={isOpen}
            onHide={$handleClose}
            animation={true}
            size="lg">

            <Modal.Header closeButton className="surface-bg">
                <Modal.Title>Modal heading</Modal.Title>
            </Modal.Header>

            <Modal.Body>
                {
                    keys.map((m, i) => (
                        <div className="input-group" key={i}>
                            <div className="input-group-prepend">
                                <span className="input-group-text modal-input-box" id="">{m.name}</span>
                            </div>
                            <input
                                id={m.key}
                                type={_checkedToType(m.type)}
                                className="form-control"
                                defaultValue={data[m.key]}
                                defaultChecked={data[m.key]}
                                name={m.name}
                                onChange={() => _onChange(m.key)}
                            />
                        </div>
                    ))
                }

            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={$handleClose}>
                    Close
                </Button>
                <Button variant="primary" onClick={() => _onUpdate(data)}>
                    Save Changes
                </Button>
            </Modal.Footer>
        </Modal>
    )
}
