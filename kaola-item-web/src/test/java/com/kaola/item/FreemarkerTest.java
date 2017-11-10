package com.kaola.item;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:10:27 2017/11/10
 */
public class FreemarkerTest {



    @Test
    public void  testFreemarker() throws Exception{

        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDirectoryForTemplateLoading(new File("D:/iWorkSpace/KaoLa/kaola-item-web/src/main/webapp/WEB-INF/ftl"));
        configuration.setDefaultEncoding("utf-8");

         //Template template = configuration.getTemplate("hello.ftl");
        Template template = configuration.getTemplate("student.ftl");
        Map data = new HashMap<>();
        data.put("hello","hello freemarker");
        Student student = new Student(1,"小米",18,"杭州");
        data.put("student",student);
        List<Student>  studentList = new ArrayList<>();
        studentList.add(new Student(1,"小妹妹",16,"杭州"));
        studentList.add(new Student(1,"小萝莉",17,"杭州"));
        studentList.add(new Student(1,"小御姐",18,"杭州"));
        studentList.add(new Student(1,"小哈哈",16,"杭州"));
        studentList.add(new Student(1,"小乔",16,"杭州"));
        data.put("stuList",studentList);
        Writer out = new FileWriter(new File("D:/freemarker/student.html"));

        template.process(data,out);
        out.close();
    }
}
