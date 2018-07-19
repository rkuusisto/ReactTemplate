import React from 'react';
import ReactDOM from 'react-dom';
import ExampleDialog from './../Dialogs/ExampleDialog'
import 'bootstrap/dist/css/bootstrap.min.css';
import {Alert} from 'reactstrap';

class ExamplePage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            alertOpen: false,
            alertStyle: 'primary',
            alertText: ''
        };
        this.displaySuccess = this.displaySuccess.bind(this);
        this.displayFailture = this.displayFailture.bind(this);
        this.hideAlert = this.hideAlert.bind(this);
    }

    displaySuccess(data) {
        this.setState(
            {
                alertOpen: true,
                alertStyle: 'primary',
                alertText: data
            }
        );

    }

    displayFailture(data) {
        this.setState(
            {
                alertOpen: true,
                alertStyle: 'danger',
                alertText: data
            });
    }

    hideAlert() {
        this.setState({
            alertOpen: false,
            alertStyle: 'primary',
            alertText: ''
        });
    }


    render() {
        return (
            <div>
                <Alert color={this.state.alertStyle} isOpen={this.state.alertOpen} toggle={this.hideAlert}>
                    {this.state.alertText}
                </Alert>

                <ExampleDialog successCallBack={this.displaySuccess} failtureCallBack={this.displayFailture}/>
            </div>
        );
    }
};

export default ExamplePage;

const wrapper = document.getElementById("index");
wrapper ? ReactDOM.render(<ExamplePage/>, wrapper) : false;
