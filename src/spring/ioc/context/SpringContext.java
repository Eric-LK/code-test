package spring.ioc.context;

import spring.ioc.annoation.IocResource;
import spring.ioc.annoation.IocService;
import spring.ioc.util.ClassUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class SpringContext {

    // 扫描的包路径
    private String path;
    // bean map
    ConcurrentHashMap<String,Object> initBean = null;

    // 构造方法
    public SpringContext(String path){
        this.path = path;
    }

    /**
     * 获取bean
     * @param beanId beanId
     * @return bean对象
     * @throws Exception 空包一场
     */
    public Object getBean(String beanId) throws Exception{
        List<Class> classes = findAnnoationServcie();
        if (classes == null || classes.isEmpty()){
            throw new Exception("not found anything bean is useding initial...");
        }
        initBean = initBean(classes);
        if (initBean.isEmpty()){
            throw new Exception("initial bean is empty or null");
        }
        Object object = initBean.get(beanId);
        // 初始化对象
        initAttribute(object);
        return object;
    }

    /**
     * 初始化依赖的属性
     * @param object 对象
     * @throws Exception 抛出异常
     */
    public void initAttribute(Object object) throws Exception{
        Class classInfo = object.getClass();
        Field[] fields =classInfo.getDeclaredFields();
        for(Field field:fields){
            boolean flag = field.isAnnotationPresent(IocResource.class);
            if (flag){
                IocResource iocResource = field.getAnnotation(IocResource.class);
                if (iocResource != null){
                    String beanId = field.getName();
                    Object attrObject = getBean(beanId);
                    if (attrObject != null){
                        field.setAccessible(true);
                        field.set(object,attrObject);
                    }
                }
            }
        }
    }

    /**
     * 初始化bean
     * @param classes 需要初始化类的class对象
     * @return bean map
     */
    private ConcurrentHashMap<String, Object> initBean(List<Class> classes) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        // 创建一个线程安全的hashMap，用来存储所谓的spring bean对象
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<String, Object>();
        // 定义一个变量来存储beanId
        String beanId="";
        for(Class clazz :classes){
            // 实例化class对象对应的类对象
            Object object = clazz.getDeclaredConstructor().newInstance();
            // 判断此class对象有没有IocService注解
            IocService annotation =(IocService)clazz.getDeclaredAnnotation(IocService.class);
            if (annotation!=null){
                //如果定义了name属性 以实现的name属性为主否则以默认的规则为主
                String value = annotation.name();
                if (!value.equals("")){
                    beanId = value;
                }
                else {
                    beanId = toLowerCaseFirstOne(clazz.getSimpleName());
                }
            }

            //存储值
            map.put(beanId,object);
        }
        return map;
    }

    /**
     * 查找包路径下面所有添加注解的类 @IocService
     * @return Class对象的数组
     * @throws Exception 空包。。。
     */
    public List<Class> findAnnoationServcie() throws Exception{
        if (path == null || path.equals("")){
            throw new Exception("scan package address is null or empty");
        }
        // 获取此路径下所有的类对象
        List<Class<?>> classes = ClassUtil.getClasses(path);
        if(classes.size() == 0){
            throw new Exception("not found service is added annoation for @IocService");
        }
        // 创建一个Class对象的数组
        List<Class> annoationClass = new ArrayList<>();
        for(Class a: classes){
            // 判断此class对象有没有IocService注解
            IocService iocService = (IocService)a.getDeclaredAnnotation(IocService.class);
            if (iocService != null){
                // 有注解，加入数组中
                annoationClass.add(a);
            }
        }
        return annoationClass;
    }

    /**
     * 首字母转换为小写
     * @param s 类名字符串
     * @return 首字母小写后的字符串
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))){
            return s;
        }
        else{
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}
