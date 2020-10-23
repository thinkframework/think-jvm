package org.think.jvm;

import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.LocalVars;
import org.think.jvm.rtad.OperandStack;

/**
 * @see org.apache.bcel.generic.Visitor
 * @author lixiaobin
 * @since 2017/3/24
 */
public interface Visitor {
    public int readInt8();

    public int readUInt8();


    public int readInt16();

    public int readUInt16();


    public int readInt32();

    public int readUnit32();


    public int skipPadding();

    public Frame getFrame();
}
