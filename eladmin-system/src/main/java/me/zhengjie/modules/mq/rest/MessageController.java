//package me.zhengjie.modules.mq.rest;
//
//import me.zhengjie.modules.mq.service.Producer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Date;
//
///**
// * @author tanzs
// * @date 2020/9/4
// * @desc
// */
//@Controller
//@RequestMapping("/message")
//public class MessageController {
//
//    @Autowired
//    private Producer producer;
//
//    @RequestMapping(value = "/sendMessage",method = RequestMethod.GET)
//    @ResponseBody
//    public void send(String msg) {
//        try {
//            System.out.println(msg+"开始发出一次请求，时间是"+new Date());
//            producer.sendMessage(msg);
//            System.out.println(msg+"请求发送完成，时间是"+new Date());
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/test")
//    @ResponseBody
//    public String test(){
//        return "cccc";
//    }
//
//}
