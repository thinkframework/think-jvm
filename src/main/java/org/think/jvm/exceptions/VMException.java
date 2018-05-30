package org.think.jvm.exceptions;

/**
 * @author lixiaobin
 * @since 2017/3/30
 */
public class VMException extends RuntimeException {
    public VMException() {
        super();
    }

    public VMException(String message) {
        super(message);
    }

    public VMException(String message, Throwable cause) {
        super(message, cause);
    }
}
