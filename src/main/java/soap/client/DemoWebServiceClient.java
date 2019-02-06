package soap.client;

import soap.server.DemoWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class DemoWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");

        //см. wsdl - теги targetNamespace и name
        QName qname = new QName("http://server.soap/", "DemoWebServiceImplService");

        // Теперь мы можем дотянуться до тега service в wsdl описании,
        Service service = Service.create(url, qname);
        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        //класс смотри в portType name=
        DemoWebService hello = service.getPort(DemoWebService.class);

        // Ура! Теперь можно вызывать удаленный метод
        System.out.println(hello.getHello("ClientName"));
    }
}
