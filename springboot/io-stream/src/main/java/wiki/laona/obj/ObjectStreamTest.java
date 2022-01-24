package wiki.laona.obj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laona
 * @description ObjectInputStream\ObjectOutputStream 对象输入输出流
 * @date 2022-01-22 17:04
 **/
public class ObjectStreamTest {

    public static void main(String[] args) {
        ObjectStreamTest test = new ObjectStreamTest();
        
        test.serializeStream();
        
        test.deserializeStream();
        
        test.serializeListStream();
        
        test.deserializeListStream();
    }

    /**
     * 反序列化数组
     */
    private void deserializeListStream() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("springboot/io-stream/src/main/resources/studentList"))) {
            List<Students> studentsList = (List<Students>) ois.readObject();
            System.out.println("反序列化 = " + studentsList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 序列化数组
     */
    private void serializeListStream() {
        List<Students> list = new ArrayList<>();
        list.add(new Students("123", "laona"));
        list.add(new Students("234", "Tomy"));
        list.add(new Students("345", "Sherry"));
        list.add(new Students("456", "tom"));
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("springboot/io-stream/src/main/resources/studentList"))) {
            System.out.println("序列化 = " + list);
            oos.writeObject(list);
            oos.flush();            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 反序列化 students 实体
     */
    private void deserializeStream() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("springboot/io-stream/src/main/resources/students"))) {
            Students students = (Students)ois.readObject();
            System.out.println("反序列化 = " + students);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * 序列化 Students 实体
     */
    private void serializeStream() {
        Students stu = new Students("123", "laona");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("springboot/io-stream/src/main/resources/students"))){
            System.out.println("序列化 = " + stu);
            oos.writeObject(stu);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
