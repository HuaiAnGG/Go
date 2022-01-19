package wiki.laona.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author laona
 * @description 文件拷贝
 * @create 2022-01-19 23:22
 **/
public class FileOptionTest {

    private static final String INPUT_PATH = "springboot/io-stream/src/main/resources/tree.jpg";
    private static final String OUTPUT_PATH = "springboot/io-stream/src/main/resources/tree2.jpg";

    public static void main(String[] args) {
        FileOptionTest test = new FileOptionTest();

        test.copyFile();
    }

    /**
     * 复制文件到 <code>OUTPUT_PATH<code/> 路径
     */
    private void copyFile() {
        try(FileInputStream fis = new FileInputStream(INPUT_PATH); FileOutputStream fos = new FileOutputStream(OUTPUT_PATH)){
            int len = 0;
            byte[] buff = new byte[1024 * 1024];
            while ((len = fis.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
            fos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
