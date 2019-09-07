package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.PersonMapper;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
		
		//通过普通方式调用
		
		/*
		//1.加载数据库配置文件conf.xml
		Reader reader = Resources.getResourceAsReader("conf.xml");
		
		//2.创建session工厂
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader,"development");
		
		//3.session工厂生产session;相当于connection
		SqlSession session=factory.openSession();
		
		
		//增加数据
		Person addPerson=new Person("增加的数据", 100);
		int count= session.insert("mybatis.personMapper.addPerson",addPerson);
		if(count!=0) {
			System.out.println("增加数据成功!");
		}else {
			System.out.println("增加数据失败");
		}
		session.commit();
		
		
		
		//查询一条数据
		Person queryPerson = session.selectOne("mybatis.personMapper.queryPerson",addPerson);
		if(queryPerson!=null) {
			System.out.print("查询一条数据成功!数据是:"+queryPerson);
		}
		else {
			System.out.println("查询数据失败");
		}
	
		
		
		
		//修改数据
		Person updatePerson=new Person("增加的数据",99);
		if(session.update("mybatis.personMapper.updatePersonByname",updatePerson)!=0) {
			System.out.println("修改数据成功!");
		}
		else {
			System.out.println("修改数据失败");
		}
		session.commit();
		
		
		//查询一条数据	
		Person queryPerson1 = session.selectOne("mybatis.personMapper.queryPerson",updatePerson);
		if(queryPerson!=null) {
			System.out.print("查询一条数据成功!数据是:"+queryPerson1);
		}
		else {
			System.out.println("查询数据失败");
		}
		
		
		
		//删除数据
		if(session.delete("mybatis.personMapper.DeletePersonByname","增加的数据")>0) {
			System.out.print("删除成功");
		}else {
			System.out.print("删除失败");
		}
		session.commit();
		
		//关闭谅解
		session.close();
		*/
		
		
		//通过接口调用
		
		//1.加载数据库配置文件conf.xml
				Reader reader = Resources.getResourceAsReader("conf.xml");
				
				//2.创建session工厂
				SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader,"development");
				
				//3.session工厂生产session;相当于connection
				SqlSession session=factory.openSession();
				
				
				
				//变化一,反射获取配置文件
				PersonMapper personMapper=session.getMapper(PersonMapper.class);
				
				
				
				//增加数据
				Person addPerson=new Person("增加的数据", 100);
				
				
				
				//变化2,通过接口调用方法
				int count= personMapper.addPerson(addPerson);
				
				
				
				if(count!=0) {
					System.out.println("增加数据成功!");
				}else {
					System.out.println("增加数据失败");
				}
				session.commit();
				
				
				
				//查询一条数据
				Person queryPerson = personMapper.queryPerson(addPerson);
		
				if(queryPerson!=null) {
					System.out.print("查询一条数据成功!数据是:"+queryPerson);
				}
				else {
					System.out.println("查询数据失败");
				}
			
				
				
				
				//修改数据
				Person updatePerson=new Person("增加的数据",99);
				if(personMapper.updatePersonByname(updatePerson)!=0) {
					System.out.println("修改数据成功!");
				}
				else {
					System.out.println("修改数据失败");
				}
				session.commit();
				
				
				//查询一条数据	
				Person queryPerson1 = personMapper.queryPerson(updatePerson);
				if(queryPerson!=null) {
					System.out.print("查询一条数据成功!数据是:"+queryPerson1);
				}
				else {
					System.out.println("查询数据失败");
				}
				
				
				
				//删除数据
				if(personMapper.DeletePersonByname("增加的数据")>0) {
					System.out.print("删除成功");
				}else {
					System.out.print("删除失败");
				}
				session.commit();
				
				//关闭谅解
				session.close();
		
	}
}
