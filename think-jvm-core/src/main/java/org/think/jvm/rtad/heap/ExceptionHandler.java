package org.think.jvm.rtad.heap;

public class ExceptionHandler {
    private Integer startPc;
    private Integer endPc;
    private Integer handlerPc;
    private ClassRef catchType;

    public Integer getStartPc() {
        return startPc;
    }

    public void setStartPc(Integer startPc) {
        this.startPc = startPc;
    }

    public Integer getEndPc() {
        return endPc;
    }

    public void setEndPc(Integer endPc) {
        this.endPc = endPc;
    }

    public Integer getHandlerPc() {
        return handlerPc;
    }

    public void setHandlerPc(Integer handlerPc) {
        this.handlerPc = handlerPc;
    }

    public ClassRef getCatchType() {
        return catchType;
    }

    public void setCatchType(ClassRef catchType) {
        this.catchType = catchType;
    }
}
