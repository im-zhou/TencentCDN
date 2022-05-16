package net.openfrp.tencentcdn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: 🥕 zhou
 * @Date: 2022/5/16 8:25
 */
@RestController
public class Controller {
    @Resource
    ConfigEntity config;

    //md5hash：MD5（文件路径-timestamp-rand-uid-自定义密钥）。
    //请求示例
    //http://cloud.tencent.com/test.jpg
    // ?sign=1582791032-im1acp76sx9sdqe601v-0-dd63f95e739ed4b47427a129d21ef4e3

    @RequestMapping("/**")
    public void ForWard(HttpServletRequest request, HttpServletResponse response)
            throws IOException, NoSuchAlgorithmException {
        String file = request.getRequestURI();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000L);
        String rand = Utils.getRandomString(16);
        String md5hash = file + "-" + timestamp + "-" + rand + "-0-" + config.getSignKey();
        String md5 = Utils.md5(md5hash);
        String url = config.getDomain() + file + "?" + config.getSignName() +
                "=" + timestamp + "-" + rand + "-0-" + md5;
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.sendRedirect(url);
    }
}
