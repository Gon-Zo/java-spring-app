import React, {useState} from "react";
import Alert from "react-bootstrap/Alert";
import Button from "react-bootstrap/Button";


export function AlertDismissible(props) {

    let isShow = props.isShow

    const [show, setShow] = useState(isShow);

    let title = props.title;

    let content = props.content

    return (
        <>
            <Alert show={show} variant="success">
                <Alert.Heading>{title}</Alert.Heading>
                <p>
                    {content}
                </p>
                <hr/>
                <div className="d-flex justify-content-end">
                    <Button onClick={() => setShow(false)} variant="outline-success">
                        Close
                    </Button>
                </div>
            </Alert>
            {/*{!show && <Button onClick={() => setShow(true)}>Show Alert</Button>}*/}
        </>
    );
}
