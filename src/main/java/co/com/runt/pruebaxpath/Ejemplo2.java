/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.runt.pruebaxpath;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Daniel
 */
public class Ejemplo2 {

    /**
     * corresponde al html de login de RTM Se va a ubicar el boton de Aceptar por el texto
     * mediante el atributo xml name
     * <button _ngcontent-gum-c1=\"\" class=\"btn btn-primary\" type=\"button\"><!----><!----><div _ngcontent-gum-c1=\"\">Aceptar</div></button>
     */
    private static String HTML = "<html lang=\"en\"><head>\n"
            + "  <meta charset=\"utf-8\"/>\n"
            + "  <title>Ingresortm</title>\n"
            + "  <base href=\"./\"/>  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n"
            + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/> \n"
            + "  <meta http-equiv=\"cache-control\" content=\"no-cache, must-revalidate, post-check=0, pre-check=0\"/>\n"
            + "  <meta http-equiv=\"expires\" content=\"0\"/>\n"
            + "  <meta http-equiv=\"pragma\" content=\"no-cache\"/>\n"
            + "  <link rel=\"icon\" type=\"image/x-icon\" href=\"favicon.ico\" />\n"
            + "<link rel=\"stylesheet\" href=\"styles.850db6e73c692acb91fb.css\" /><style></style><style>.negrita[_ngcontent-gum-c1]{font-weight:bolder}</style></head>\n"
            + "<body>\n"
            + "  <app-root _nghost-gum-c0=\"\" ng-version=\"7.2.16\"><div _ngcontent-gum-c0=\"\"><div _ngcontent-gum-c0=\"\" style=\"position: relative;\"><router-outlet _ngcontent-gum-c0=\"\"></router-outlet><app-login _nghost-gum-c1=\"\"><div _ngcontent-gum-c1=\"\" class=\"contenedor\"><!----><div _ngcontent-gum-c1=\"\" style=\"padding: 20px;\"><app-message _ngcontent-gum-c1=\"\" _nghost-gum-c2=\"\"><!----></app-message><h1 _ngcontent-gum-c1=\"\">Autenticacion</h1><div _ngcontent-gum-c1=\"\" class=\"card\"><div _ngcontent-gum-c1=\"\" class=\"card-header bg-primary\"><div _ngcontent-gum-c1=\"\" class=\"row\"><div _ngcontent-gum-c1=\"\" class=\"col negrita\"> Autenticacion </div></div></div><!----><div _ngcontent-gum-c1=\"\" class=\"card-body\"><form _ngcontent-gum-c1=\"\" novalidate=\"\" class=\"ng-untouched ng-pristine ng-valid\"><div _ngcontent-gum-c1=\"\" class=\"card\"><div _ngcontent-gum-c1=\"\" class=\"card-body\"><div _ngcontent-gum-c1=\"\" class=\"row\"><div _ngcontent-gum-c1=\"\" class=\"col-2 form-group\"><label _ngcontent-gum-c1=\"\">Usuario:</label></div><div _ngcontent-gum-c1=\"\" class=\"col-4\"><input _ngcontent-gum-c1=\"\" class=\"form-control obligatorio ng-untouched ng-pristine ng-valid\" name=\"usuario\"/></div><div _ngcontent-gum-c1=\"\" class=\"col-2 form-group\"><label _ngcontent-gum-c1=\"\">Contrasentilde;a:</label></div><div _ngcontent-gum-c1=\"\" class=\"col-4\"><input _ngcontent-gum-c1=\"\" class=\"form-control obligatorio ng-untouched ng-pristine ng-valid\" name=\"clave\" type=\"password\"/></div></div></div></div><div _ngcontent-gum-c1=\"\" class=\"row\"><div _ngcontent-gum-c1=\"\" class=\"col-12 text-right\"><div _ngcontent-gum-c1=\"\" class=\"btn-group\"><button _ngcontent-gum-c1=\"\" class=\"btn btn-primary\" type=\"button\"><!----><!----><div _ngcontent-gum-c1=\"\">Aceptar</div></button></div></div></div></form></div><!----></div></div><!----></div></app-login></div></div></app-root>\n"
            + "<script type=\"text/javascript\" src=\"runtime.80ab492fe3d778817936.js\"></script><script type=\"text/javascript\" src=\"polyfills.cfb8e3c63fe16e64a522.js\"></script><script type=\"text/javascript\" src=\"scripts.d137d5543bc53b345a19.js\"></script><script type=\"text/javascript\" src=\"main.b69adf73eb24f3a7d7d4.js\"></script>\n"
            + "\n"
            + "</body></html>";

    public static void main(String[] args) throws Exception {
        // La expresion xpath de busqueda
        String xPathExpression = "//button[.='Aceptar']";

        // Carga del documento xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document documento = builder.parse(new ByteArrayInputStream(HTML.getBytes()));

        // Preparación de xpath
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Consultas
        NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);

        //como se puede evidenciar se obtuvo el boton que se estaba buscando
        for (int i = 0; i < nodos.getLength(); i++) {
            System.out.println(nodos.item(i)+":"+nodos.item(i).getTextContent());
            NamedNodeMap atributos=nodos.item(i).getAttributes();
            for(int j=0; j<atributos.getLength();j++){
                System.out.println("\t"+atributos.item(j).getNodeName()+":"+atributos.item(j).getNodeValue());
            }
        }
        
    }
}
