// cc URLCat Displays files from a Hadoop filesystem on standard output using a URLStreamHandler

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

// vv URLCat
public class URLCatWithEncoding {

    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws Exception {
        InputStream in = null;
        try {
            in = new URL(args[0]).openStream();
            
            URL url = new URL(args[0]);
            InputStreamReader isr = new InputStreamReader(url.openStream(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
// ^^ URLCat
