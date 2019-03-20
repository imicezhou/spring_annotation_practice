import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.pagehelper.PageHelper;
import com.neo.a_field.bean.business.Account;
import com.neo.a_field.config.BeansConfig;
import com.neo.a_field.config.DataSourceConfig;
import com.neo.a_field.config.RootConfig;
import com.neo.a_field.config.ServletConfig;
import com.neo.a_field.dao.AccountDao;

public class Test {

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext appContext =
				new AnnotationConfigApplicationContext(BeansConfig.class,DataSourceConfig.class);
		
		
		SqlSessionFactory sqlFact = appContext.getBean(SqlSessionFactory.class);
		PageHelper.startPage(2, 1);
		//拿到的动态代理类中的sqlsessionfactory的interceptor chain中并没有我们注册的拦截器
		AccountDao aDao = appContext.getBean(AccountDao.class);
		Map<String, Object> criteria = new HashMap<String, Object>();
		List<Account> list = aDao.queryAccountByCriteria(criteria);
		System.out.println(list.size());
	}
}
