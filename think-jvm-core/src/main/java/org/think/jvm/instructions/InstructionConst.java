package org.think.jvm.instructions;

/**
 * @see org.apache.bcel.generic.InstructionConst
 * @author lixiaobin
 * @since 2017/3/24
 */
public class InstructionConst {
    /*
    *什么都不做
     */
    public static final int NOP = 0x00;

    /*
    *将null推送至栈顶
    */
    public static final int ACONST_NULL = 0x01;

    /*
    *将int型-1推送至栈顶
    */
    public static final int ICONST_M1 = 0x02;

    /*
    *将int型0推送至栈顶
    */
    public static final int ICONST_0 = 0x03;

    /*
    *将int型1推送至栈顶
    */
    public static final int ICONST_1 = 0x04;

    /*
    *将int型2推送至栈顶
    */
    public static final int ICONST_2 = 0x05;

    /*
    *将int型3推送至栈顶
    */
    public static final int ICONST_3 = 0x06;

    /*
    *将int型4推送至栈顶
    */
    public static final int ICONST_4 = 0x07;

    /*
    *将int型5推送至栈顶
    */
    public static final int ICONST_5 = 0x08;

    /*
    *将long型0推送至栈顶
    */
    public static final int LCONST_0 = 0x09;

    /*
    *将long型1推送至栈顶
    */
    public static final int LCONST_1 = 0x0a;

    /*
    *将float型0推送至栈顶
    */
    public static final int FCONST_0 = 0x0b;

    /*
    *将float型1推送至栈顶
    */
    public static final int FCONST_1 = 0x0c;

    /*
    *将float型2推送至栈顶
    */
    public static final int FCONST_2 = 0x0d;

    /*
    *将double型0推送至栈顶
    */
    public static final int DCONST_0 = 0x0e;

    /*
    *将double型1推送至栈顶
    */
    public static final int DCONST_1 = 0x0f;

    /*
    *将单字节的常量值(-128~127)推送至栈顶
    */
    public static final int BIPUSH = 0x10;

    /*
    *将一个短整型常量值(-32768~32767)推送至栈顶
    */
    public static final int SIPUSH = 0x11;

    /*
    *将int,float或String型常量值从常量池中推送至栈顶
    */
    public static final int LDC = 0x12;

    /*
    *将int,float或String型常量值从常量池中推送至栈顶(宽索引)
    */
    public static final int LDC_W = 0x13;

    /*
    *将long或double型常量值从常量池中推送至栈顶(宽索引)
    */
    public static final int LDC2_W = 0x14;

    /*
    *将指定的int型局部变量推送至栈顶
    */
    public static final int ILOAD = 0x15;

    /*
    *将指定的long型局部变量推送至栈顶
    */
    public static final int LLOAD = 0x16;

    /*
    *将指定的float型局部变量推送至栈顶
    */
    public static final int FLOAD = 0x17;

    /*
    *将指定的double型局部变量推送至栈顶
    */
    public static final int DLOAD = 0x18;

    /*
    *将指定的引用类型局部变量推送至栈顶
    */
    public static final int ALOAD = 0x19;

    /*
    *将第一个int型局部变量推送至栈顶
    */
    public static final int ILOAD_0 = 0x1a;

    /*
    *将第二个int型局部变量推送至栈顶
    */
    public static final int ILOAD_1 = 0x1b;

    /*
    *将第三个int型局部变量推送至栈顶
    */
    public static final int ILOAD_2 = 0x1c;

    /*
    *将第四个int型局部变量推送至栈顶
    */
    public static final int ILOAD_3 = 0x1d;

    /*
    *将第一个long型局部变量推送至栈顶
    */
    public static final int LLOAD_0 = 0x1e;

    /*
    *将第二个long型局部变量推送至栈顶
    */
    public static final int LLOAD_1 = 0x1f;

    /*
    *将第三个long型局部变量推送至栈顶
    */
    public static final int LLOAD_2 = 0x20;

    /*
    *将第四个long型局部变量推送至栈顶
    */
    public static final int LLOAD_3 = 0x21;

    /*
    *将第一个float型局部变量推送至栈顶
    */
    public static final int FLOAD_0 = 0x22;

    /*
    *将第二个float型局部变量推送至栈顶
    */
    public static final int FLOAD_1 = 0x23;

