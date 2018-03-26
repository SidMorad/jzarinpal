### jZarinpal
is a java module for communicating with Zarinpal.com web service.

The idea is to use REST for simplifying some common scenarios. for example for receiving new authority code, you could use following code:
```java
JZarinpalClient client = JZarinpalClientImpl.newClient();
PaymentRequestDto paymentRequestDto = new PaymentRequestDto(1000, "Charge account");
try {
	String paymentToken = client.paymentRequest(paymentRequestDto);
	// Persist this paymentToken (to a database) for later use.
	return "redirect:" + UrlHelper.zarinpalStartPayUrl(paymentToken);
} catch (UnexpectedStatusCodeException e) {
	addError("sorry.we.are.not.able.to.connect.to.zarinpal.web.service.at.the.moment.error.code.is.xxxx", request, e.getStatusCode());
} catch (ProcessingException e) {
	addError("sorry.we.are.not.able.to.connect.to.zarinpal.web.service.at.the.moment.error.code.is.xxxx", request, 500);
}
```
and you receive authority code as result, and in case of failure you do have a HTTP status code for finding the cause.

and here is a callback handling scenario using spring-mvc framework:
```java
@RequestMapping("zarinpal/callback")
public String zarinpalCallbackGet(Model model,
        HttpServletRequest request, Principal principal,
        @RequestParam(value = "authority", required = true) String authority,
        @RequestParam(value = "status", required = true) String status) {
    // load payment with authroity code
    JZarinpalClient client = JZarinpalClientImpl.newClient();
    PaymentVerificationDto paymentVerificationDto = new PaymentVerificationDto(payment.amount(), authority);
    try {
        Long refId = client.paymentVerification(paymentVerificationDto);
        if (!refId.equals(new Long(0))) {	// refId '0' means no reference id.
            // Persist successful event (into a database) here.
            addMessage("amount.xxxx.added.into.your.account.balance.successfully", request, 1000);
        }
    } catch (UnexpectedStatusCodeException e) {
        ZarinStatus zarinStatus = ZarinStatus.fromHttpStatusCode(e.getStatusCode());
        addError(zarinStatus.message(), request);
    } catch (Exception e) {
        addError("sorry.something.went.wrong.please.try.again.now.or.later", request);
    }
}
```

### jzarinpal-server
is server-side module for providing REST end-points.

### jzarinpal-client
is a client-side module for using provided REST end-points.

Usually jzarinpal-server need to be installed in one of your servers, then jzarinpal-client can be use(as dependency) in any of your java applications.

Ideally (one day) creators of Zarinpal.com will provide this RESTful services for us! and we only need to import provided client library by them, e.g. zarinpal-java-sdk.

Note: https://github.com/SamaGostar/Zarinpal-Gateway-Documentation was the reference document. If this document is out-of-date or there is better one? please let us know, thank you.
