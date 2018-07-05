package com.sa.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/*--------------------------------
 * 【已废弃】
功能:     快讯短信 PHP HTTP接口 发送短信
修改日期:   2014-04-12
说明:     http://api.106msg.com/TXTJK.aspx?type=send&ua=*****&pwd=*****&gwid=***&mobile=手机号1,手机号2,手机号3&msg=【签名】短信内容 
状态:

1   发送短信成功(其他请求代表成功)
-1  账号无效或未开户
-2  账号密码错误
-3  下发手机号为空
-4  下发短信内容为空
-5  指定短信企业ID为空
-6  账户或密码错误
-7  账户被冻结
-8  下发短信内容包含非法关键词
-9  账户没有充值或ing指定企业ID错误
-10 下发短信内容长度超出规定限制，限制为350字符
-11 下发账号余额不足
-20 服务器连接异常
-21 当前短信隶属106营销短信 必须加“尊称”、“退订回复T”
-99 系统未知错误


--------------------------------*/
public class SendSmsUtil {

    private static final String ua  = "jiuchachagf";
    private static final String pwd = "jiuchacha123";
    private static final String wid = "74";          // 发送营销短信

    /**
     * 发送验证码
     * @param telPhone
     * @param verifyCode
     * @return
     */
    //    public static Boolean sendVerifyCode(String telPhone, String verifyCode) {
    //        Boolean flag = false;
    //        String msg = "验证码: " + verifyCode + "。该验证码10分钟内有效。更多信息，请关注微信公众号jiuchachagf .";
    //        flag = sendMsg(telPhone, msg, 0);
    //        return flag;
    //    }

    /**
     * 发送好友通知
     * @param telPhone
     * @param friendName
     * @return
     */
    //    public static Boolean sendNotice(String telPhone, String friendName) {
    //        Boolean flag = false;
    //        System.out.println("发送通知短信的电话号码：" + telPhone);
    //        String msg = "您的好友:" + friendName
    //                     + ",正在邀请您使用酒查查APP，如接受请点击: http://www.jiuchacha.com/ad/app.html. 查价格 查真伪 查酒驾 .";
    //        flag = sendMsg(telPhone, msg, 1);
    //        return flag;
    //    }

    public static Boolean sendMsg(List<String> telPhones, String message) {
        Boolean flag = false;
        //发送内容
        String msg = "【酒查查】 " + message;

        // 创建StringBuffer对象用来操作字符串
        StringBuffer sb = new StringBuffer("http://api.106msg.com/TXTJK.aspx?");

        // 向StringBuffer追加用户名
        sb.append("type=send&ua=" + ua);

        // 向StringBuffer追加密码 
        sb.append("&pwd=" + pwd);

        // 向StringBuffer追加网关id
        sb.append("&gwid=" + wid);

        // 向StringBuffer追加手机号码
        String tels = "";
        for (int i = 0; i < telPhones.size(); i++) {
            tels += telPhones.get(i);
            if (i != telPhones.size() - 1) {
                tels += ",";
            }
        }
        System.out.println("tels:" + tels);
        sb.append("&mobile=" + tels);

        URL url;
        try {
            // 向StringBuffer追加消息内容转URL标准码
            sb.append("&msg=" + URLEncoder.encode(msg, "gb2312"));
            // 创建url对象
            url = new URL(sb.toString());
            // 打开url连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置url请求方式 ‘get’ 或者 ‘post’
            connection.setRequestMethod("POST");
            // 发送
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            // 返回发送结果
            String inputline = in.readLine();
            // 返回结果为‘100’ 发送成功
            System.out.println("短信发送结果：" + inputline);
            if (Integer.parseInt(inputline) > 0) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (MalformedURLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }

        return flag;
    }

    public static void main(String[] args) {
        List<String> tels = new ArrayList<String>();
        tels.add("18587008858");
        tels.add("18640010348");
        tels.add("18257381505");
        sendMsg(tels, "活动取消了，你们爱干嘛干嘛");

    }
}
