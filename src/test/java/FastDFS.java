import net.coobird.thumbnailator.Thumbnails;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class FastDFS {

    private StorageClient storageClient=null;

    private NameValuePair[] nvp = null;

    @Before
    public void b() throws Exception{
        ClientGlobal.init("D:/install/ideaworkspase/develop/imagetest/src/main/resource/fdfs_client.conf");
        InputStream inputStream = new FileInputStream("D:/install/ideaworkspase/develop/imagetest/src/main/webapp/image/er/yuantu2.png");
        byte[] buff = new byte[inputStream.available()];
        inputStream.read(buff);
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        storageClient = new StorageClient(trackerServer,storageServer);
        nvp = new NameValuePair[]{
                new NameValuePair("age", "18"),
                new NameValuePair("sex", "male")
        };
    }

    @Test
    public void demo1() throws Exception {
        InputStream inputStream = new FileInputStream("D:/install/ideaworkspase/develop/imagetest/src/main/webapp/image/er/yuantu2.png");
        byte[] buff = new byte[inputStream.available()];
        inputStream.read(buff);
        String[] fileIds = storageClient.upload_file(buff, "png", nvp);
        System.out.println(fileIds.length);
        System.out.println("组名：" + fileIds[0]);
        System.out.println("路径: " + fileIds[1]);
    }

    @Test
    public  void demo2() throws Exception {
        String fileurl = "http://192.168.1.121/group1/M00/00/04/wKgBPFvRlQWASLmAABBcV1c1LMA501.png";
        byte[] group1s = storageClient.download_file("group1", "M00/00/04/wKgBPFvRlQWASLmAABBcV1c1LMA501.png");
        InputStream inputStream = new ByteArrayInputStream(group1s);
        Thumbnails.of(inputStream).size(100,100).toFile("D:/install/ideaworkspase/develop/imagetest/src/main/webapp/image/er/100_100.png");
    }
}
