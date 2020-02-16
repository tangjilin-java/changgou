package ab.tjl.changgou.file.util;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.csource.common.NameValuePair;

import java.io.IOException;

/**
 * @Author:TangJiLin
 * @Description:文件上传客户端
 * @Date: Created in 2020/2/16 10:23
 * @Modified By:
 */
public class FastDFSUtil {

    /**
     * 加载Tracker连接信息
     */
    static {
        try {
            //查找classpath下的文件路径
            String filename = new ClassPathResource("fdfs_client.conf").getPath();
            //加载Tracker连接信息
            ClientGlobal.init(filename);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     * @param fastDFSFile
     * @return
     */
    public static String[] upload(FastDFSFile fastDFSFile) throws IOException, MyException {

        //获取文件的作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", fastDFSFile.getAuthor());


        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();

        //通过TrackerClient访问TrackerServer服务，获取连接信息
        TrackerServer trackerServer = trackerClient.getConnection();

        //通过TrackerServer的连接信息可以获取StorageClient对象储存Storage的连接信息
        StorageClient storageClient = new StorageClient(trackerServer, null);

        //通过StorageClient访问Storage，实现文件上传，并且获取文件上传后的储存信息
        String[] uploads = storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), meta_list);
        return uploads;
    }

    /***
     * 获取文件信息
     * @param groupName :组名
     * @param remoteFileName ：文件存储完整名
     * @return
     */
    public static FileInfo getFile(String groupName, String remoteFileName) throws IOException, MyException {
        //创建一个TrackerClient对象 通过TrackerClient对象访问TrackerServer
        TrackerClient trackerClient = new TrackerClient();

        //通过TrackerClient获取TrackerServer的连接信息
        TrackerServer trackerServer = trackerClient.getConnection();

        //通过TrackerServer获取Storage信息 创建StorageClient对象存储Storage信息
        StorageClient storageClient = new StorageClient(trackerServer, null);

        //获取文件信息
        FileInfo file_info = storageClient.get_file_info(groupName, remoteFileName);
        return file_info;
    }

    public static void main(String[] args) throws IOException, MyException {
        FileInfo fileInfo = getFile("group1", "/M00/00/00/wKjThF5Ist-AZ9YwAAYgMeOIWro005.jpg");
        System.out.println(fileInfo.getSourceIpAddr());
        System.out.println(fileInfo.getFileSize());
    }
}
