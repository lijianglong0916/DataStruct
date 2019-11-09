package bean;/*
 *@author:
 *@time
 */

public class ByteWithLength {
    private byte[] bytes;
    private int length;
    //进制
    private int  binary;
    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBinary() {
        return binary;
    }

    public void setBinary(int binary) {
        this.binary = binary;
    }
}
