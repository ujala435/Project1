package in.practice.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import in.practice.resources.SpringConfigFile;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigFile.class);
        
       NamedParameterJdbcTemplate npJdbcTemplate= context.getBean(NamedParameterJdbcTemplate.class);
       
       Map<String, Object> map=new HashMap<String, Object>();
       map.put("key_rollNo", 104);
       map.put("key_name", "Axz");
       map.put("key_marks", 89.6f);
       String query="insert into student values(:key_rollNo, :key_name, :key_marks)";
       
       int count=npJdbcTemplate.update(query, map);
       if(count>0)
    	   System.out.println("Succeed");
       else
    	   System.out.println("Failed");
    }
}