    /*
    *将第三个float型局部变量推送至栈顶
    */
    public static final int FLOAD_2 = 0x24;

    /*
    *将第四个float型局部变量推送至栈顶
    */
    public static final int FLOAD_3 = 0x25;

    /*
    *将第一个double型局部变量推送至栈顶
    */
    public static final int DLOAD_0 = 0x26;

    /*
    *将第二个double型局部变量推送至栈顶
    */
    public static final int DLOAD_1 = 0x27;

    /*
    *将第三个double型局部变量推送至栈顶
    */
    public static final int DLOAD_2 = 0x28;

    /*
    *将第四个double型局部变量推送至栈顶
    */
    public static final int DLOAD_3 = 0x29;

    /*
    *将第一个引用类型局部变量推送至栈顶
    */
    public static final int ALOAD_0 = 0x2a;

    /*
    *将第二个引用类型局部变量推送至栈顶
    */
    public static final int ALOAD_1 = 0x2b;

    /*
    *将第三个引用类型局部变量推送至栈顶
    */
    public static final int ALOAD_2 = 0x2c;

    /*
    *将第四个引用类型局部变量推送至栈顶
    */
    public static final int ALOAD_3 = 0x2d;

    /*
    *将int型数组指定索引的值推送至栈顶
    */
    public static final int IALOAD = 0x2e;

    /*
    *将long型数组指定索引的值推送至栈顶
    */
    public static final int LALOAD = 0x2f;

    /*
    *将float型数组指定索引的值推送至栈顶
    */
    public static final int FALOAD = 0x30;

    /*
    *将double型数组指定索引的值推送至栈顶
    */
    public static final int DALOAD = 0x31;

    /*
    *将引用型数组指定索引的值推送至栈顶
    */
    public static final int AALOAD = 0x32;

    /*
    *将boolean或byte型数组指定索引的值推送至栈顶
    */
    public static final int BALOAD = 0x33;

    /*
    *将char型数组指定索引的值推送至栈顶
    */
    public static final int CALOAD = 0x34;

    /*
    *将short型数组指定索引的值推送至栈顶
    */
    public static final int SALOAD = 0x35;

    /*
    *将栈顶int型数值存入指定局部变量
    */
    public static final int ISTORE = 0x36;

    /*
    *将栈顶long型数值存入指定局部变量
    */
    public static final int LSTORE = 0x37;

    /*
    *将栈顶float型数值存入指定局部变量
    */
    public static final int FSTORE = 0x38;

    /*
    *将栈顶double型数值存入指定局部变量
    */
    public static final int DSTORE = 0x39;

    /*
    *将栈顶引用型数值存入指定局部变量
    */
    public static final int ASTORE = 0x3a;

    /*
    *将栈顶int型数值存入第一个局部变量
    */
    public static final int ISTORE_0 = 0x3b;

    /*
    *将栈顶int型数值存入第二个局部变量
    */
    public static final int ISTORE_1 = 0x3c;

    /*
    *将栈顶int型数值存入第三个局部变量
    */
    public static final int ISTORE_2 = 0x3d;

    /*
    *将栈顶int型数值存入第四个局部变量
    */
    public static final int ISTORE_3 = 0x3e;

    /*
    *将栈顶long型数值存入第一个局部变量
    */
    public static final int LSTORE_0 = 0x3f;

    /*
    *将栈顶long型数值存入第二个局部变量
    */
    public static final int LSTORE_1 = 0x40;

    /*
    *将栈顶long型数值存入第三个局部变量
    */
    public static final int LSTORE_2 = 0x41;

    /*
    *将栈顶long型数值存入第四个局部变量
    */
    public static final int LSTORE_3 = 0x42;

    /*
    *将栈顶float型数值存入第一个局部变量
    */
    public static final int FSTORE_0 = 0x43;

    /*
    *将栈顶float型数值存入第二个局部变量
    */
    public static final int FSTORE_1 = 0x44;

    /*
    *将栈顶float型数值存入第三个局部变量
    */
    public static final int FSTORE_2 = 0x45;

    /*
    *将栈顶float型数值存入第四个局部变量
    */
    public static final int FSTORE_3 = 0x46;

