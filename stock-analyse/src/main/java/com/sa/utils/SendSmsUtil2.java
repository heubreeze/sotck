package com.sa.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
*功能:    调用正润短信发送
*说明:    http://api.cnsms.cn/?ac=send&uid=账号&pwd=MD5位32密码&mobile=号码&content=内容
*状态:
*   100 发送成功
*   101 验证失败
*   102 短信不足
*   103 操作失败
*   104 非法字符
*   105 内容过多
*   106 号码过多
*   107 频率过快
*   108 号码内容空
*   109 账号冻结
*   110 禁止频繁单条发送
*   111 系统暂定发送
*   112 号码不正确
*   120 系统升级

 * @Author: xuguoyin                     
 * @Filename: SendSmsUtil2.java
 * @Version: 1.0
 * @Date 2015年8月14日 下午2:51:00
 * @Description 
 * All rights Reserved, Designed By xuguoyin
 * Comapy JiuChaCha JiaXin LTD .
 */
public class SendSmsUtil2 {
    private static final String uId      = "115712";                          // 验证码
    private static final String uId2     = "112679";                          // 通知
    private static final String passWord = "9b5181a8b18e925d6135a5d9d49f6127";

    public static Boolean sendVerifyCode(String telPhone, String verifyCode) {
        Boolean flag = false;
        String msg = "您的认证码为:" + verifyCode;
        flag = sendMsg(telPhone, msg, 0);
        return flag;
    }

    public static Boolean sendNotice(String telPhone, String friendName) {
        Boolean flag = false;
        String msg = "您的好友：" + friendName
                     + ",正在邀请您使用酒查查APP，如接受请点击：http://www.jiuchacha.com/ad/app.html. 查价格 查真伪 查酒驾。";
        flag = sendMsg(telPhone, msg, 1);
        return flag;
    }

    public static Boolean sendTongZhi(String telPhone, String msg) {
        Boolean flag = false;
        flag = sendMsg(telPhone, msg, 1);
        return flag;

    }

    public static Boolean sendMsg(String telPhone, String msg, int type) {
        Boolean flag = false;
        //发送内容
        String content = msg;

        // 创建StringBuffer对象用来操作字符串
        StringBuffer sb = new StringBuffer("http://api.cnsms.cn/?");

        // 向StringBuffer追加用户名
        if (type == 0) {
            sb.append("ac=send&uid=" + uId);
        }
        if (type == 1) {
            sb.append("ac=send&uid=" + uId2);
        }

        // 向StringBuffer追加密码（密码采用MD5 32位 小写）
        sb.append("&pwd=" + passWord);

        // 向StringBuffer追加手机号码
        sb.append("&mobile=" + telPhone);

        // 向StringBuffer追加消息内容转URL标准码
        sb.append("&content=" + URLEncoder.encode(content));

        // 追加编码
        sb.append("&encode=utf8");

        // 创建url对象
        URL url;
        try {
            url = new URL(sb.toString());
            //            System.out.println(url);
            // 打开url连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置url请求方式 ‘get’ 或者 ‘post’
            connection.setRequestMethod("POST");

            // 发送
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            // 返回发送结果
            String inputline = in.readLine();
            System.out.println("短信发送状态:" + inputline);
            if (inputline.equals("100")) {
                flag = true;
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return flag;

    }

    public static void main(String[] args) {
        List<String> tels = new ArrayList<String>();
        tels.add("18587008858");
        tels.add("18640010348");
        String ts = "";
        for (int i = 0; i < tels.size(); i++) {
            ts += tels.get(i);
            if (i != tels.size() - 1) {
                ts += ",";
            }
        }
        System.out.println(ts);
        boolean flag = sendTongZhi(ts, "123！");
        System.out.println(flag);
    }
}
