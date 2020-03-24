package com.rzf.task.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

public class MapToBean {

    private static final ObjectMapper mapper = new ObjectMapper();

    //convert Map to JavaBean
    public static <T> T mapToBean(Map<String,Object> map,Class<T> cl) throws Exception{
        //create javabean instance
        T obj = cl.newInstance();
        //get javabean class
        BeanInfo beanInfo = Introspector.getBeanInfo(cl, Object.class);
        //get properties
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd:pds){
            Object value = map.get(pd.getName());
            Method setter = pd.getWriteMethod();
            if(value != ""){
                setter.invoke(obj, value);
            }
        }
        return  obj;
    }
}
