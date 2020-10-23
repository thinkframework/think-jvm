package org.think.jvm.util;

/**
 * 高位在前
 * @see java.io.DataInputStream
 * @author lixiaobin
 * @since 2017/3/24
 */
public class BytesUtils {
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte readByte(byte bytes) {
        int ch = bytes;
        return (byte)(ch);
    }

    public static int readUnsignedByte(byte bytes) {
        int ch = bytes & 0xff;
        return ch;
    }

    public static boolean readBoolean(byte[] bytes){
        int ch = bytes[0];
        return (ch != 0);
    }

    public static byte readByte(byte[] bytes) {
        int ch = bytes[0];
        return (byte)(ch);
    }

    public static int readUnsignedByte(byte[] bytes) {
        int ch = bytes[0] & 0xff;
        return ch;
    }

    public static short readShort(byte[] bytes) {
        int ch1 = bytes[0];
        int ch2 = bytes[1];
        return (short)((ch1 << 8) + (ch2 << 0));
    }

    public static int readUnsignedShort(byte[] bytes) {
        int ch1 = bytes[0] & 255;
        int ch2 = bytes[1] & 255;
        return (ch1 << 8) + (ch2 << 0);
    }

    public static char readChar(byte[] bytes) {
        int ch1 = bytes[0];
        int ch2 = bytes[1];
        return (char)((ch1 << 8) + (ch2 << 0));
    }

    public static int readInt(byte[] bytes) {
        int ch1 = bytes[0];
        int ch2 = bytes[1];
        int ch3 = bytes[2];
        int ch4 = bytes[3];
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
    }

    public static long readLong(byte[] readBuffer) {
        return (((long)readBuffer[0] << 56) +
                ((long)(readBuffer[1] & 255) << 48) +
                ((long)(readBuffer[2] & 255) << 40) +
                ((long)(readBuffer[3] & 255) << 32) +
                ((long)(readBuffer[4] & 255) << 24) +
                ((readBuffer[5] & 255) << 16) +
                ((readBuffer[6] & 255) <<  8) +
                ((readBuffer[7] & 255) <<  0));
    }

    public static float readFloat(byte[] bytes) {//throws IOException {
        return Float.intBitsToFloat(readInt(bytes));
    }

    public static double readDouble(byte[] bytes) {//throws IOException {
        return Double.longBitsToDouble(readLong(bytes));
    }

    public static byte[] writeBoolean(boolean v) {//throws IOException {
        byte[] bytes = new byte[1];
        bytes[0] = (byte) (v ? 1 : 0);
        return bytes;
    }

    public static byte[] writeByte(int v) {//throws IOException {
        byte[] bytes = new byte[1];
        bytes[0] = (byte) (v);
        return bytes;
    }

    public static byte[] writeShort(int v) {//throws IOException {
        byte[] bytes = new byte[2];
        bytes[0] = (byte)((v >>> 8) & 0xFF);
        bytes[1] = (byte)((v >>> 0) & 0xFF);
        return bytes;
    }

    public static byte[] writeChar(int v) {//throws IOException {
        byte[] bytes = new byte[2];
        bytes[0] = (byte)((v >>> 8) & 0xFF);
        bytes[1] = (byte)((v >>> 0) & 0xFF);
        return bytes;
    }

    public static byte[] writeInt(int v) {//throws IOException {
        byte[] bytes = new byte[4];
        bytes[0] = (byte)((v >>> 24) & 0xFF);
        bytes[1] = (byte)((v >>> 16) & 0xFF);
        bytes[2] = (byte)((v >>>  8) & 0xFF);
        bytes[3] = (byte)((v >>>  0) & 0xFF);
        return bytes;
    }

    public static byte[] writeLong(long v) {//throws IOException {
        byte[] bytes = new byte[8];
        bytes[0] = (byte)(v >>> 56);
        bytes[1] = (byte)(v >>> 48);
        bytes[2] = (byte)(v >>> 40);
        bytes[3] = (byte)(v >>> 32);
        bytes[4] = (byte)(v >>> 24);
        bytes[5] = (byte)(v >>> 16);
        bytes[6] = (byte)(v >>>  8);
        bytes[7] = (byte)(v >>>  0);
        return bytes;
    }

    public static byte[] writeFloat(float v) {//throws IOException {
        return writeInt(Float.floatToIntBits(v));
    }

    public static byte[] writeDouble(double v) {//throws IOException {
        return writeLong(Double.doubleToLongBits(v));
    }


//    public static String readUTF() {//throws IOException {
//        return readUTF(this);
//    }

    public static String readHexString(final byte[] data) {
        return new String(encodeHex(data));
    }

    protected static char[] encodeHex(byte[] data) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS_UPPER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_UPPER[0x0F & data[i]];
        }
        return out;
    }
}
