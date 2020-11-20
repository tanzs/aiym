package me.zhengjie.modules.system.rest;

import me.zhengjie.modules.system.utils.wx.WXPublicUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tanzs
 * @date 2020/8/6
 * @desc 微信授权相关
 */

@Controller
@RequestMapping("wx")
public class WxController {

    @RequestMapping("checkWx")
    @ResponseBody
    public String checkWx(HttpServletRequest request) throws Exception{
        String msgSignature = request.getParameter("signature"); //微信加密签名
        String msgTimestamp = request.getParameter("timestamp"); //时间戳
        String msgNonce = request.getParameter("nonce");//随机数
        String echostr = request.getParameter("echostr");
        if (WXPublicUtils.verifyUrl(msgSignature, msgTimestamp, msgNonce)) {
            return echostr;
        }
        return null;
    }




}
