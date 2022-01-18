package wiki.laona;

import java.util.List;

/**
 * @author laona
 * @description 通知类
 * @date 2022-01-18 10:50
 **/
public class Notification {
    private List<String> emailAddress;
    private List<String> telephone;
    private List<String> wechatIds;

    public Notification() {
    }
    
    public void notify(NotificationEmergencyLevel level, String message) {
        if (level.equals(NotificationEmergencyLevel.SERVER)){
            System.out.println("自动语音电话");
        }else if (level.equals(NotificationEmergencyLevel.URGENCY)){
            System.out.println("发微信");
        }else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            System.out.println("发邮件");
        }else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            System.out.println("发邮件");
        }
    }

    public void setEmailAddress(List<String> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTelephone(List<String> telephone) {
        this.telephone = telephone;
    }

    public void setWechatIds(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }
}
