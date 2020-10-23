package org.think.jvm.rtad;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class LocalVarsTest {
    @Test
    public void testInt(){
        LocalVars localVars = new LocalVars(10);
        localVars.setInt(0,10);
        Assert.assertEquals(10l,localVars.getInt(0).longValue());
    }

    @Test
    public void testLong(){
        LocalVars localVars = new LocalVars(10);
        localVars.setLong(0,10l);
        Assert.assertEquals(10l,localVars.getLong(0).longValue());
    }


    @Test
    public void testDouble(){
        LocalVars localVars = new LocalVars(10);
        localVars.setDouble(0,10d);
        Assert.assertEquals(10d,localVars.getDouble(0).doubleValue(),0);
    }
}
