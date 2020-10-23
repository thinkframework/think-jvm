package io.github.thinkframework.jvm;

import io.github.thinkframework.jvm.rtad.Frame;

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
