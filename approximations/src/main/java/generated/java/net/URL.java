package generated.java.net;

import org.jacodb.approximation.annotation.Approximate;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URLStreamHandler;

@Approximate(java.net.URL.class)
public class URL {
    private String protocol;

    private String host;

    private int port = -1;

    private String file;

    private transient String query;

    private String authority;

    private transient String path;

    private transient String userInfo;

    private String ref;

    private transient InetAddress hostAddress;

    public URL(String protocol, String host, int port, String file,
               URLStreamHandler handler) throws MalformedURLException {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.file = file;
    }

    public URL(java.net.URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
        protocol = spec;
        host = spec;
        file = spec;
        query = spec;
    }
}
