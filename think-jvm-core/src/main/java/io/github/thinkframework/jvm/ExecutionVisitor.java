package io.github.thinkframework.jvm;

import io.github.thinkframework.jvm.rtad.Frame;

/**
 * @see org.apache.bcel.verifier.structurals.ExecutionVisitor
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ExecutionVisitor implements Visitor{
    private Frame frame;
    private byte[] code;
    private int pc;

    public ExecutionVisitor(){
    }

    public ExecutionVisitor(byte[] code){
        this.code = code;
    }

    public ExecutionVisitor(Frame frame){
        this.frame = frame;
    }

    public ExecutionVisitor(Frame frame,byte[] code){
        this.frame = frame;
        this.code = code;
    }

    public void reset(byte[] code,int pc){
        this.code = code;
        this.pc = pc;
    }

    public int readInt8() {
        int ch = code[pc++];
        return ch;
    }

    public int readUInt8() {
        int ch = code[pc++] & 0xff;
        return ch;
    }


    public int readInt16() {
        int ch1 = code[pc++];
        int ch2 = code[pc++];
        return ((byte)(ch1 << 8) + (byte)(ch2 << 0));
    }

    public int readUInt16() {
        int ch1 = code[pc++] & 255;
        int ch2 = code[pc++] & 255;
        return (ch1 << 8) + (ch2 << 0);
    }


    public int readInt32() {
        int ch1 = code[pc++];
        int ch2 = code[pc++];
        int ch3 = code[pc++];
        int ch4 = code[pc++];
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
    }

    public int readUnit32() {
        int ch1 = code[pc++] & 255;
        int ch2 = code[pc++] & 255;
        int ch3 = code[pc++] & 255;
        int ch4 = code[pc++] & 255;
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
    }

    public int skipPadding() {
        while (pc %4 != 0){
            pc++;
        }
        return 0;
    }


    @Override
    public Frame getFrame() {
        return frame;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }
}
