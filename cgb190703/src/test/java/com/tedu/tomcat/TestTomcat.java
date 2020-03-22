package com.tedu.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;

/**
 * @Auther wise wu
 * @Date 2020/3/22 11:13
 * @Description
 */

public class TestTomcat {
  @Test
    public void test() throws LifecycleException {
      //新建tomcatd对象
     Tomcat t=new Tomcat();
     //构建连接
     Connector  connector= new Connector("HTTP/1.1");
        //设定连接端口
     connector.setPort(8080);
        //注册连接到tomcat中
        t.getService().addConnector(connector);
            //注册serveerlet
      Context context=t.addContext("/", null);

        t.addServlet(context, "helloWorld", "com.tedu.HelloWorld");

          //映射serverlet
        context.addServletMappingDecoded("/hello","helloWorld");
         //启动
        t.start();
       t.getServer().await();//阻塞当前线程
           //相当于while(ture){}




    }

}
