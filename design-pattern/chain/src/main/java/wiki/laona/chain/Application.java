package wiki.laona.chain;

/**
 * @author laona
 * @description
 * @date 2022-03-26 10:45
 **/
public class Application {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
