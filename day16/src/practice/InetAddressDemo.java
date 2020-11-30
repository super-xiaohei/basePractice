package practice;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    @Test
    public static void main(String[] args) throws UnknownHostException {
        //static InetAddress getByNmae(String host)
        //InetAddress address = InetAddress.getByName("itheima");
        InetAddress address1 = InetAddress.getByName("192.168.101.58");//ip地址是唯一的
        System.out.println(address1);
        String hostAddress = address1.getHostAddress();//返回ip地址
        System.out.println(hostAddress);
        String hostName = address1.getHostName();
        System.out.println(hostName);
    }
}
