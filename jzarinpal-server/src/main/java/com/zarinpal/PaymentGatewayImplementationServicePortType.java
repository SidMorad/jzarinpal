
package com.zarinpal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 *
 */
@WebService(name = "PaymentGatewayImplementationServicePortType", targetNamespace = "http://zarinpal.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PaymentGatewayImplementationServicePortType {


    /**
     *
     * @param amount
     * @param authority
     * @param status
     * @param email
     * @param description
     * @param merchantID
     * @param callbackURL
     * @param mobile
     */
    @WebMethod(operationName = "PaymentRequest", action = "https://ir.zarinpal.com/pg/services/WebGate/service#PaymentRequest")
    @RequestWrapper(localName = "PaymentRequest", targetNamespace = "http://zarinpal.com/", className = "com.zarinpal.PaymentRequest")
    @ResponseWrapper(localName = "PaymentRequestResponse", targetNamespace = "http://zarinpal.com/", className = "com.zarinpal.PaymentRequestResponse")
    public void paymentRequest(
        @WebParam(name = "MerchantID", targetNamespace = "http://zarinpal.com/")
        String merchantID,
        @WebParam(name = "Amount", targetNamespace = "http://zarinpal.com/")
        int amount,
        @WebParam(name = "Description", targetNamespace = "http://zarinpal.com/")
        String description,
        @WebParam(name = "Email", targetNamespace = "http://zarinpal.com/")
        String email,
        @WebParam(name = "Mobile", targetNamespace = "http://zarinpal.com/")
        String mobile,
        @WebParam(name = "CallbackURL", targetNamespace = "http://zarinpal.com/")
        String callbackURL,
        @WebParam(name = "Status", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<Integer> status,
        @WebParam(name = "Authority", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<String> authority);

    /**
     *
     * @param amount
     * @param authority
     * @param status
     * @param email
     * @param description
     * @param merchantID
     * @param callbackURL
     * @param additionalData
     * @param mobile
     */
    @WebMethod(operationName = "PaymentRequestWithExtra", action = "https://ir.zarinpal.com/pg/services/WebGate/service#PaymentRequestWithExtra")
    @RequestWrapper(localName = "PaymentRequestWithExtra", targetNamespace = "http://zarinpal.com/", className = "com.zarinpal.PaymentRequestWithExtra")
    @ResponseWrapper(localName = "PaymentRequestWithExtraResponse", targetNamespace = "http://zarinpal.com/", className = "com.zarinpal.PaymentRequestWithExtraResponse")
    public void paymentRequestWithExtra(
        @WebParam(name = "MerchantID", targetNamespace = "http://zarinpal.com/")
        String merchantID,
        @WebParam(name = "Amount", targetNamespace = "http://zarinpal.com/")
        int amount,
        @WebParam(name = "Description", targetNamespace = "http://zarinpal.com/")
        String description,
        @WebParam(name = "AdditionalData", targetNamespace = "http://zarinpal.com/")
        String additionalData,
        @WebParam(name = "Email", targetNamespace = "http://zarinpal.com/")
        String email,
        @WebParam(name = "Mobile", targetNamespace = "http://zarinpal.com/")
        String mobile,
        @WebParam(name = "CallbackURL", targetNamespace = "http://zarinpal.com/")
        String callbackURL,
        @WebParam(name = "Status", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<Integer> status,
        @WebParam(name = "Authority", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<String> authority);

    /**
     *
     * @param amount
     * @param authority
     * @param refID
     * @param status
     * @param merchantID
     */
    @WebMethod(operationName = "PaymentVerification", action = "https://ir.zarinpal.com/pg/services/WebGate/service#PaymentVerification")
    @RequestWrapper(localName = "PaymentVerification", targetNamespace = "http://zarinpal.com/", className = "com.zarinpal.PaymentVerification")
    @ResponseWrapper(localName = "PaymentVerificationResponse", targetNamespace = "http://zarinpal.com/", className = "com.zarinpal.PaymentVerificationResponse")
    public void paymentVerification(
        @WebParam(name = "MerchantID", targetNamespace = "http://zarinpal.com/")
        String merchantID,
        @WebParam(name = "Authority", targetNamespace = "http://zarinpal.com/")
        String authority,
        @WebParam(name = "Amount", targetNamespace = "http://zarinpal.com/")
        int amount,
        @WebParam(name = "Status", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<Integer> status,
        @WebParam(name = "RefID", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<Long> refID);

    /**
     *
     * @param amount
     * @param authority
     * @param refID
     * @param status
     * @param merchantID
     * @param extraDetail
     */
    @WebMethod(operationName = "PaymentVerificationWithExtra", action = "https://ir.zarinpal.com/pg/services/WebGate/service#PaymentVerificationWithExtra")
    @RequestWrapper(localName = "PaymentVerificationWithExtra", targetNamespace = "http://zarinpal.com/", className = "com.zarinpal.PaymentVerificationWithExtra")
    @ResponseWrapper(localName = "PaymentVerificationWithExtraResponse", targetNamespace = "http://zarinpal.com/", className = "com.zarinpal.PaymentVerificationWithExtraResponse")
    public void paymentVerificationWithExtra(
        @WebParam(name = "MerchantID", targetNamespace = "http://zarinpal.com/")
        String merchantID,
        @WebParam(name = "Authority", targetNamespace = "http://zarinpal.com/")
        String authority,
        @WebParam(name = "Amount", targetNamespace = "http://zarinpal.com/")
        int amount,
        @WebParam(name = "Status", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<Integer> status,
        @WebParam(name = "RefID", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<Long> refID,
        @WebParam(name = "ExtraDetail", targetNamespace = "http://zarinpal.com/", mode = WebParam.Mode.OUT)
        Holder<String> extraDetail);

}
