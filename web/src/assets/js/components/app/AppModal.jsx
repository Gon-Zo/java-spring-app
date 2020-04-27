import React from "react";
import {$isOpen, createProduct} from "../../modules/api/product";
import {$isUserModalOpen} from "../../modules/api/user";
import {Button, Col, Form, Modal, Table} from "react-bootstrap";
import CKEditor from "@ckeditor/ckeditor5-react";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import {$updateUser, $fetchUsers} from "../../modules/api/user";

export {ProductEditor, UserInfoModal}

/**
 * Product Modal
 *
 * @param props
 * @returns {*}
 * @constructor
 */
function ProductEditor(props) {

    let dispatch = props.dispatch;
    let isOpen = props.isOpen;
    let init = props.data;
    let method = init.methodType;
    let data = init.product

    let keys = Object.keys(data);

    let $onClick = () => {
        if (method === 'I') {
            createProduct(dispatch, data)
        } else {
            updateProduct(dispatch, data)
        }
    };

    let inputType = (key) => {
        switch (key) {
            case "birthDate":
                return "date"
            case "is_use":
            case "is_sold":
                return "checkbox"
            case "count":
            case "price":
                return "number"
            default:
                return "text"
        }
    };

    let $onChange = (e) => {
        let name = e.target.name;
        let value = e.target.value;
        if (name === 'isUse') {
            value = e.target.checked
        }
        data[name] = value
    };

    return (
        <Modal
            size="lg"
            show={isOpen}
            onHide={() => $isOpen(dispatch)}
            aria-labelledby="example-modal-sizes-title-lg">
            <Modal.Header closeButton>
                <Modal.Title id="example-modal-sizes-title-lg">
                    상품 등록
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {
                    keys.filter((f) => f !== 'seq' && f !== 'createAt').map((k, i) => {
                        // let name = AppName.changeNameByProd(k);
                        let name = k;
                        return k === 'info' ? (
                            <div key={i}>
                                <span>{name}</span>
                                <CKEditor
                                    editor={ClassicEditor}
                                    data="<p>Hello from CKEditor 5!</p>"
                                    onInit={editor => {
                                        console.log('Editor is ready to use!', editor);
                                    }}
                                    onChange={(event, editor) => {
                                        let data = editor.getData();
                                        console.log({event, editor, data});
                                    }}
                                />
                            </div>
                        ) : (
                            <div className="input-group" key={i}>
                                <div className="input-group-prepend">
                                       <span className="input-group-text modal-input-box">
                                          {name}
                                         </span>
                                </div>
                                <input type={inputType(k)}
                                       className="form-control"
                                       defaultValue={data[k]}
                                       defaultChecked={data[k]}
                                       name={k}
                                       onChange={$onChange}/>
                            </div>
                        )
                    })
                }
            </Modal.Body>
            <Modal.Footer>
                <button onClick={$onClick} className="btn btn-default btn-dark">Save</button>
            </Modal.Footer>
        </Modal>
    )
}


/**
 * user modal
 * @param props
 * @returns {null|*}
 * @constructor
 */
function UserInfoModal(props) {


    let initData = props.initData;
    let isOpen = initData.isOpen;
    let dispatch = props.dispatch;
    let userData = initData.user;

    if (typeof userData === 'undefined' || userData == null) {
        return null
    }

    let keys = Object.keys(userData).filter(f => f !== 'create_at');

    let $handleClose = () => {
        $isUserModalOpen(dispatch)
    };

    let inputType = (key) => {
        if (key === 'birthDate') {
            return 'date'
        } else if (key === 'is_use') {
            return 'checkbox'
        } else {
            return 'text'
        }
    };

    let $onChange = (e) => {
        let name = e.target.name;
        let value = e.target.value;
        if (name === 'isUse') {
            value = e.target.checked
        }
        userData[name] = value
    };

    let $handleUpdate = () => {
        $updateUser(dispatch, initData);
        $fetchUsers(dispatch, initData);
        $handleClose();
    };

    return (
        <Modal
            show={isOpen}
            onHide={$handleClose}
            animation={false}>

            <Modal.Header closeButton className="surface-bg">
                <Modal.Title>Modal heading</Modal.Title>
            </Modal.Header>

            <Modal.Body>
                {
                    keys.filter((f) => f !== 'seq' && f !== 'createAt').map((m, i) => (
                        <div className="input-group" key={i}>
                            <div className="input-group-prepend">
                                <span className="input-group-text modal-input-box" id="">{m}</span>
                            </div>
                            <input type={inputType(m)} className="form-control" defaultValue={userData[m]}
                                   defaultChecked={userData[m]}
                                   name={m}
                                   onChange={$onChange}/>
                        </div>
                    ))
                }
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={$handleClose}>
                    Close
                </Button>
                <Button variant="primary" onClick={$handleUpdate}>
                  Save Changes
                </Button>
            </Modal.Footer>
        </Modal>
    )
}
