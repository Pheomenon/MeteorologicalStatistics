import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

/**
 * @Author:Gao
 * @Date:2019-12-14 11:18
 */
public class HDFSClient {
    private FileSystem fileSystem;
    @Before
    public void before() throws IOException, InterruptedException {
        fileSystem = FileSystem.get(URI.create("hdfs://192.168.56.100:9000"),new Configuration(),"Melanism");
    }
    @Test
    public void put() throws IOException {
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://192.168.56.100:9000"), new Configuration());
        fileSystem.copyFromLocalFile(new Path("c:\\test.txt"),new Path("/"));
        fileSystem.close();
    }
    @Test
    public void get() throws IOException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://192.168.56.100:9000"),configuration,"Melanism");
        fileSystem.copyToLocalFile(new Path("/test.txt"),new Path("d:\\"));
        //下载HDFS中的test.txt到D盘根目录
        fileSystem.close();
    }
    @Test
    public void rename() throws IOException, InterruptedException {
        //获取文件系统
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://192.168.56.100:9000"), new Configuration(), "Melanism");
        //操作
        fileSystem.rename(new Path("/test.txt"), new Path("/test2.txt"));
        fileSystem.close();
    }
    @Test
    public void delete() throws IOException{
        boolean delete = fileSystem.delete(new Path("/test2.txt"),true);
        if(delete){
            System.out.println("Delete Success!");
        }
        else System.out.println("Delete fail!");
    }
    @Test
    public void ls() throws IOException {
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/"));
        for(FileStatus fileStatus :fileStatuses){
            if(fileStatus.isFile()){
                System.out.println("以下信息是一个文件信息");
                System.out.println(fileStatus.getPath());
                System.out.println(fileStatus.getLen());
            }
            else{
                System.out.println("这是一个文件夹");
                System.out.println(fileStatus.getPath());
            }
        }

    }
    @Test
    public void listFiles() throws IOException {
        RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/"),true);
        while (files.hasNext()){
            LocatedFileStatus file = files.next();

            System.out.println("++++++++++++++++");
            System.out.println(file.getPath());

            System.out.println("块信息：");
            BlockLocation[] blockLocations = file.getBlockLocations();
            for(BlockLocation blockLocation : blockLocations){
                String[] hosts = blockLocation.getHosts();
                System.out.println("块在：");
                for(String host : hosts){
                    System.out.println(host + " ");
                }
            }
        }
    }
    @After
    public void after() throws IOException {
        fileSystem.close();
    }
}
