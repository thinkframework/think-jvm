package org.think.jvm.rtad;

import org.think.jvm.exceptions.VMException;

import java.util.Stack;

/**
 * @see org.apache.bcel.generic.AALOAD
 * @author lixiaobin
 * @since 2017/3/24
 */
public class OperandStack {
    private int maxStack;
    private Stack<Solt> solts;
    public OperandStack(){

    }

    public OperandStack(int maxStack){
        this.maxStack = maxStack;
        if(maxStack > 0){
            solts = new Stack<Solt>();
        }
    }

    public void push(Object solt){
        if(solts.size() >= maxStack){
            throw new VMException("java.lang.StackOverlowError");
        }
//        solts.push();
    }

    public Object pop(){
        return solts.pop();
    }

    public void pushBoolean(Boolean value){
        solts.add(new Solt(value));
    }

    public Boolean popBoolean(){
        Object value = solts.pop().getValue();
        if(value instanceof Integer){
            return (int)value != 0;
        }
        return (Boolean) value;
    }

    public void pushByte(Byte value){
        solts.add(new Solt(value));
    }

    public Byte popByte(){
        return (Byte) solts.pop().getValue();
    }


    public void pushChar(Character value){
        solts.add(new Solt(value));
    }

    public Character popChar(){
        Object value = solts.pop().getValue();
        if(value instanceof Integer){
            return (char)(int)value;
        }
        return (Character)value;
    }


    public void pushShort(Short value){
        solts.add(new Solt(value));
    }

    public Short popShort(){
        return (Short) solts.pop().getValue();
    }


    public void pushInt(Integer value){
        solts.add(new Solt(value));
    }

    public Integer popInt(){
        Solt solt = solts.pop();
        return solt == null ? null : (Integer) solt.getValue();
    }

    public void pushLong(Long value){
        solts.add(new Solt(value));
        solts.add(new Solt(value,true));
    }

    public Long popLong(){
        solts.pop().getValue();
        return (Long) solts.pop().getValue();
    }

    public void pushFloat(Float value){
        solts.add(new Solt(value));
    }

    public Float popFloat(){
        return (Float) solts.pop().getValue();
    }

    public void pushDouble(Double value){
        solts.add(new Solt(value));
        solts.add(new Solt(value,true));
    }

    public Double popDouble(){
        solts.pop().getValue();
        return (Double) solts.pop().getValue();
    }


    public void pushSolt(Solt value){
        solts.add(value);
//        if (value.getValue() instanceof Long || value.getValue() instanceof Double){
//            solts.add(new Solt(value,true));
//        }
    }

    public Solt popSolt() {
        Solt value = solts.pop();
//        if(value.getW()){
//            value = solts.pop();
//        }
        return value;
    }


    public void pushRef(Object object){
        solts.add(new Solt(object));
    }

    public Object popRef(){
        return solts.pop().getValue();
    }


    public Object getRefFromTop(Integer index){
        return solts.get(solts.size()-1-index).getValue();
    }

    public void clear(){
        solts.clear();
    }

    public Stack<Solt> getSolts() {
        return solts;
    }

    public void setSolts(Stack<Solt> solts) {
        this.solts = solts;
    }
}
