package io.github.thinkframework.jvm.rtad.heap;

import java.util.Stack;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Solts {
    int maxLocals;
    Stack<Solt> solts;
    public Solts(){

    }

    public Solts(int maxLocals){
        this.maxLocals = maxLocals;
        if(maxLocals > 0){
            solts = new Stack<Solt>();
            solts.setSize(maxLocals);
        }
    }

    public Integer getInt(Integer index){
        return (Integer) solts.get(index).getValue();
    }

    public void setInt(Integer index,Integer value){
        solts.add(index,new Solt(value));
    }

    public Long getLong(Integer index){
        return (Long) solts.get(index).getValue();
    }

    public void setLong(Integer index,Long value){
        solts.add(index,new Solt(value));
    }

    public Float getFloat(Integer index){
        return (Float) solts.get(index).getValue();
    }

    public void setFloat(Integer index,Float value){
        solts.add(index,new Solt(value));
    }


    public Double getDouble(Integer index){
        return (Double) solts.get(index).getValue();
    }

    public void setDouble(Integer index,Double value){
        solts.add(index,new Solt(value));
    }


    public Integer[] getInts(Integer index){
        return (Integer[]) solts.get(index).getValue();
    }

    public void setInts(Integer index,Integer value){
        solts.add(index,new Solt(value));
    }

    public Long[] getLongs(Integer index){
        return (Long[]) solts.get(index).getValue();
    }

    public void setLongs(Integer index,Long value){
        solts.add(index,new Solt(value));
    }

    public Float[] getFloats(Integer index){
        return (Float[]) solts.get(index).getValue();
    }

    public void setFloats(Integer index,Float value){
        solts.add(index,new Solt(value));
    }


    public Double[] getDoubles(Integer index){
        return (Double[]) solts.get(index).getValue();
    }

    public void setDoubles(Integer index,Double value){
        solts.add(index,new Solt(value));
    }


    public Integer getLength(Integer index){
        return ((Object[]) solts.get(index).getValue()).length;
    }

    public Object getRef(Integer index){
        Solt object = solts.get(index);
        return object == null ? null : object.getValue();
    }

    public void setRef(Integer index,Object value){
        solts.add(index,new Solt(value));
    }

//    @Override
//    public String toString() {
//        return "Solts{" +
//                "solts=" + solts +
//                '}';
//    }
}
