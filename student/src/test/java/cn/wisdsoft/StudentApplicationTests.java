package cn.wisdsoft;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class StudentApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void test(){
        Student student = new Student();
        student.setStudentId("132465").setStudentPassword("12255").setStudentName("张三");
        JSONObject jsonObject = new JSONObject();

    }

}
