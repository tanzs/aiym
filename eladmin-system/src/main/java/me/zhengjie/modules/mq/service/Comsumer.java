//package me.zhengjie.modules.mq.service;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import javax.jms.*;
//import java.util.Date;
//
///**
// * @author tanzs
// * @date 2020/9/4
// * @desc 消费者，设置成组件形式，服务启动时，创建消费者监听队列
// */
//@Component
//public class Comsumer implements ApplicationRunner {
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        init();
//    }
//
//    public void init() throws JMSException {
//        //前期的初始化工作与生产者相同
//        ConnectionFactory factory = new ActiveMQConnectionFactory(
//                ActiveMQConnectionFactory.DEFAULT_USER,
//                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
//                "tcp://localhost:61616"
//        );
//
//        Connection conn = factory.createConnection();
//        conn.start();
//
//        Session session = conn.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
//        //与生产者的消息目的地相同
//        Destination dest = session.createQueue("queue");
//
//        MessageConsumer messConsumer = session.createConsumer(dest);
//        messConsumer.setMessageListener(new MessageListener() {
//
//            //方式1设置消息监听
//            @Override
//            public void onMessage(Message message) {
//                try {
//                    MapMessage m = (MapMessage)message;
//                    System.out.println("consumer接收到"+m.getString("reqDesc")+"的请求并开始处理，时间是"+new Date());
//                    System.out.println("这里会停顿5s，模拟系统处理请求，时间是"+new Date());
//                    Thread.sleep(5000);
//                    System.out.println("consumer接收到"+m.getString("reqDesc")+"的请求并处理完毕，时间是"+new Date());
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//        //方式2主动接收消息
////        while(true){
////            try {
////                MapMessage m = (MapMessage) messConsumer.receive();
////
////                Thread.sleep(1000);
////                System.out.println(m.getString("reqDesc"));
////            }catch (Exception e){
////                e.printStackTrace();
////            }
////
////        }
//
////        if(conn != null)conn.close();
//    }
//
//
//
//}
