package wiki.laona.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author laona
 * @description
 * @date 2022-01-19 20:25
 **/
public class FileOutputStreamTest {

    private static final String PATH = "F:\\IdeaWorkspace\\Go\\springboot\\io-stream\\src\\main\\resources\\out";

    public static void main(String[] args) {
        FileOutputStreamTest test = new FileOutputStreamTest();
        test.fileOutputStreamTest();

        test.fileOutputStreamTest2();
    }

    /**
     * 写入文件(追加)
     * <p>
     * 在新建的时候 new FileOutputStream(new byte[], append),
     * 表示后续写入的文件内容会追加到文件中
     */
    private void fileOutputStreamTest2() {
        boolean append = true;
        try (FileOutputStream fos = new FileOutputStream(PATH, append)) {
            System.out.println(fos.getFD());
            String content = "Hello world!\n";
            fos.write(content.getBytes(StandardCharsets.UTF_8), 0, content.length());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件(覆盖)
     * <p>
     * write() 如果文件不存在的话，会新建该文件
     */
    public void fileOutputStreamTest() {
        try (FileOutputStream fos = new FileOutputStream(PATH)) {
            String content = "Hello world!";
            fos.write(content.getBytes(StandardCharsets.UTF_8), 0, content.length());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
