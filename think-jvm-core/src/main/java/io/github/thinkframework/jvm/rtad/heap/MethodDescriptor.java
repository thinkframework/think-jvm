package io.github.thinkframework.jvm.rtad.heap;

public class MethodDescriptor {
    private String[] parameterTypes;
    private String returnType;

    public MethodDescriptor(String description){
        Integer paramStart = description.indexOf("(");
        Integer paramEnd = description.lastIndexOf(")");
        String paramString = description.substring(paramStart+1,paramEnd);
        if(paramString != null && paramString.length() >0 ) {
            parameterTypes = paramString.split(";");
        }
        returnType = description.substring(paramEnd+1);
    }
    public String[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
