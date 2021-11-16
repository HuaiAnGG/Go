package wiki.laona.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wiki.laona.transaction.collect.Mission;
import wiki.laona.transaction.collect.Task;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author laona
 * @description
 * @create 2021-11-12 21:14
 **/
@SpringBootTest
public class CollectTest {

    @Test
    public void test(){
        List<Task> tasks = new ArrayList<>();
        List<Mission> missions = new ArrayList<>();

        tasks.add(new Task(1));
        tasks.add(new Task(3));
        tasks.add(new Task(5));
        tasks.add(new Task(6));
        tasks.add(new Task(7));
        tasks.add(new Task(9));

        missions.add(new Mission(2));
        missions.add(new Mission(4));
        missions.add(new Mission(5));
        missions.add(new Mission(6));
        missions.add(new Mission(8));
        missions.add(new Mission(10));

    }
}
