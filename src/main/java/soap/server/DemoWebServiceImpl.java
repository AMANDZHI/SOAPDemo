package soap.server;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.server.DemoWebService")
public class DemoWebServiceImpl implements DemoWebService {
    public String getHello(String name) {
        return "Hello " + name;
    }
}
