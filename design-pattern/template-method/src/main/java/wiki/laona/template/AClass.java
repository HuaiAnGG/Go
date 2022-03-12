package wiki.laona.template;

/**
 * @author laona
 * @description a 类
 * @create 2022-03-12 16:28
 **/
public class AClass {

    public static void main(String[] args){
        BClass bClazz = new BClass();
        bClazz.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println(" Call back me. ");
            }
        });
    }
}
