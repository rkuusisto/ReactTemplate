import React, { Component } from 'react';
import superagent from 'superagent';
/**
 * Provides functionalities to Call bunded Rest Service
 */
class RestController extends React.Component {

    //Example variable
    api;
    contentType;

    constructor(props) {
        super(props);
        this.state = {
        };

        this.api  = process.env.APIURL;
        this.contentType = 'application/json;charset=UTF-8';
    }

    /**
     * Submit data to Rest API
     * @param {} payload 
     */
    submitData(payload) {
    
        let url = '';
        if(process.env.NODE_ENV === 'development') {
            url =  this.api+'templateRest/api/operationx'
        }else {
            url =  '/templateRest/api/operationx'
        }

        return new Promise(function(resolve, reject) {
            superagent.post(
                url
            )
            .set("Content-Type",this.contentType)
            .send(JSON.stringify(payload)).then(function(res) {
                if(res.status==200) {
                    if((res.get("Content-Type") && this.contentType==res.get("Content-Type"))) {
                        //Content-Type + StatuCode as expected
                        resolve(res.body);
                    } else {
                        //Status Code OK, but content-type unknown
                        reject({errorCode:"ERROR_01",reason:"Invalid Content-Type", trackingId:"n/a"});
                    }
                }else {
                     //All error codes
                     if((res.get("Content-Type") && this.contentType==res.get("Content-Type"))) {
                       //Error code from server side
                       reject(res.body);   
                     } else {
                       reject({errorCode:"ERROR_02",reason:"Invalid Content-Type on response",trackingId:"n/a"});
                     }                  
                }

               ;
             }.bind(this)).catch(function(err) {
                    //On all errors
                    console.log(err);
                    reject({errorCode:"ERROR_03",reason:"Error while sending request",trackingId:"n/a"});
            });

        }.bind(this));
       
    }
}

export default RestController;