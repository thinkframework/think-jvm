package org.think.jvm.instructions;

import org.think.jvm.exceptions.VMException;
import org.think.jvm.instructions.comparison.*;
import org.think.jvm.instructions.constants.*;
import org.think.jvm.instructions.control.*;
import org.think.jvm.instructions.conversion.*;
import org.think.jvm.instructions.extended.*;
import org.think.jvm.instructions.load.*;
import org.think.jvm.instructions.match.*;
import org.think.jvm.instructions.references.*;
import org.think.jvm.instructions.reserved.BREAKPOINT;
import org.think.jvm.instructions.reserved.IMPDEP1;
import org.think.jvm.instructions.reserved.IMPDEP2;
import org.think.jvm.instructions.stack.*;
import org.think.jvm.instructions.store.*;

/**
 * 对象工厂
 * @author lixiaobin
 * @since 2017/3/24
 */
public class InstructionFactory {
    public static Instruction newInstruction(int op) throws VMException{
        switch (op){
            case InstructionConst.NOP:
                return new NOP();
            case InstructionConst.ACONST_NULL:
                return new ACONST_NULL();
            case InstructionConst.ICONST_M1:
                return new ICONST_M1();
            case InstructionConst.ICONST_0:
                return new ICONST_0();
            case InstructionConst.ICONST_1:
                return new ICONST_1();
            case InstructionConst.ICONST_2:
                return new ICONST_2();
            case InstructionConst.ICONST_3:
                return new ICONST_3();
            case InstructionConst.ICONST_4:
                return new ICONST_4();
            case InstructionConst.ICONST_5:
                return new ICONST_5();
            case InstructionConst.LCONST_0:
                return new LCONST_0();
            case InstructionConst.LCONST_1:
                return new LCONST_1();
            case InstructionConst.FCONST_0:
                return new FCONST_0();
            case InstructionConst.FCONST_1:
                return new FCONST_1();
            case InstructionConst.FCONST_2:
                return new FCONST_2();
            case InstructionConst.DCONST_0:
                return new DCONST_0();
            case InstructionConst.DCONST_1:
                return new DCONST_1();
            case InstructionConst.BIPUSH:
                return new BIPUSH();
            case InstructionConst.SIPUSH:
                return new SIPUSH();
            case InstructionConst.LDC:
                return new LDC();
            case InstructionConst.LDC_W:
                return new LDC_W();
            case InstructionConst.LDC2_W:
                return new LDC2_W();
            case InstructionConst.ILOAD:
                return new ILOAD();
            case InstructionConst.LLOAD:
                return new LLOAD();
            case InstructionConst.FLOAD:
                return new FLOAD();
            case InstructionConst.DLOAD:
                return new DLOAD();
            case InstructionConst.ALOAD:
                return new ALOAD();
            case InstructionConst.ILOAD_0:
                return new ILOAD_0();
            case InstructionConst.ILOAD_1:
                return new ILOAD_1();
            case InstructionConst.ILOAD_2:
                return new ILOAD_2();
            case InstructionConst.ILOAD_3:
                return new ILOAD_3();
            case InstructionConst.LLOAD_0:
                return new LLOAD_0();
            case InstructionConst.LLOAD_1:
                return new LLOAD_1();
            case InstructionConst.LLOAD_2:
                return new LLOAD_2();
            case InstructionConst.LLOAD_3:
                return new LLOAD_3();
            case InstructionConst.FLOAD_0:
                return new FLOAD_0();
            case InstructionConst.FLOAD_1:
                return new FLOAD_1();
            case InstructionConst.FLOAD_2:
                return new FLOAD_2();
            case InstructionConst.FLOAD_3:
                return new FLOAD_3();
            case InstructionConst.DLOAD_0:
                return new DLOAD_0();
            case InstructionConst.DLOAD_1:
                return new DLOAD_1();
            case InstructionConst.DLOAD_2:
                return new DLOAD_2();
            case InstructionConst.DLOAD_3:
                return new DLOAD_3();
            case InstructionConst.ALOAD_0:
                return new ALOAD_0();
            case InstructionConst.ALOAD_1:
                return new ALOAD_1();
            case InstructionConst.ALOAD_2:
                return new ALOAD_2();
            case InstructionConst.ALOAD_3:
                return new ALOAD_3();
            case InstructionConst.IALOAD:
                return new IALOAD();
            case InstructionConst.LALOAD:
                return new LALOAD();
            case InstructionConst.FALOAD:
                return new FALOAD();
            case InstructionConst.DALOAD:
                return new DALOAD();
            case InstructionConst.AALOAD:
                return new AALOAD();
            case InstructionConst.BALOAD:
                return new BALOAD();
            case InstructionConst.CALOAD:
                return new CALOAD();
            case InstructionConst.SALOAD:
                return new SALOAD();
            case InstructionConst.ISTORE:
                return new ISTORE();
            case InstructionConst.LSTORE:
                return new LSTORE();
            case InstructionConst.FSTORE:
                return new FSTORE();
            case InstructionConst.DSTORE:
                return new DSTORE();
            case InstructionConst.ASTORE:
                return new ASTORE();
            case InstructionConst.ISTORE_0:
                return new ISTORE_0();
            case InstructionConst.ISTORE_1:
                return new ISTORE_1();
            case InstructionConst.ISTORE_2:
                return new ISTORE_2();
            case InstructionConst.ISTORE_3:
                return new ISTORE_3();
            case InstructionConst.LSTORE_0:
                return new LSTORE_0();
            case InstructionConst.LSTORE_1:
                return new LSTORE_1();
            case InstructionConst.LSTORE_2:
                return new LSTORE_2();
            case InstructionConst.LSTORE_3:
                return new LSTORE_3();
            case InstructionConst.FSTORE_0:
                return new FSTORE_0();
            case InstructionConst.FSTORE_1:
                return new FSTORE_1();
            case InstructionConst.FSTORE_2:
                return new FSTORE_2();
            case InstructionConst.FSTORE_3:
                return new FSTORE_3();
            case InstructionConst.DSTORE_0:
                return new DSTORE_0();
            case InstructionConst.DSTORE_1:
                return new DSTORE_1();
            case InstructionConst.DSTORE_2:
                return new DSTORE_2();
            case InstructionConst.DSTORE_3:
                return new DSTORE_3();
            case InstructionConst.ASTORE_0:
                return new ASTORE_0();
            case InstructionConst.ASTORE_1:
                return new ASTORE_1();
            case InstructionConst.ASTORE_2:
                return new ASTORE_2();
            case InstructionConst.ASTORE_3:
                return new ASTORE_3();
            case InstructionConst.IASTORE:
                return new IASTORE();
            case InstructionConst.LASTORE:
                return new LASTORE();
            case InstructionConst.FASTORE:
                return new FASTORE();
            case InstructionConst.DASTORE:
                return new DASTORE();
            case InstructionConst.AASTORE:
                return new AASTORE();
            case InstructionConst.BASTORE:
                return new BASTORE();
            case InstructionConst.CASTORE:
                return new CASTORE();
            case InstructionConst.SASTORE:
                return new SASTORE();
            case InstructionConst.POP:
                return new POP();
            case InstructionConst.POP2:
                return new POP2();
            case InstructionConst.DUP:
                return new DUP();
            case InstructionConst.DUP_X1:
                return new DUP_X1();
            case InstructionConst.DUP_X2:
                return new DUP_X2();
            case InstructionConst.DUP2:
                return new DUP2();
            case InstructionConst.DUP2_X1:
                return new DUP2_X1();
            case InstructionConst.DUP2_X2:
                return new DUP2_X2();
            case InstructionConst.SWAP:
                return new SWAP();
            case InstructionConst.IADD:
                return new IADD();
            case InstructionConst.LADD:
                return new LADD();
            case InstructionConst.FADD:
                return new FADD();
            case InstructionConst.DADD:
                return new DADD();
            case InstructionConst.ISUB:
                return new ISUB();
            case InstructionConst.LSUB:
                return new LSUB();
            case InstructionConst.FSUB:
                return new FSUB();
            case InstructionConst.DSUB:
                return new DSUB();
            case InstructionConst.IMUL:
                return new IMUL();
            case InstructionConst.LMUL:
                return new LMUL();
            case InstructionConst.FMUL:
                return new FMUL();
            case InstructionConst.DMUL:
                return new DMUL();
            case InstructionConst.IDIV:
                return new IDIV();
            case InstructionConst.LDIV:
                return new LDIV();
            case InstructionConst.FDIV:
                return new FDIV();
            case InstructionConst.DDIV:
                return new DDIV();
            case InstructionConst.IREM:
                return new IREM();
            case InstructionConst.LREM:
                return new LREM();
            case InstructionConst.FREM:
                return new FREM();
            case InstructionConst.DREM:
                return new DREM();
            case InstructionConst.INEG:
                return new INEG();
            case InstructionConst.LNEG:
                return new LNEG();
            case InstructionConst.FNEG:
                return new FNEG();
            case InstructionConst.DNEG:
                return new DNEG();
            case InstructionConst.ISHL:
                return new ISHL();
            case InstructionConst.LSHL:
                return new LSHL();
            case InstructionConst.ISHR:
                return new ISHR();
            case InstructionConst.LSHR:
                return new LSHR();
            case InstructionConst.IUSHR:
                return new IUSHR();
            case InstructionConst.LUSHR:
                return new LUSHR();
            case InstructionConst.IAND:
                return new IAND();
            case InstructionConst.LAND:
                return new LAND();
            case InstructionConst.IOR:
                return new IOR();
            case InstructionConst.LOR:
                return new LOR();
            case InstructionConst.IXOR:
                return new IXOR();
            case InstructionConst.LXOR:
                return new LXOR();
            case InstructionConst.IINC:
                return new IINC();
            case InstructionConst.I2L:
                return new I2L();
            case InstructionConst.I2F:
                return new I2F();
            case InstructionConst.I2D:
                return new I2D();
            case InstructionConst.L2I:
                return new L2I();
            case InstructionConst.L2F:
                return new L2F();
            case InstructionConst.L2D:
                return new L2D();
            case InstructionConst.F2I:
                return new F2I();
            case InstructionConst.F2L:
                return new F2L();
            case InstructionConst.F2D:
                return new F2D();
            case InstructionConst.D2I:
                return new D2I();
            case InstructionConst.D2L:
                return new D2L();
            case InstructionConst.D2F:
                return new D2F();
            case InstructionConst.I2B:
                return new I2B();
            case InstructionConst.I2C:
                return new I2C();
            case InstructionConst.I2S:
                return new I2S();
            case InstructionConst.LCMP:
                return new LCMP();
            case InstructionConst.FCMPL:
                return new FCMPL();
            case InstructionConst.FCMPG:
                return new FCMPG();
            case InstructionConst.DCMPL:
                return new DCMPL();
            case InstructionConst.DCMPG:
                return new DCMPG();
            case InstructionConst.IFEQ:
                return new IFEQ();
            case InstructionConst.IFNE:
                return new IFNE();
            case InstructionConst.IFLT:
                return new IFLT();
            case InstructionConst.IFGE:
                return new IFGE();
            case InstructionConst.IFGT:
                return new IFGT();
            case InstructionConst.IFLE:
                return new IFLE();
            case InstructionConst.IF_ICMPEQ:
                return new IF_ICMPEQ();
            case InstructionConst.IF_ICMPNE:
                return new IF_ICMPNE();
            case InstructionConst.IF_ICMPLT:
                return new IF_ICMPLT();
            case InstructionConst.IF_ICMPGE:
                return new IF_ICMPGE();
            case InstructionConst.IF_ICMPGT:
                return new IF_ICMPGT();
            case InstructionConst.IF_ICMPLE:
                return new IF_ICMPLE();
            case InstructionConst.IF_ACMPEQ:
                return new IF_ACMPEQ();
            case InstructionConst.IF_ACMPNE:
                return new IF_ACMPNE();
            case InstructionConst.GOTO:
                return new GOTO();
            case InstructionConst.JSR:
                return new JSR();
            case InstructionConst.RET:
                return new RET();
            case InstructionConst.TABLESWITCH:
                return new TABLESWITCH();
            case InstructionConst.LOOKUPSWITCH:
                return new LOOKUPSWITCH();
            case InstructionConst.IRETURN:
                return new IRETURN();
            case InstructionConst.LRETURN:
                return new LRETURN();
            case InstructionConst.FRETURN:
                return new FRETURN();
            case InstructionConst.DRETURN:
                return new DRETURN();
            case InstructionConst.ARETURN:
                return new ARETURN();
            case InstructionConst.RETURN:
                return new RETURN();
            case InstructionConst.GETSTATIC:
                return new GETSTATIC();
            case InstructionConst.PUTSTATIC:
                return new PUTSTATIC();
            case InstructionConst.GETFIELD:
                return new GETFIELD();
            case InstructionConst.PUTFIELD:
                return new PUTFIELD();
            case InstructionConst.INVOKEVIRTUAL:
                return new INVOKEVIRTUAL();
            case InstructionConst.INVOKESPECIAL:
                return new INVOKESPECIAL();
            case InstructionConst.INVOKESTATIC:
                return new INVOKESTATIC();
            case InstructionConst.INVOKEINTERFAC:
                return new INVOKEINTERFAC();
            case InstructionConst.INVOKEDYNAMIC:
                return new INVOKEDYNAMIC();
            case InstructionConst.NEW:
                return new NEW();
            case InstructionConst.NEWARRAY:
                return new NEWARRAY();
            case InstructionConst.ANEWARRAY:
                return new ANEWARRAY();
            case InstructionConst.ARRAYLENGTH:
                return new ARRAYLENGTH();
            case InstructionConst.ATHROW:
                return new ATHROW();
            case InstructionConst.CHECKCAST:
                return new CHECKCAST();
            case InstructionConst.INSTANCEOF:
                return new INSTANCEOF();
            case InstructionConst.MONITORENTER:
                return new MONITORENTER();
            case InstructionConst.MONITOREXIT:
                return new MONITOREXIT();
            case InstructionConst.WIDE:
                return new WIDE();
            case InstructionConst.MULTIANEWARRAY:
                return new MULTIANEWARRAY();
            case InstructionConst.IFNULL:
                return new IFNULL();
            case InstructionConst.IFNONNULL:
                return new IFNONNULL();
            case InstructionConst.GOTO_W:
                return new GOTO_W();
            case InstructionConst.JSR_W:
                return new JSR_W();
            case InstructionConst.BREAKPOINT:
                return new BREAKPOINT();
            case InstructionConst.IMPDEP1:
                return new IMPDEP1();
            case InstructionConst.IMPDEP2:
                return new IMPDEP2();
            default:
                throw new VMException("无法解析的操作数."+op);
        }
    }
}
