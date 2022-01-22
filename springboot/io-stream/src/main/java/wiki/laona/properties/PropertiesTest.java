package wiki.laona.properties;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author laona
 * @description 获取配置文件
 * @create 2022-01-22 22:54
 **/
public class PropertiesTest {

    /**
     * 配置文件路径
     */
    private static final String RESOURCE_PATH = "springboot/io-stream/src/main/resources/props/prop";

    public static void main(String[] args) {
        loadPropertiesByFileReader();
        loadPropertiesByFileInputStream();
    }

    private static void loadPropertiesByFileInputStream() {
        final Properties properties = new Properties();
        try(FileInputStream fis = new FileInputStream(RESOURCE_PATH)){
            properties.load(fis);
            String username = ((String) properties.get("username"));
            String password = (String) properties.get("password");
            System.out.println("username = " + username + "\t password = " + password);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadPropertiesByFileReader() {
        final Properties properties = new Properties();
        try (FileReader reader = new FileReader(RESOURCE_PATH)){
            properties.load(reader);
            String username = ((String) properties.get("username"));
            String password = (String) properties.get("password");
            System.out.println("username = " + username + "\t password = " + password);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
