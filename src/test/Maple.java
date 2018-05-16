import com.alibaba.fastjson.JSON;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Maple<T>{
    private T model;
    private String desc;

    public T getModel( ) {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getDesc( ) {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void insert(T model){
        model.getClass().getDeclaredClasses();
    }

    public Maple(){}

    public <K, V, H> Maple(T model, K k, V v, H h) {
        this.model = model;
        this.desc = String.format("%s|||%s|||%s", JSON.toJSONString(k), JSON.toJSONString(v), JSON.toJSONString(h));
    }

    public static class Model extends Maple{
        Integer id;
    }

    public static class ModelA{
        Integer aId;
    }
    public static class ModelB{
        Integer bId;
    }
    public static class ModelC{
        Integer cId;
    }
        public static void main(String[] args) {
        Maple maple = new Maple(new Model(), new ModelA(), new ModelB(), new ModelC());
        String[] models = maple.getDesc().split("|||");
        Class clazz = maple.getClass();
        Type t = clazz.getGenericSuperclass();
        if(t instanceof ParameterizedType){
            System.out.println("test");
        }
        //Class<?> clazz = (Class<?>)((ParameterizedType) maple.getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
        //System.out.println(clazz);
    }
}