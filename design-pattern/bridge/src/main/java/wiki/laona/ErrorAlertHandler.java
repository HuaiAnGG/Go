package wiki.laona;

/**
 * @author laona
 * @description
 * @date 2022-01-18 10:56
 **/
public class ErrorAlertHandler extends AlertHandler{

    private Notification notification;
    private AlertRule rule;
    
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
        this.rule = rule;
        this.notification = notification;
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi())) {
            notification.notify(NotificationEmergencyLevel.SERVER, "...");
        }
    }
}
