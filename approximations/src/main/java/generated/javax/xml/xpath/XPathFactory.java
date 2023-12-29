package generated.javax.xml.xpath;

import com.sun.org.apache.xpath.internal.jaxp.XPathFactoryImpl;
import org.jacodb.approximation.annotation.Approximate;

@Approximate(javax.xml.xpath.XPathFactory.class)
public class XPathFactory {
    public static javax.xml.xpath.XPathFactory newInstance() {
        return new XPathFactoryImpl();
    }

    public static javax.xml.xpath.XPathFactory newInstance(final String uri) {
        return newInstance();
    }

    public static javax.xml.xpath.XPathFactory newInstance(String uri, String factoryClassName, ClassLoader classLoader) {
        return newInstance();
    }
}
