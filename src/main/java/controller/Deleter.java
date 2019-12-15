package controller;

import java.io.File;

/**
 * @Author:Gao
 * @Date:2019-12-15 11:03
 */
public class Deleter {
    public Deleter() {
        File dir = new File("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output");
        DeleteAll(dir);
    }
    public void DeleteAll(File dir) {
        if(!dir.exists())
            return;
        if (dir.isFile()) {
            System.out.println(dir + " : " + dir.delete());
            return;
        } else {
            File[] files = dir.listFiles();
            for (File file : files) {
                DeleteAll(file);
            }
        }
        System.out.println(dir + " : " + dir.delete());
    }
}
