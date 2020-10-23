package org.think.jvm.rtad.heap;

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


    public Object getRef(Integer index){
        Solt object = solts.get(index);
        return object == null ? null : object.getValue();
    }

    public void setRef(Integer index,Object value){
        solts.add(index,new Solt(value));
    }
}
