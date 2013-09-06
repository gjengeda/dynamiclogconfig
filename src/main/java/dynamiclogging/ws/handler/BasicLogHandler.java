package dynamiclogging.ws.handler;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicLogHandler implements SOAPHandler<SOAPMessageContext>{

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicLogHandler.class);

    @Override
    public boolean handleMessage(SOAPMessageContext ctx) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ctx.getMessage().writeTo(byteArrayOutputStream);
        } catch (Exception e) {
            LOGGER.error("HandleMessage failed", e);
        }
        LOGGER.info(byteArrayOutputStream.toString());
        return true;
    }

    @Override
    public void close(MessageContext arg0) {
    }

    @Override
    public boolean handleFault(SOAPMessageContext arg0) {
        return false;
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

}
