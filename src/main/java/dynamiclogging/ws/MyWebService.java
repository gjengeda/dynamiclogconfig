package dynamiclogging.ws;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService(name = "MyService", targetNamespace = MyWebService.NAMESPACE, serviceName = "MyService" )
@HandlerChain(file = "ws-handler-chain.xml")
public class MyWebService {

        public static final String NAMESPACE = "http://ws.dynamiclogging/";

        @WebMethod
        public @WebResult(name="echoed") String echo(@WebParam(name="toEcho") String toEcho) {
            return toEcho;
        }

}
