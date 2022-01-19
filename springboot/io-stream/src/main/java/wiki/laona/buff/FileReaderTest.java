package wiki.laona.buff;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author laona
 * @description
 * @create 2022-01-19 23:10
 **/
public class FileReaderTest {

    private static final String IMG_INPUT_PATH = "springboot/io-stream/src/main/java/wiki/laona/buff/FileReaderTest.java";
    private static final String IMG_OUTPUT_PATH = "springboot/io-stream/src/main/resources/copy.java";
    private static final String TXT_INPUT_PATH = "springboot/io-stream/src/main/resources/content.txt";
    private static final String TXT_OUTPUT_PATH = "springboot/io-stream/src/main/resources/content2.txt";

    public static void main(String[] args) {
        FileReaderTest test = new FileReaderTest();

        test.fileReaderTest1();

        test.copyTxtFile();
    }

    /**
     * 拷贝文本文件到指定目录
     */
    private void copyTxtFile() {
        try (FileReader reader = new FileReader(TXT_INPUT_PATH); FileWriter writer = new FileWriter(TXT_OUTPUT_PATH)) {
            // 1 MB 字节数组，1 char = 2 byte
            char[] buff = new char[1024];
            int readCount = 0;
            while ((readCount = reader.read(buff)) != -1) {
                writer.write(buff, 0, readCount);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件字符输入输出流
     * <p>
     * 只能读取简单的文本文件，简单文本文件指的是可以使用 windows 记事本进行编辑的文件
     */
    private void fileReaderTest1() {
        try (FileReader reader = new FileReader(IMG_INPUT_PATH); FileWriter writer = new FileWriter(IMG_OUTPUT_PATH)) {
            // 1 MB 字节数组，1 char = 2 byte
            char[] buff = new char[1024 * 512];
            int readCount = 0;
            while ((readCount = reader.read(buff)) != -1) {
                writer.write(buff, 0, readCount);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
