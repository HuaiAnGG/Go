package wiki.laona.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author laona
 * @description File 只是文件和路径的抽象表现形式
 * @date 2022-01-22 14:03
 **/
public class FileTest {
    
    public static void main(String[] args) throws IOException {
        File file = new File("springboot/io-stream/src/main/resources/file");
        if (!file.exists()) {
            boolean b = file.mkdir();
            System.out.println("b = " + b);
        }
        
        // create a new file
        File file1 = new File(file, "a");
        if (!file1.exists()) {
            boolean newFile = file1.createNewFile();
            System.out.println("newFile = " + newFile);
        }
        
        // 获取绝对路径
        File parentFile = file1.getParentFile();
        System.out.println("绝对路径 = " + parentFile.getAbsolutePath());

        // 获取文件最后修改时间
        long lastModified = file1.lastModified();
        Date lastModifiedDate = new Date(lastModified);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String lastModifiedDateStr = format.format(lastModifiedDate);
        System.out.println("lastModifiedDateStr = " + lastModifiedDateStr);
        
        // 获取文件大小
        long length = file1.length();
        System.out.println("文件大小 = " + length + "b");
    }
}
