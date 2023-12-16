package com.example.board;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class DataSourceTest {

    public void testConntection(){
        ApplicationContext ctx =
                new FileSystemXmlApplicationContext(
                        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
                );
        DataSource ds = (DataSource) ctx.getBean("dataSource");

        try{
            Connection con = ds.getConnection();
            System.out.println("DB 연결 성공 !");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("DB 연결 실패 !");
        }
    }

}
