package wiki.laona.chain;

/**
 * @author laona
 * @description 处理器
 * @date 2022-03-26 10:37
 **/
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public final void handle(){
        doHandle();
        if (successor != null) {
            successor.handle();
        }
    }

    protected abstract void doHandle();
}
