package pers.syl.ssm.designPattern.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl2 {
    private String name;
    private String no;
    public ReflectServiceImpl2(String name,String no){
        this.name = name;
        this.no  = no;
    }
    public void sayHello(){
        System.err.println("hello "+name);
    }
    public ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 object = null;
        try{
            object = (ReflectServiceImpl2)Class.forName("pers.syl.ssm.designPattern.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三","111");
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException |
                NoSuchMethodException | SecurityException | IllegalArgumentException |
                InvocationTargetException ex){
            ex.printStackTrace();
        }
        return object;
    }
    public Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try{
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target,"张三");
        }catch(NoSuchMethodException | SecurityException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException ex){
            ex.printStackTrace();
        }
        return returnObj;
    }

    public Object reflect(){
        ReflectServiceImpl object = null;
        try{
            object = (ReflectServiceImpl)Class.forName("pers.syl.ssm.designPattern.reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object,"张三");
        }catch (NoSuchMethodException | SecurityException | ClassNotFoundException|
                IllegalArgumentException | IllegalAccessException | InvocationTargetException|
                InstantiationException ex){
            ex.printStackTrace();
        }
        return object;
    }
}