    /*
    *将栈顶double型数值存入第一个局部变量
    */
    public static final int DSTORE_0 = 0x47;

    /*
    *将栈顶double型数值存入第二个局部变量
    */
    public static final int DSTORE_1 = 0x48;

    /*
    *将栈顶double型数值存入第三个局部变量
    */
    public static final int DSTORE_2 = 0x49;

    /*
    *将栈顶double型数值存入第四个局部变量
    */
    public static final int DSTORE_3 = 0x4a;

    /*
    *将栈顶引用型数值存入第一个局部变量
    */
    public static final int ASTORE_0 = 0x4b;

    /*
    *将栈顶引用型数值存入第二个局部变量
    */
    public static final int ASTORE_1 = 0x4c;

    /*
    *将栈顶引用型数值存入第三个局部变量
    */
    public static final int ASTORE_2 = 0x4d;

    /*
    *将栈顶引用型数值存入第四个局部变量
    */
    public static final int ASTORE_3 = 0x4e;

    /*
    *将栈顶int型数值存入指定数组的指定索引位置
    */
    public static final int IASTORE = 0x4f;

    /*
    *将栈顶long型数值存入指定数组的指定索引位置
    */
    public static final int LASTORE = 0x50;

    /*
    *将栈顶float型数值存入指定数组的指定索引位置
    */
    public static final int FASTORE = 0x51;

    /*
    *将栈顶double型数值存入指定数组的指定索引位置
    */
    public static final int DASTORE = 0x52;

    /*
    *将栈顶引用型数值存入指定数组的指定索引位置
    */
    public static final int AASTORE = 0x53;

    /*
    *将栈顶boolean或byte型数值存入指定数组的指定索引位置
    */
    public static final int BASTORE = 0x54;

    /*
    *将栈顶char型数值存入指定数组的指定索引位置
    */
    public static final int CASTORE = 0x55;

    /*
    *将栈顶short型数值存入指定数组的指定索引位置
    */
    public static final int SASTORE = 0x56;

    /*
    *将栈顶数值弹出(数值不能是long或double类型的)
    */
    public static final int POP = 0x57;

    /*
    *将栈顶的一个(long或double类型的)或两个数值弹出(其它)
    */
    public static final int POP2 = 0x58;

    /*
    *复制栈顶数值并将复制值压入栈顶
    */
    public static final int DUP = 0x59;

    /*
    *复制栈顶数值并将两个复制值压入栈顶
    */
    public static final int DUP_X1 = 0x5a;

    /*
    *复制栈顶数值并将三个(或两个)复制值压入栈顶
    */
    public static final int DUP_X2 = 0x5b;

    /*
    *复制栈顶一个(long或double类型的)或两个(其它)数值并将复制值压入栈顶
    */
    public static final int DUP2 = 0x5c;

    /*
    *dup_x1指令的双倍版本
    */
    public static final int DUP2_X1 = 0x5d;

    /*
    *dup_x2指令的双倍版本
    */
    public static final int DUP2_X2 = 0x5e;

    /*
    *将栈最顶端的两个数值互换(数值不能是long或double类型的)
    */
    public static final int SWAP = 0x5f;

    /*
    *将栈顶两int型数值相加并将结果压入栈顶
    */
    public static final int IADD = 0x60;

    /*
    *将栈顶两long型数值相加并将结果压入栈顶
    */
    public static final int LADD = 0x61;

    /*
    *将栈顶两float型数值相加并将结果压入栈顶
    */
    public static final int FADD = 0x62;

    /*
    *将栈顶两double型数值相加并将结果压入栈顶
    */
    public static final int DADD = 0x63;

    /*
    *将栈顶两int型数值相减并将结果压入栈顶
    */
    public static final int ISUB = 0x64;

    /*
    *将栈顶两long型数值相减并将结果压入栈顶
    */
    public static final int LSUB = 0x65;

    /*
    *将栈顶两float型数值相减并将结果压入栈顶
    */
    public static final int FSUB = 0x66;

    /*
    *将栈顶两double型数值相减并将结果压入栈顶
    */
    public static final int DSUB = 0x67;

    /*
    *将栈顶两int型数值相乘并将结果压入栈顶
    */
    public static final int IMUL = 0x68;

    /*
    *将栈顶两long型数值相乘并将结果压入栈顶
    */
    public static final int LMUL = 0x69;

