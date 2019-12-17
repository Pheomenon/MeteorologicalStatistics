package converter;

/**
 * @Author:Gao
 * @Date:2019-12-14 19:11
 */
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LineFormatter {
private static String path ="C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output\\result.csv"; //目标文件路径
    private static File file = new File(path); //创建目标文件
    public void replaceTab(String oldString, String newString){
        try {
            long start = System.currentTimeMillis(); //开始时间
            BufferedReader br = new BufferedReader(
                    new InputStreamReader (
                            new FileInputStream( file))); //创建对目标文件读取流
            File newFile = new File("src/newFile"); //创建临时文件
            if (!newFile.exists()){
                newFile.createNewFile(); //不存在则创建
            }
            //创建对临时文件输出流，并追加
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile,true)));
            String string = null; //存储对目标文件读取的内容
            int sum = 0; //替换次数
//            bw.write("Day,Temperature\n");
            while ((string = br.readLine()) != null){
                //判断读取的内容是否包含原字符串
                if (string.contains(oldString)){
                    //替换读取内容中的原字符串为新字符串
                    string = new String(string.replace(oldString,newString));
                    sum++;
                }
                bw.write(string);
                bw.newLine(); //添加换行
            }
            br.close(); //关闭流，对文件进行删除等操作需先关闭文件流操作
            bw.close();
            String filePath = file.getPath();
            file.delete(); //删除源文件
            newFile.renameTo(new File(filePath)); //将新文件更名为源文件
            long time = System.currentTimeMillis() - start; //整个操作所用时间;
            System.out.println(sum+"项:"+time+"ms");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void formatDate(){
        try {
            long start = System.currentTimeMillis(); //开始时间
            BufferedReader br = new BufferedReader(
                    new InputStreamReader (
                            new FileInputStream( file))); //创建对目标文件读取流
            File newFile = new File("src/newFile"); //创建临时文件
            if (!newFile.exists()){
                newFile.createNewFile(); //不存在则创建
            }
            //创建对临时文件输出流，并追加
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile,true)));
            String string = null; //存储对目标文件读取的内容
            int sum = 0; //替换次数
            bw.write("Day,Temperature X10\n");
            while ((string = br.readLine()) != null){
                string = string.substring(0,4)+"/"+string.substring(4,5)+"/"+string.substring(5);
                bw.write(string);
                bw.newLine(); //添加换行
            }
            br.close(); //关闭流，对文件进行删除等操作需先关闭文件流操作
            bw.close();
            String filePath = file.getPath();
            file.delete(); //删除源文件
            newFile.renameTo(new File(filePath)); //将新文件更名为源文件
            long time = System.currentTimeMillis() - start; //整个操作所用时间;
//            System.out.println(sum+"个"+oldString+"替换成"+newString+"耗费时间:"+time);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void startFormat(){
        formatDate();
        String oldString = "\t";
        String newString = ",";
        replaceTab(oldString,newString);
    }
}

