//package me.zhengjie.modules.mq.service;
//
//import org.apache.activemq.ActiveMQConnection;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.stereotype.Service;
//
//import javax.jms.*;
//
///**
// * @author tanzs
// * @date 2020/9/4
// * @desc  消息生产者
// */
//@Service
//public class Producer {
//
//    public void sendMessage(String msg){
//        try {
//            //创建连接工厂,三个参数分别是用户名、密码以及消息队列所在地址
//            ActiveMQConnectionFactory connFactory =new ActiveMQConnectionFactory(
//                    ActiveMQConnection.DEFAULT_USER,
//                    ActiveMQConnection.DEFAULT_PASSWORD,
//                    "tcp://localhost:61616");
//
//
//
//            //连接到JMS提供者
//            Connection conn=connFactory.createConnection();
//            conn.start();
//
//            //事务性会话，自动确认消息
//            Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
//            //消息的目的地，创建队列"queue"
//            Destination destination = session.createQueue("queue");
//            //消息生产者
//            MessageProducer producer = session.createProducer(destination);
//
////           //文本消息
////          TextMessage textMessage = session.createTextMessage("这是文本消息");
////          producer.send(textMessage);
//
//            //键值对消息
//            MapMessage mapMessage = session.createMapMessage();
//            //将消息内容放入到消息里
//            mapMessage.setString("reqDesc", msg);
//            //生产者传送消息
//            producer.send(mapMessage);
////
////            //流消息
////            StreamMessage streamMessage = session.createStreamMessage();
////            streamMessage.writeString("这是流消息");
////            producer.send(streamMessage);
////
////            //字节消息
////            String s = "BytesMessage字节消息";
////            BytesMessage bytesMessage = session.createBytesMessage();
////            bytesMessage.writeBytes(s.getBytes());
////            producer.send(bytesMessage);
////
////            //对象消息
////            User user = new User("obj_info", "对象消息"); //User对象必须实现Serializable接口
////            ObjectMessage objectMessage = session.createObjectMessage();
////            objectMessage.setObject(user);
////            producer.send(objectMessage);
//
//
//            session.commit(); //提交会话，该条消息会进入"queue"队列，生产者也完成了历史使命
//            producer.close();
//            session.close();
//            conn.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }
//
//    }
//
//}
//
//
//
