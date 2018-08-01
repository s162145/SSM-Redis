package pers.syl.ssm.designPattern.reflect;

public class ReflectServiceImpl {
    public void sayHello(String name){
        System.err.println("Hello "+name);
    }

    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;
        try{
            object = (ReflectServiceImpl)Class.forName("pers.syl.ssm.designPattern.reflect.ReflectServiceImpl").newInstance();
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            ex.printStackTrace();
        }

        return object;
    }
}
