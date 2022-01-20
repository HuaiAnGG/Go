package wiki.laona.buff;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author laona
 * @description 带缓冲流的字符输入流
 * @date 2022-01-20 07:53
 **/
public class BufferedReaderTest {

    private static final String READER_PATH = "springboot/io-stream/src/main/resources/reader";
    
    public static void main(String[] args) {
        BufferedReaderTest test = new BufferedReaderTest();
        
        test.readLineTest();
    }

    /**
     * BufferedReader 自带缓冲字符输入流
     */
    private void readLineTest() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(READER_PATH)));){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
