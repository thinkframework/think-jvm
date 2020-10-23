package org.think.jvm.rtad;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class OperandStackTest {
    @Test
    public void testInt(){
        OperandStack localVars = new OperandStack(10);
        localVars.pushInt(10);
        Assert.assertEquals(10l,localVars.popInt().longValue());
    }

    @Test
    public void testLong(){
        OperandStack localVars = new OperandStack(10);
        localVars.pushLong(10l);
        Assert.assertEquals(10l,localVars.popLong().longValue());
    }


    @Test
    public void testDouble(){
        OperandStack localVars = new OperandStack(10);
        localVars.pushDouble(10d);
        Assert.assertEquals(10d,localVars.popDouble().doubleValue(),0);
    }
}
