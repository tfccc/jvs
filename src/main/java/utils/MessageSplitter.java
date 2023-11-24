package utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: TFC
 * @date: 2019-12-19 12:27
 * @note: 拆分请求报文
 **/
@SuppressWarnings("unused")
public class MessageSplitter {
    static String testMessage = "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3\n" +
            "Accept-Encoding: gzip, deflate, br\n" +
            "Accept-Language: zh-CN,zh;q=0.9\n" +
            "Cache-Control: max-age=0\n" +
            "Connection: keep-alive\n" +
            "Cookie: _uuid=08CEEB35-AB9A-0BB0-E408-59A621B716FD00328infoc; buvid3=4CB43551-1B5D-4522-82B5-640AFE2BC2D081654infoc; LIVE_BUVID=AUTO1515493723999456; sid=m4hd9phq; stardustvideo=1; CURRENT_FNVAL=16; fts=1554296306; rpdid=|(k||ku|Jl|m0J'ullY|m)m)J; CURRENT_QUALITY=80; LIVE_PLAYER_TYPE=2; UM_distinctid=16c707d244d740-03ab8b84c851db-e343166-144000-16c707d2452f3; _uuid=6DF9F187-6762-6F15-0E9A-8ED7B97DFAD446573infoc; laboratory=1-1; bp_t_offset_170623089=326454678850405352; DedeUserID=170623089; DedeUserID__ckMd5=9fbfb641eb83c4e7; SESSDATA=4588b691%2C1578568476%2Cef1784c1; bili_jct=6e2984efb643cd0cded64f892009d3e8\n" +
            "Host: www.bilibili.com\n" +
            "Sec-Fetch-Mode: navigate\n" +
            "Sec-Fetch-Site: none\n" +
            "Sec-Fetch-User: ?1\n" +
            "Upgrade-Insecure-Requests: 1\n" +
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36";

    /**
     * @Desc 返回一个map对象，包含请求内容(头部字段名+值)
     * @param reqMessage: request报文
     * @return linkedHashMap(拆分后的报文)
     */
    public static Map<String, String> split(String reqMessage) {
        Map<String, String> messageMap = new LinkedHashMap<>();
        String[] messages = reqMessage.split("\n");
        for (String singleLine : messages) {
            String[] head_data = singleLine.split(": ");
            messageMap.put(head_data[0], head_data[1]);
        }
        return messageMap;
    }

    /**
     * @Desc 遍历split返回的对象
     * @return void
     */
    public static void travel(Map<String, String> messageMap) {
        for (Map.Entry<String, String> entry : messageMap.entrySet()) {
            System.out.println(entry.getKey() + "||" + entry.getValue());
        }
    }

}
