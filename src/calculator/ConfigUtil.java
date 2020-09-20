package calculator;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 获取配置文件的信息
 *
 * @author  liuBing
 * @Date 2019/12/9  19:14
 */
public class ConfigUtil {

    /**
     * 获取配置文件中的数值
     *
     * @Author liuBing
     * @Date  2019/12/9  19:14
     * @Param 配置的key
     * @Return 配置的value
     */
    public static String getProjectConfig(String key) {
        Properties pros = new Properties();
        String value = "";
        try {

            pros.load(new InputStreamReader(Calculator.class.getResourceAsStream("./config.yml"), "UTF-8"));
            value = pros.getProperty(key);
        } catch (Exception e) {
            return e.getMessage();
        }
        return value;
    }
}
