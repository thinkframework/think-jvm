package org.think.jvm.rtad;

import org.think.jvm.rtad.heap.ClassObject;

import java.util.Stack;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class LocalVars {
    private int maxLocals;
    private java.util.Stack<Solt> solts;
    public LocalVars(){

    }

    public LocalVars(int maxLocals){
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
        solts.set(index,new Solt(value));
    }


    public Long getLong(Integer index){
        return (Long) solts.get(index).getValue();
    }

    public void setLong(Integer index,Long value){
        solts.set(index,new Solt(value));
    }

    public Float getFloat(Integer index){
        return (Float) solts.get(index).getValue();
    }

    public void setFloat(Integer index,Float value){
        solts.set(index,new Solt(value));
    }


    public Double getDouble(Integer index){
        return (Double) solts.get(index).getValue();
    }

    public void setDouble(Integer index,Double value){
        solts.set(index,new Solt(value));
    }


    public Object getRef(Integer index){
        Solt solt = solts.get(index);
        return solt == null ? null :solt.getValue();
    }


    public ClassObject getThis(){
        return (ClassObject) getRef(0);
    }

    public void setRef(Integer index,Object value){
        solts.set(index,new Solt(value));
    }


    public Solt getSolt(Integer index){
        return solts.get(index);
    }

    public void setSolt(Integer index,Solt value){
        solts.set(index,value);
    }

    public Stack<Solt> getSolts() {
        return solts;
    }

    public void setSolts(Stack<Solt> solts) {
        this.solts = solts;
    }
}
