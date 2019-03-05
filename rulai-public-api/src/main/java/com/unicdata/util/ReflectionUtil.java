
package com.unicdata.util;

import org.apache.commons.lang.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


public class ReflectionUtil {

    /**     * 将数据库列名转换成需要显示的列名
     *
     * @param
     *
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IntrospectionException
     * @throws InstantiationException
     *
     */
    public static <T> Map<String, String> getValues(T ob,
                                                    Map<String, String> valueMap) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, IntrospectionException,
            InstantiationException {
        Class<?> clazz = ob.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (!field.getName().equals("TITLE_MAP")
                    && !field.getName().equals("vehiclekey")) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
                        clazz);
                Method getMethod = pd.getReadMethod();// 获得get方法
                Object o = getMethod.invoke(ob);// 执行get方法返回一个Object
                if (o.toString().equals("") || o.toString().equals(" ")) {
                    valueMap.put(field.getName(), "--");
                } else {
                    valueMap.put(field.getName(), o.toString());
                }
            }
        }
        return valueMap;
    }

    /**from 与 tovalue两个对象 给相同的属性赋值，适合此方法
     * @param from
     * @param tovalue
     * @return
     */
    public static <T> T setValues(T from, T tovalue) {
        Class<?> clazzFrom = from.getClass();
        Class<?> clazzTo = tovalue.getClass();
        Field[] toField = clazzTo.getDeclaredFields();

        for (Field field : toField) {
            try {
                setValue(from,tovalue,clazzFrom,clazzTo,field);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        return tovalue;
    }

    private static <T> void setValue(T from, T tovalue,Class<?> clazzFrom,Class<?> clazzTo,Field field ) throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
                clazzFrom);
        Method getMethod = pd.getReadMethod();// 获得get方法
        Object o = getMethod.invoke(from);// 执行get方法返回一个Object
        PropertyDescriptor pdTo = new PropertyDescriptor(field.getName(),
                clazzTo);
        Method setMethod = pdTo.getWriteMethod();
        setMethod.setAccessible(true);
        setMethod.invoke(tovalue, o);
    }

    /**
     * @Description: 给map传值，空值不存入map中
     * @param from
     * @param map
     * @return
     */
    public static <T> void setMapValues(T from, Map<String, String> map) {
        //获取父类对象信息
        Class<?> parentClazz = from.getClass().getSuperclass();
        buildMap(from, parentClazz, map);
        //获取当前对象信息
        Class<?> clazzFrom = from.getClass();
        buildMap(from, clazzFrom, map);
    }

    /**
     * 给map传值<br>
     *
     * @param from
     * @param clazz
     * @param map
     */
    public static <T> void buildMap(T from, Class<?> clazz, Map<String, String> map) {
        Field[] toField = clazz.getDeclaredFields();
        try {
            for (Field field : toField) {
                String fieldName = field.getName();
                PropertyDescriptor pd = new PropertyDescriptor(fieldName,
                        clazz);
                Method getMethod = pd.getReadMethod();// 获得get方法
                Object o = getMethod.invoke(from);// 执行get方法返回一个Object
                if (null != o) {
                    String value = o.toString();
                    if (StringUtils.isNotBlank(value)) {
                        map.put(fieldName, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
