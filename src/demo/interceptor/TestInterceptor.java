package demo.interceptor;


import java.util.Collection;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class TestInterceptor extends AbstractPhaseInterceptor<Message> {
    public TestInterceptor() {
        super(Phase.RECEIVE);
    }

    public TestInterceptor(String phase) {
        super(phase);
    }

    public void handleMessage(Message arg0) throws Fault {
        System.out.println(arg0.toString());
    }
}