    /*
    *将栈顶两float型数值相乘并将结果压入栈顶
    */
    public static final int FMUL = 0x6a;

    /*
    *将栈顶两double型数值相乘并将结果压入栈顶
    */
    public static final int DMUL = 0x6b;

    /*
    *将栈顶两int型数值相除并将结果压入栈顶
    */
    public static final int IDIV = 0x6c;

    /*
    *将栈顶两long型数值相除并将结果压入栈顶
    */
    public static final int LDIV = 0x6d;

    /*
    *将栈顶两float型数值相除并将结果压入栈顶
    */
    public static final int FDIV = 0x6e;

    /*
    *将栈顶两double型数值相除并将结果压入栈顶
    */
    public static final int DDIV = 0x6f;

    /*
    *将栈顶两int型数值作取模运算并将结果压入栈顶
    */
    public static final int IREM = 0x70;

    /*
    *将栈顶两long型数值作取模运算并将结果压入栈顶
    */
    public static final int LREM = 0x71;

    /*
    *将栈顶两float型数值作取模运算并将结果压入栈顶
    */
    public static final int FREM = 0x72;

    /*
    *将栈顶两double型数值作取模运算并将结果压入栈顶
    */
    public static final int DREM = 0x73;

    /*
    *将栈顶int型数值取负并将结果压入栈顶
    */
    public static final int INEG = 0x74;

    /*
    *将栈顶long型数值取负并将结果压入栈顶
    */
    public static final int LNEG = 0x75;

    /*
    *将栈顶float型数值取负并将结果压入栈顶
    */
    public static final int FNEG = 0x76;

    /*
    *将栈顶double型数值取负并将结果压入栈顶
    */
    public static final int DNEG = 0x77;

    /*
    *将int型数值左移位指定位数并将结果压入栈顶
    */
    public static final int ISHL = 0x78;

    /*
    *将long型数值左移位指定位数并将结果压入栈顶
    */
    public static final int LSHL = 0x79;

    /*
    *将int型数值右(有符号)移位指定位数并将结果压入栈顶
    */
    public static final int ISHR = 0x7a;

    /*
    *将long型数值右(有符号)移位指定位数并将结果压入栈顶
    */
    public static final int LSHR = 0x7b;

    /*
    *将int型数值右(无符号)移位指定位数并将结果压入栈顶
    */
    public static final int IUSHR = 0x7c;

    /*
    *将long型数值右(无符号)移位指定位数并将结果压入栈顶
    */
    public static final int LUSHR = 0x7d;

    /*
    *将栈顶两int型数值作“按位与”并将结果压入栈顶
    */
    public static final int IAND = 0x7e;

    /*
    *将栈顶两long型数值作“按位与”并将结果压入栈顶
    */
    public static final int LAND = 0x7f;

    /*
    *将栈顶两int型数值作“按位或”并将结果压入栈顶
    */
    public static final int IOR = 0x80;

    /*
    *将栈顶两long型数值作“按位或”并将结果压入栈顶
    */
    public static final int LOR = 0x81;

    /*
    *将栈顶两int型数值作“按位异或”并将结果压入栈顶
    */
    public static final int IXOR = 0x82;

    /*
    *将栈顶两long型数值作“按位异或”并将结果压入栈顶
    */
    public static final int LXOR = 0x83;

    /*
    *将指定int型变量增加指定值
    */
    public static final int IINC = 0x84;

    /*
    *将栈顶int型数值强制转换成long型数值并将结果压入栈顶
    */
    public static final int I2L = 0x85;

    /*
    *将栈顶int型数值强制转换成float型数值并将结果压入栈顶
    */
    public static final int I2F = 0x86;

    /*
    *将栈顶int型数值强制转换成double型数值并将结果压入栈顶
    */
    public static final int I2D = 0x87;

    /*
    *将栈顶long型数值强制转换成int型数值并将结果压入栈顶
    */
    public static final int L2I = 0x88;

    /*
    *将栈顶long型数值强制转换成float型数值并将结果压入栈顶
    */
    public static final int L2F = 0x89;

    /*
    *将栈顶long型数值强制转换成double型数值并将结果压入栈顶
    */
    public static final int L2D = 0x8a;

