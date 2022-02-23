package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~06~23 12:11
 */
public class AlipayConfig {
    //-----请在这里配置您的基本信息

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102400753172";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCZL4tnZKHTfjaAyRZZMdP9L3TSiMWR1L5Gm8JdyszpVwvn9SAyA2365H49fk9J3Ksmr2uyvoDTXB12k+GbYy6YWDHzJtM2XqIgoOLBMwJKUIBeP5sy4x7113wxv/oy/XOnXjsFU4PtUB9igvcNQymegps+pD8EtmEVQGJWSWe//zgXgTmw8ohceXcDT2c7WRf4t5v4OFGw/jgF47s5ECp4cw6Rr2iQV3SxBJMcq5rJ61oMGMbZbvEDt+qCI1Vj3+FoQHzOzCqnUiwVVlmwTuv9XtvXAOC169AG49OEBZURKmCjvvJHeCysKubvIWBd3sAu3Km/fdH5GyQKUHuLlhWrAgMBAAECggEAZyksoWGU1aAOxmYlhcXXtI8MBmiTXOU/ir+EgrN7kbzMSNa8atICc88C8Rip/tz76d6DEenXSf+j2+I1Mfb2PyRN5ykDXn8WghC3BFL8vN0/xbjiJL/tbrRCcCKQNVyYUWNVLf4TP3MQ37/A7o6HbbcZI3Nq+Rp1gOFOGDvxAcuno3hj8cq2vDrLijAjgrGLt7BLyj7rqYnpS0ZvAOakZY0z9WDL+S1ymsciCj7tncGf8cVLKfaNQDh5naLRL/+kE1LNj2zeVysDdMaCJlC1wps9IJK6yJ9qD1ZY3KZX+GR2ipz1LjO13IzM3PrfYzQXIiCMjhR6i9JQv955OSfr2QKBgQDxP5uMDNGkMcqvRLMOudJZQsIE9ZmFdrnWkQY4xGOMoWwbCKJqVblaYUSNcsrwFD5FmgcVhy2+APYOMrODBq6Mti1BpfObaG86BYxyqGwpErYz+XpqTr2b7CpSxUNw+BCTOdU7aFnk5zMQMNHQInNGmF5a/R7gb6UaPWEzV+ZavQKBgQCijXF6DSttcdyrHqlCVn4y2EBKTwBfVBlEdBhsKDot1Vjs2ZWwUANEwGsVFCz3RVI8aG7sMZgoSwCuAVOIxo7E0TfVCt33hNrAdT/NMOygnfvIV8B1X9SLA1RNbGFOR6zlDj8e0zvimPreu1ewB4VgpRs9Kb1Fg2CVzCxt3a7shwKBgHMWBP4qn1fU6Pvzqfe8bbxnPGdhQnuIx960EGPETDkqSIgc9l4Dxwh2nl1cBbPB9HL/p6F9ezTJAJiFV12KMnqt7akDodLhXy4ut3F7Jx3w7zqcKOnN5mYbo5UYxbN+o2mYjUBp53hrUtDGeVDxHkzvIxQE7FXk7L43ycbUh++BAoGAZ6/pjn0QEoPqyoyIUvRxE2W1vLCgAC7Y3z1exr7yPYI1cv9n6Ethil1i8NMpy6DAUCAdgTQxZqJREK1v53MgZpM+FfsUk2p/Tvx7chufFOUxUh4Heddi8DlzcN+NQi2eL43i3XrIXEZQ3/qIeJSTk449zcnuHYUr+uF+Baa+ickCgYEA2x7HImtNWSbzgiqRNd7eU42lepc7YacY3DqmElsMaFL2z4wlLRPkmlgRI2C2/vXsthmwGj+UYvLN3jn5HwacO6ktNudaB+gi3AZ43NQ/pgvuQla4YaWBcAFtQb6IfIqh7lFMdmULyVxe30aqYSbwoOvGOfE53QoGRfQbMs6v/Lw=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApdWYJbzgzvyy3tfojyLNHnHWk80bOgYDMp+9vA1Fnp5MbxErqmCb0OL92vPy1+z+Co6+/+axHKiPSWzt0BaSn2ME1EvZtrx8CqFvFe+q7/u7FPZpsT277aqtw1rAA7KQNi03dkHMbZjjo7jLppwvUarzFiwVMc0p2pRbygdP+V5W5lRxzor6mL/KQSRmSpScTH0ThnAJ88ztK1bL9P7XTvhCunVARyXniY51ImFeuCc6tQ6dhKe0T/6BiX4jng/8e/BFE2SyilPqKxVrhHrLdhTsk3MALZkI9mb3db/kXOiy3fzoghZ+ZrLp4U6bvjqahqWdwBMt02UWdrtFweJohwIDAQAB+t1g8WB6//XxdP+GdA3FeKN+ACyRfkAUaolOYwdm1Fyul6NjRoEnkOyWRY3xrLeiPg8Q5cB4IpjnrS5CUGs4yC9xhTyk2st6IaSxftzc+Suwb3+4SNSSG7zR1kNvz0xAm9soMgknm/nB2QPrSXCQFT0pDzhlByFeQF2UlUladduB+o87OqDTeIXqMtWs58NVvufupAlHLe7O59WhEyD+5MpVqdS8aGE912cGYSknWnLVlevx1JBBkDOldEl3v428a3Yp8d6B3vajlbIJGdx5efFmWnQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8000/shop/jsp/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8000/shop/jsp/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
