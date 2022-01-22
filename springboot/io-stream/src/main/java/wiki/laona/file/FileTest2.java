package wiki.laona.file;

import java.io.File;

/**
 * @author laona
 * @description 文件
 * @date 2022-01-22 14:44
 **/
public class FileTest2 {
    
    public static void main(String[] args) {
        FileTest2 test2 = new FileTest2();
        
        test2.listFile();
    }

    /**
     * 获取某文件夹下的所有文件
     */
    private void listFile(){
        String path = System.getProperty("user.dir");
        File file = new File(path, "/springboot/io-stream");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
