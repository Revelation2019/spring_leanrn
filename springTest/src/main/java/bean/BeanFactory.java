package bean;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    //定义一个Properties对象
    private static Properties properties = null;
    //实例存储容器
    private static Map<String, Object> beans = null;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取Properties文件流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            //创建bean.properties文件中所有实例，并以键值对形式存放在Map数据结构中
            //实例化Map容器
            beans = new HashMap<String, Object>();
            //获取bean.properties文件key值
            Enumeration<Object> keys = properties.keys();
            //遍历keys，逐一获取实例对象，并存入到beans中
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 获取实例对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }


//    public static Object getBean(String beanName) {
//        Object bean = null;
//        String beanPath = properties.getProperty(beanName);
//        System.out.println(beanPath);
//        try {
//            //根据类路径创建一个实例，动态加载类文件（运行时加载）
//            bean = Class.forName(beanPath).newInstance();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }

}