    /*
    *将栈顶float型数值强制转换成int型数值并将结果压入栈顶
    */
    public static final int F2I = 0x8b;

    /*
    *将栈顶float型数值强制转换成long型数值并将结果压入栈顶
    */
    public static final int F2L = 0x8c;

    /*
    *将栈顶float型数值强制转换成double型数值并将结果压入栈顶
    */
    public static final int F2D = 0x8d;

    /*
    *将栈顶double型数值强制转换成int型数值并将结果压入栈顶
    */
    public static final int D2I = 0x8e;

    /*
    *将栈顶double型数值强制转换成long型数值并将结果压入栈顶
    */
    public static final int D2L = 0x8f;

    /*
    *将栈顶double型数值强制转换成float型数值并将结果压入栈顶
    */
    public static final int D2F = 0x90;

    /*
    *将栈顶int型数值强制转换成byte型数值并将结果压入栈顶
    */
    public static final int I2B = 0x91;

    /*
    *将栈顶int型数值强制转换成char型数值并将结果压入栈顶
    */
    public static final int I2C = 0x92;

    /*
    *将栈顶int型数值强制转换成short型数值并将结果压入栈顶
    */
    public static final int I2S = 0x93;

    /*
    *比较栈顶两long型数值大小,并将结果(1,0,-1)压入栈顶
    */
    public static final int LCMP = 0x94;

    /*
    *比较栈顶两float型数值大小,并将结果(1,0,-1)压入栈顶;当其中一个数值为“NaN”时,将-1压入栈顶
    */
    public static final int FCMPL = 0x95;

    /*
    *比较栈顶两float型数值大小,并将结果(1,0,-1)压入栈顶;当其中一个数值为“NaN”时,将1压入栈顶
    */
    public static final int FCMPG = 0x96;

    /*
    *比较栈顶两double型数值大小,并将结果(1,0,-1)压入栈顶;当其中一个数值为“NaN”时,将-1压入栈顶
    */
    public static final int DCMPL = 0x97;

    /*
    *比较栈顶两double型数值大小,并将结果(1,0,-1)压入栈顶;当其中一个数值为“NaN”时,将1压入栈顶
    */
    public static final int DCMPG = 0x98;

    /*
    *当栈顶int型数值等于0时跳转
    */
    public static final int IFEQ = 0x99;

    /*
    *当栈顶int型数值不等于0时跳转
    */
    public static final int IFNE = 0x9a;

    /*
    *当栈顶int型数值小于0时跳转
    */
    public static final int IFLT = 0x9b;

    /*
    *当栈顶int型数值大于等于0时跳转
    */
    public static final int IFGE = 0x9c;

    /*
    *当栈顶int型数值大于0时跳转
    */
    public static final int IFGT = 0x9d;

    /*
    *当栈顶int型数值小于等于0时跳转
    */
    public static final int IFLE = 0x9e;

    /*
    *比较栈顶两int型数值大小,当结果等于0时跳转
    */
    public static final int IF_ICMPEQ = 0x9f;

    /*
    *比较栈顶两int型数值大小,当结果不等于0时跳转
    */
    public static final int IF_ICMPNE = 0xa0;

    /*
    *比较栈顶两int型数值大小,当结果小于0时跳转
    */
    public static final int IF_ICMPLT = 0xa1;

    /*
    *比较栈顶两int型数值大小,当结果大于等于0时跳转
    */
    public static final int IF_ICMPGE = 0xa2;

    /*
    *比较栈顶两int型数值大小,当结果大于0时跳转
    */
    public static final int IF_ICMPGT = 0xa3;

    /*
    *比较栈顶两int型数值大小,当结果小于等于0时跳转
    */
    public static final int IF_ICMPLE = 0xa4;

    /*
    *比较栈顶两引用型数值,当结果相等时跳转
    */
    public static final int IF_ACMPEQ = 0xa5;

    /*
    *比较栈顶两引用型数值,当结果不相等时跳转
    */
    public static final int IF_ACMPNE = 0xa6;

    /*
    *无条件跳转
    */
    public static final int GOTO = 0xa7;

    /*
    *跳转至指定16位offset位置,并将jsr下一条指令地址压入栈顶
    */
    public static final int JSR = 0xa8;

