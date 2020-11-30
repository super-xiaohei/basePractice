package practice;

public class Demo {
    //模拟数据库中已存在账号
    private static String[] names = {"彭于晏","郑义桥","都是帅哥"};
    public static void main(String[] args){
        try{
            checkUsername("彭于晏");
            System.out.println("注册成功");//如果没有异常就是注册成功
        }catch (LoginException e){
            e.printStackTrace();
        }
    }

    private static boolean checkUsername(String uname) throws LoginException {
        for(String name : names){
            if(name.equals(uname)) {
                throw new LoginException("亲 "+ name +" 这个账号已经被注册了！");
            }
        }
        return true;
    }
    //判断当前注册账号石否存在
}
