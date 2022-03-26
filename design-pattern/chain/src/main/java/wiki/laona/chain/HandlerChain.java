package wiki.laona.chain;

/**
 * @author laona
 * @description 处理链
 * @date 2022-03-26 10:42
 **/
public class HandlerChain {

    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler){
        handler.setSuccessor(null);

        if (head == null){
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle(){
        if (head != null) {
            head.handle();
        }
    }
}
