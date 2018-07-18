import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import {  Button, Modal, ModalHeader, ModalBody, ModalFooter, Label, Input, Form,FormGroup, Col  } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import RestController from '../Controllers/RestController';


class ExampleDialog extends Component {


        constructor(props) {
        super(props);
        this.state = {
                modal: true,
                firstname: "",
                lastname: "",
        };
        this.closeMe = this.closeMe.bind(this);
        this.submitData = this.submitData.bind(this);
        this.handleChange = this.handleChange.bind(this);

    }

    /**
     * Submit data event
     * @param {Form data} event 
     */
    submitData(event) {
        let rest = new RestController();
        rest.submitData({firstName:this.state.firstname, lastName: this.state.lastname}).then(function(res) {
                this.handleResults(res);
        }.bind(this)).catch(function(error) {
                console.log(error);
                this.handleError(error.reason);
        }.bind(this));;
    
    }
    /**
     * Handle error
     * @param {*} results 
     */
    handleError(results) {
        if(this.props.successCallBack) {
                this.setState( 
                        {
                        modal: false
                        }
                );
                this.props.successCallBack(results.payload.message);
        }
    }


    /**
     * Handle results
     * @param {*} results 
     */
    handleResults(results) {
        if(this.props.successCallBack) {
                this.setState( 
                        {
                        modal: false
                        }
                );
                this.props.successCallBack(results.payload.message);
        }
    }

    /**
     * Close me event
     * @param {} event 
     */
    closeMe(event) {
                console.log("Closing dialog");
                this.setState( 
                        {
                        modal: false
                        }
                );
    }
    /**
     * Change event for input fields
     * @param {*} event 
     */
    handleChange(event) {
        this.setState({
          [event.target.id]: event.target.value
        });
    }
    /**
     * Render
     */
    render() {
        return (
        <div> 
                <Modal isOpen={this.state.modal}>
                        <ModalHeader>Hello React!</ModalHeader>
                        <ModalBody>
                                <div className="px-2">
                               
                                <Form>
                                <FormGroup row>
                                                <Label for="firstname">First name:</Label>
                                                <Col sm={9}>
                                                        <Input name="firstname" id="firstname" placeholder="firstname" onChange={this.handleChange} />
                                                </Col>
                                        </FormGroup>
                                        <FormGroup row>
                                                <Label for="password">Last name:</Label>
                                                <Col sm={9}>
                                                        <Input type="lastname" name="lastname" id="lastname" placeholder="lastname" onChange={this.handleChange}  />
                                                </Col>
                                        </FormGroup>                  
                                </Form>                                
                                </div>
                        </ModalBody>
                        <ModalFooter>
                          <Button color="primary"  onClick={this.submitData} >Submit</Button>
                          <Button color="secondary" onClick={this.closeMe} >Close Me</Button>
                        </ModalFooter>                        
                </Modal>
        </div>);

    }
}

export default ExampleDialog;