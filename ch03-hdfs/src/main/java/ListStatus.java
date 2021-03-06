// cc ListStatus Shows the file statuses for a collection of paths in a Hadoop filesystem
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

import java.net.URI;

// vv ListStatus
public class ListStatus {

    public static void main(String[] args) throws Exception {
        String uri = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);

        Path[] paths = new Path[args.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = new Path(args[i]);
        }

        FileStatus[] status = fs.listStatus(paths);
        Path[] listedPaths = FileUtil.stat2Paths(status);
        for (Path p : listedPaths) {
            System.out.println(p);

            FileStatus[] status1 = fs.listStatus(p);
            Path[] listedPaths1 = FileUtil.stat2Paths(status1);
            for (Path p1 : listedPaths1) {
                System.out.println(p1);
            }
        }
    }
}
// ^^ ListStatus
