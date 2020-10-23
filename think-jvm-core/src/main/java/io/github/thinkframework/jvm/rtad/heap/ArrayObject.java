package io.github.thinkframework.jvm.rtad.heap;

import java.util.Arrays;

/**
 * @author lixiaobin
 * @since 2017/3/29
 */
public class ArrayObject extends ClassObject{
    Object[] objects;

    public ArrayObject(int count){
        objects = new Object[count];
    }
    public ArrayObject(Object[] objects){
        this.objects = objects;
    }

    public int length(){
        return objects.length;
    }

    public Integer getInt(Integer index){
        return (Integer) objects[index];
    }

    public void setInt(Integer index,Integer value){
        objects[index] = value;
    }


    public Long getLong(Integer index){
        return (Long) objects[index];
    }

    public void setLong(Integer index,Long value){
        objects[index] = value;;
    }

    public Float getFloat(Integer index){
        return (Float) objects[index];
    }

    public void setFloat(Integer index,Float value){
        objects[index] = value;;
    }


    public Double getDouble(Integer index){
        return (Double) objects[index];
    }

    public void setDouble(Integer index,Double value){
        objects[index] = value;;
    }


    public Object getRef(Integer index){
        return objects[index];
    }

    public void setRef(Integer index,Object value){
        objects[index] = value;
    }


    public Character getChar(Integer index){
        return (Character) objects[index];
    }

    public void setChar(Integer index,Character value){
        objects[index] = value;;
    }


    public Byte getByte(Integer index){
        return (Byte) objects[index];
    }

    public void setByte(Integer index,Byte value){
        objects[index] = value;;
    }


    public Short getShort(Integer index){
        return (Short) objects[index];
    }

    public void setShort(Integer index,Short value){
        objects[index] = value;;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "ArrayObject{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}
