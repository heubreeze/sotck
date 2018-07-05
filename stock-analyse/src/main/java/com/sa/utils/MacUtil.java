package com.sa.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MacUtil {
    /**
     * @param args
     * @throws UnknownHostException 
     * @throws SocketException 
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //得到IP，输出PC-201309011313/122.206.73.83

        // System.out.println(ia);
        String re = getLocalMac();
        System.out.println(re);
    }

    public static String getLocalMac() {
        String macAddress = "";
        try {
            InetAddress ia = InetAddress.getLocalHost();
            // TODO Auto-generated method stub
            //获取网卡，获取地址
            byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
            // System.out.println("mac数组长度：" + mac.length);
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                //字节转换为整数
                int temp = mac[i] & 0xff;
                String str = Integer.toHexString(temp);
                // System.out.println("每8位:" + str);
                if (str.length() == 1) {
                    sb.append("0" + str);
                } else {
                    sb.append(str);
                }
            }
            macAddress = sb.toString().toLowerCase();
            //  System.out.println("本机MAC地址:" + sb.toString().toUpperCase());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return macAddress;
    }
}