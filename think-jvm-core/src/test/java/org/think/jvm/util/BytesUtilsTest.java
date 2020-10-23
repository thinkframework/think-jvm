package org.think.jvm.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class BytesUtilsTest {
    protected static final Logger log = LoggerFactory.getLogger(BytesUtilsTest.class);

    @Test
    public void testInteger() {
//　　十进制转成二进制
        log.debug("{}",Integer.toBinaryString(127));
//　　十进制转成八进制
        log.debug("{}",Integer.toOctalString(127));
//　　十进制转成十六进制：
        log.debug("{}",Integer.toHexString(127));
//　　二进制转十进制
        log.debug("{}",Integer.valueOf("00000000", 2).toString());
//　　八进制转成十进制
        log.debug("{}",Integer.valueOf("125", 8).toString());
//　　十六进制转成十进制
        log.debug("{}",Integer.valueOf("ABCDEF", 16).toString());
    }


    @Test
    public void testBoolean(){
        boolean value = true;
        byte[] bytes = BytesUtils.writeBoolean(value);
        log.debug("{}",BytesUtils.readHexString(bytes));
        assertEquals(value,BytesUtils.readBoolean(bytes));
    }

    @Test
    public void testByte(){
        byte value = Byte.MIN_VALUE;
        byte[] bytes = BytesUtils.writeByte(value);
        log.debug("{}",value);
        log.debug("{}",BytesUtils.readHexString(bytes));
        log.debug("{}",BytesUtils.readByte(bytes));
        log.debug("{}",BytesUtils.readUnsignedByte(bytes));
        assertEquals(value,BytesUtils.readByte(bytes));
    }

    @Test
    public void testShort(){
        short value = Short.MIN_VALUE;
        byte[] bytes = BytesUtils.writeShort(value);
        log.debug("{}",value);
        log.debug("{}",BytesUtils.readHexString(bytes));
        log.debug("{}",BytesUtils.readShort(bytes));
        log.debug("{}",BytesUtils.readUnsignedShort(bytes));
        log.debug("{}",BytesUtils.readShort(bytes));
        assertEquals(value,BytesUtils.readShort(bytes));
    }

    @Test
    public void testShort1(){
        short value = Short.MIN_VALUE;
        byte[] bytes = BytesUtils.writeShort(value);
        bytes = new byte[]{0,-13};
        log.debug("{}",BytesUtils.readShort(bytes));
        log.debug("{}",BytesUtils.readUnsignedShort(bytes));
        log.debug("{}",BytesUtils.readShort(bytes));
    }

    @Test
    public void testChar(){
        char value = Character.MAX_VALUE;
        byte[] bytes = BytesUtils.writeChar(value);
        log.debug("{}",value);
        log.debug("{}",BytesUtils.readHexString(bytes));
        log.debug("{}",BytesUtils.readChar(bytes));
        assertEquals(value,BytesUtils.readChar(bytes));
    }


    @Test
    public void testInt(){
        int value = Integer.MIN_VALUE;
        byte[] bytes = BytesUtils.writeInt(value);
        log.debug("{}",value);
        log.debug("{}",BytesUtils.readHexString(bytes));
        log.debug("{}",BytesUtils.readInt(bytes));
        assertEquals(value,BytesUtils.readInt(bytes));
    }


    @Test
    public void testLong(){
        long value = Long.MIN_VALUE;
        byte[] bytes = BytesUtils.writeLong(value);
        log.debug("{}",value);
        log.debug("{}",BytesUtils.readHexString(bytes));
        log.debug("{}",BytesUtils.readLong(bytes));
        assertEquals(value,BytesUtils.readLong(bytes));
    }


    @Test
    public void testFloat(){
        float value = Float.MIN_VALUE;
        byte[] bytes = BytesUtils.writeFloat(value);
        log.debug("{}",value);
        log.debug("{}",BytesUtils.readHexString(bytes));
        log.debug("{}",BytesUtils.readFloat(bytes));
        assertEquals(value,BytesUtils.readFloat(bytes),0);
    }


    @Test
    public void testDouble(){
        double value = Double.MIN_VALUE;
        byte[] bytes = BytesUtils.writeDouble(value);
        log.debug("{}",value);
        log.debug("{}",BytesUtils.readHexString(bytes));
        log.debug("{}",BytesUtils.readDouble(bytes));
        assertEquals(value,BytesUtils.readDouble(bytes),0);
    }

    @Test
    public void test9(){
//        byte[] bytes = new byte[]{1,-22};
//        log.debug("{}",ByteUtils.u2toint(bytes));
//
//        byte[] bytes2 = new byte[]{0,0,0,1,1,0,0,0};
//        log.debug("{}",ByteUtils.getLong(bytes2));
//        long bytes2Long = Utilities.bytes2Long(bytes2);
//        log.debug("{}","bytes转行成long: " + bytes2Long);
//        byte a = 11;
//        int b = a & 0xff;
//        long c = ((long)a & 0xffl) << 32;
//        long d = ((long)a & 0xffl << 32);
//        log.debug("{}",b);
//        log.debug("{}",c);
//        log.debug("{}",d);
    }


//    @Test
//    public void test2(){
//        byte[] bytes = new byte[]{1,-22};
//        log.debug("{}",ByteUtils.u2toint(bytes));
//
//        byte[] bytes2 = new byte[]{0,1,0,0};
//        log.debug("{}",ByteUtils.getInt(bytes2));
//    }
//
//    @Test
//    public void test12(){
//        double E = 3.14;
//        long l = (long) 3.14;
//        byte[] bytes = new byte[]{64,5,-65,9,-107,86,-9,-112};
//        log.debug("{}",ByteUtils.getLong(bytes));
//        log.debug("{}",Double.longBitsToDouble(ByteUtils.getLong(bytes)));
//        log.debug("{}",E);
//        log.debug("{}",new Double(E).toString());
//        double d = 503.2135013;
//        long value = Double.doubleToRawLongBits(d);
//        byte[] byteRet = new byte[8];
//        for (int i = 0; i < 8; i++) {
//            byteRet[i] = (byte) ((value >> 8 * i) & 0xff);
//        }
//        log.debug("{}",byteRet);
//        long value2 = 0;
//        for (int i = 0; i < 8; i++) {
//            value2 |= ((long) (byteRet[i] & 0xff)) << (8 * i);
//        }
//        log.debug("{}",Double.longBitsToDouble(value2));
//        long ll = ByteUtils.getLong(byteRet);
//        log.debug("{}",ll);
////        long l3 = ByteUtils.u8tolong2(byteRet);
////        log.debug("{}",l3);
//        log.debug("{}",Double.longBitsToDouble(4647560241726542453l));
//
//
//    }
//
//    @Test
//    public void test15(){
//        double[] doubles = new double[]{8,16,24,32,40,48,54};
//        for (double d : doubles){
//            Double tmp = Math.pow(2,d);
//            String s = tmp.toString().substring(0,tmp.toString().indexOf("."));
//            Long l =  new Long(s);
//            byte[] bytes = ByteUtils.getBytes(l);
//            long l1 = ByteUtils.getLong(bytes);
//        }
//
//    }
//
//
//    @Test
//    public void testint(){
//        int i = 1147483647;
//            byte[] ib = ByteUtils.getBytes(i);
//            int l1 = ByteUtils.getInt(ib);
//            log.debug("{}",l1);
//    }
//
//    @Test
//    public void testfloat(){
//        float f = 3.14f;
//        int i = Float.floatToRawIntBits(f);
//        byte[] ib = ByteUtils.getBytes(i);
//        int l1 = ByteUtils.getInt(ib);
//        float f1 = Float.intBitsToFloat(l1);
//        log.debug("{}",f1);
//    }
//
//    @Test
//    public void testdouble(){
//        double d = 3.14d;
//        long l = Double.doubleToRawLongBits(d);
//        byte[] lb = ByteUtils.getBytes(l);
//        long l1 = ByteUtils.getLong(lb);
//        double f1 = Double.longBitsToDouble(l1);
//        log.debug("{}",f1);
//    }

    @Test
    public void test17(){
        double d = 1.1d;
        Long l =  new Long(9007199254740992l);
//        byte[] bytes = ByteUtils.getBytes(1.1d);
//        long l1 = ByteUtils.getLong(bytes);
//        log.debug("{}",l1);
    }

}
