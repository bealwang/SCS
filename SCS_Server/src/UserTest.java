import service.SCSImpl;
import entity.Message;

public class UserTest{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SCSImpl user = new SCSImpl();
        Message[] ms = user.getMyMessage("3");
        for (int i = 0; i < ms.length; i++) {
            System.out.println(ms[i].getMsId() + "  " + ms[i].getOwnerId()
                    + "  " + ms[i].getMsTitle() + "  " + ms[i].getMsBody());
        }
        Message temp = new Message("3", "张云尧", "小丽你好");
        user.publishMessage(temp);
        
        ms = user.getMyMessage("3");
        for (int i = 0; i < ms.length; i++) {
            System.out.println(ms[i].getMsId() + "  " + ms[i].getOwnerId()
                    + "  " + ms[i].getMsTitle() + "  " + ms[i].getMsBody());
        }
    }
}