    /*
    *返回至局部变量指定的index的指令位置(一般与jsr,jsr_w联合使用)
    */
    public static final int RET = 0xa9;

    /*
    *用于switch条件跳转,case值连续(可变长度指令)
    */
    public static final int TABLESWITCH = 0xaa;

    /*
    *用于switch条件跳转,case值不连续(可变长度指令)
    */
    public static final int LOOKUPSWITCH = 0xab;

    /*
    *从当前方法返回int
    */
    public static final int IRETURN = 0xac;

    /*
    *从当前方法返回long
    */
    public static final int LRETURN = 0xad;

    /*
    *从当前方法返回float
    */
    public static final int FRETURN = 0xae;

    /*
    *从当前方法返回double
    */
    public static final int DRETURN = 0xaf;

    /*
    *从当前方法返回对象引用
    */
    public static final int ARETURN = 0xb0;

    /*
    *从当前方法返回void
    */
    public static final int RETURN = 0xb1;

    /*
    *获取指定类的静态域,并将其值压入栈顶
    */
    public static final int GETSTATIC = 0xb2;

    /*
    *为指定的类的静态域赋值
    */
    public static final int PUTSTATIC = 0xb3;

    /*
    *获取指定类的实例域,并将其值压入栈顶
    */
    public static final int GETFIELD = 0xb4;

    /*
    *为指定的类的实例域赋值
    */
    public static final int PUTFIELD = 0xb5;

    /*
    *调用实例方法
    */
    public static final int INVOKEVIRTUAL = 0xb6;

    /*
    *调用超类构造方法,实例初始化方法,私有方法
    */
    public static final int INVOKESPECIAL = 0xb7;

    /*
    *调用静态方法
    */
    public static final int INVOKESTATIC = 0xb8;

    /*
    *调用接口方法e
    */
    public static final int INVOKEINTERFAC = 0xb9;

    /*
    *调用动态链接方法1
    */
    public static final int INVOKEDYNAMIC = 0xba;

    /*
    *创建一个对象,并将其引用值压入栈顶
    */
    public static final int NEW = 0xbb;

    /*
    *创建一个指定原始类型(如int、float、char)的数组,并将其引用值压入栈顶
    */
    public static final int NEWARRAY = 0xbc;

    /*
    *创建一个引用型(如类,接口,数组)的数组,并将其引用值压入栈顶
    */
    public static final int ANEWARRAY = 0xbd;

    /*
    *获得数组的长度值并压入栈顶
    */
    public static final int ARRAYLENGTH = 0xbe;

    /*
    *将栈顶的异常抛出
    */
    public static final int ATHROW = 0xbf;

    /*
    *检验类型转换,检验未通过将抛出ClassCastException
    */
    public static final int CHECKCAST = 0xc0;

    /*
    *检验对象是否是指定的类的实例,如果是将1压入栈顶,否则将0压入栈顶
    */
    public static final int INSTANCEOF = 0xc1;

    /*
    *获得对象的monitor,用于同步方法或同步块
    */
    public static final int MONITORENTER = 0xc2;

    /*
    *释放对象的monitor,用于同步方法或同步块
    */
    public static final int MONITOREXIT = 0xc3;

    /*
    *扩展访问局部变量表的索引宽度
    */
    public static final int WIDE = 0xc4;

    /*
    *创建指定类型和指定维度的多维数组(执行该指令时,操作栈中必须包含各维度的长度值),并将其引用值压入栈顶
    */
    public static final int MULTIANEWARRAY = 0xc5;

    /*
    *为null时跳转
    */
    public static final int IFNULL = 0xc6;

    /*
    *不为null时跳转
    */
    public static final int IFNONNULL = 0xc7;

    /*
    *无条件跳转(宽索引)
    */
    public static final int GOTO_W = 0xc8;

    /*
    *跳转至指定32位地址偏移量位置,并将jsr_w下一条指令地址压入栈顶
    */
    public static final int JSR_W = 0xc9;

    /*
    *调试时的断点标志
    */
    public static final int BREAKPOINT = 0xca;

    /*
    *用于在特定硬件中使用的语言后门
    */
    public static final int IMPDEP1 = 0xfe;

    /*
    *用于在特定硬件中使用的语言后门
    */
    public static final int IMPDEP2 = 0xff;
}
