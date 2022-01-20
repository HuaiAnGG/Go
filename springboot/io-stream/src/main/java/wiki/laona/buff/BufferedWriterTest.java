package wiki.laona.buff;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author laona
 * @description 自带缓冲的字符输出流
 * @date 2022-01-20 07:59
 **/
public class BufferedWriterTest {

    private static final String WRITER_PATH = "springboot/io-stream/src/main/resources/writer";
    
    
    public static void main(String[] args) {
        BufferedWriterTest test = new BufferedWriterTest();
        
        
        test.bufferWriterTest();
    }

    /**
     * 自带缓冲的字节输出流
     */
    private void bufferWriterTest() {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WRITER_PATH)))) {
            String content = "我挥舞着键盘和鼠标，发誓要把世界写个明明白白";
            writer.write(content);
            
            writer.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
