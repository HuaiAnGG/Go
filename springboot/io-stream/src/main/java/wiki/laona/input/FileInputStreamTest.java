package wiki.laona.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author laona
 * @description
 * @date 2022-01-19 19:45
 **/
public class FileInputStreamTest {

    public static void main(String[] args) {
        FileInputStreamTest test = new FileInputStreamTest();
        test.printFileInputStream();

        test.printFileInputStream2();

        test.printFileInputStream3();
    }

    /**
     * skip() 用法
     */
    private void testFileInputStreamSkip() {

    }

    /**
     * available() 用法
     * 不适合大文件，byte数组不能太大
     */
    private void printFileInputStream3() {
        String path = "F:\\IdeaWorkspace\\Go\\springboot\\io-stream\\src\\main\\resources\\word";
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] buff = new byte[fis.available()];
            int read = fis.read(buff);
            System.out.println(new String(buff));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用 byte 数组接受文件读取参数
     */
    private void printFileInputStream2() {
        String path = "F:\\IdeaWorkspace\\Go\\springboot\\io-stream\\src\\main\\resources\\word";
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] buff = new byte[2];
            int len = 0;
            while ((len = fis.read(buff)) != -1) {
                System.out.println(new String(buff, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 逐个读取字符
     */
    private void printFileInputStream() {
        String path = "F:\\IdeaWorkspace\\Go\\springboot\\io-stream\\src\\main\\resources\\word";
        try (FileInputStream fis = new FileInputStream(path)) {
            int readData = 0;
            while ((readData = fis.read()) != -1) {
                System.out.println((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
