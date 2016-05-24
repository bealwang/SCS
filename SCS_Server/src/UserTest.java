import service.SCSImpl;

public class UserTest{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SCSImpl user = new SCSImpl();
        System.out.println(user.forgotPassWord("18810374829"));
        // Student stu = user.signIn("1", "123");
        // System.out.println(stu.getUserName());
        // Message[] ms = user.getMyMessage("1");
        // for (int i = 0; i < ms.length; i++) {
        // System.out.println(ms[i].getMsId() + "  " + ms[i].getOwnerId()
        // + "  " + ms[i].getOwnerName() + "  " + ms[i].getMsTitle()
        // + "  " + ms[i].getMsBody() + "  " + ms[i].getMsTime());
        // }
        // user.publishMessage("3", "张云尧", "小丽你好");
        //
        // ms = user.getMyMessage("3");
        // for (int i = 0; i < ms.length; i++) {
        // System.out.println(ms[i].getMsId() + "  " + ms[i].getOwnerId()
        // + "  " + ms[i].getMsTitle() + "  " + ms[i].getMsBody());
        // }
    }
}