package generated.javax.xml.stream;

import com.sun.xml.internal.stream.XMLInputFactoryImpl;
import org.jacodb.approximation.annotation.Approximate;

@Approximate(javax.xml.stream.XMLInputFactory.class)
public class XMLInputFactory {
    public static javax.xml.stream.XMLInputFactory newInstance() {
        return new XMLInputFactoryImpl();
    }

    public static javax.xml.stream.XMLInputFactory newFactory() {
        return new XMLInputFactoryImpl();
    }
}
