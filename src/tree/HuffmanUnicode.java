package tree;/*
 *@author:
 *@time
 */

import bean.ByteWithLength;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 利用赫夫曼树进行数据压缩
 */

public class HuffmanUnicode {
    private static StringBuilder sb=new StringBuilder();
    private static Map<Byte,String> byteStringMap=new HashMap<>();
    public static void main(String[] args) throws IOException {
        HuffmanUnicode huffmanUnicode=new HuffmanUnicode();
        String str="d:/src/可爱.gif";
        String stre="uywcgfuwv iqetriFSDCESA18887SE618E78S6Z7C62SECS68E2E8Cqwatncaiwh7tr78wrbat23 t 2r 2b36rWCAEBUYAW6554AW6844V46278B14A6A987A622";
        InputStream file=new FileInputStream(new File(str));
        byte[] bytes=new byte[file.available()];
        file.read(bytes);
        System.out.println(stre.getBytes().length+"   45");
        ByteWithLength huffmanZip=huffmanUnicode.getHuffmanZip(stre.getBytes("utf-8"));
        byte[] deStr=huffmanUnicode.deCode(huffmanZip);
        OutputStream outputStream=new FileOutputStream(new File("d:/src/test1.txt"));
        outputStream.write(huffmanZip.getBytes());
        file.close();
        outputStream.close();
    }

    private  byte[] deCode(ByteWithLength huffmanZip) {
        String byteToString = byteToString(huffmanZip);
        Map<String,Byte> integerMap=new HashMap<>();
        for(Map.Entry<Byte,String> map:byteStringMap.entrySet()){
            integerMap.put(map.getValue(), map.getKey());
        }
        StringBuilder aimStr=new StringBuilder();
        int len=byteToString.length();
        int j=0;
        for(int i=j;i<len;i++){
            if (integerMap.get(byteToString.substring(j,i))!=null){
                aimStr.append((char)(byte)integerMap.get(byteToString.substring(j,i)));
                j=i;
            }
        }
        return aimStr.toString().getBytes();
    }

    public String byteToString(ByteWithLength huffmanZip){
        StringBuilder builder =new StringBuilder();
        for(int i=0;i<huffmanZip.getLength();i++){
            int temp=huffmanZip.getBytes()[i];
            temp|=256;
            String str = Integer.toBinaryString(temp).substring(Integer.toBinaryString(temp).length()-8);
            builder.append(str);
        }
        for(int i=huffmanZip.getLength()-1;i<huffmanZip.getBytes().length;i++){
            String str = Integer.toBinaryString(huffmanZip.getBytes()[i]);
            builder.append(str);
        }
        return builder.toString();
    }

    private  ByteWithLength getHuffmanZip(byte[] bytes) {
        List<HuffmanNode> list = getNodeList(bytes);
        //将node转换为一颗赫夫曼树
        HuffmanNode tree = creatHuffmanTree(list);
        //获取赫夫曼编码
        Map<Byte, String> huffmanCode = getHuffmanCode(tree);
        //进行赫夫曼编码压缩
        ByteWithLength zip=getZip(huffmanCode,bytes);
        return zip;
    }

    private ByteWithLength getZip(Map<Byte, String> huffmanCode, byte[] bytes) {
        StringBuilder builder=new StringBuilder();
        ByteWithLength byteWithLength=new ByteWithLength();
        for(byte b:bytes){
            builder.append(huffmanCode.get(b));
        }
        int len=builder.length()/8;
        if(builder.length()%8!=0){
            len++;
        }
        byte[] bytes1=new byte[builder.length()/8+builder.length()%8];
        int index=0;
        String str;
        for(int i=0;i<builder.length();i+=8){
            if(i+8<=builder.length()){
                str=builder.substring(i,i+8);
                byte b=(byte)Integer.parseInt(str,2);
                bytes1[index++]=b;
            }
            else{
                for( int j=i;j<builder.length(); j++){
                    str=builder.substring(j,j+1);
                    byte b=(byte)Integer.parseInt(str,2);
                    bytes1[index++]=b;
                }
            }
        }
        byteWithLength.setBinary(2);
        byteWithLength.setBytes(bytes1);
        byteWithLength.setLength(len);
        return byteWithLength;
    }

    //创建赫夫曼编码
    public Map<Byte,String> getHuffmanCode(HuffmanNode tree){
        if(tree==null){
            System.out.println("树为空，无法操作！ ");
            return null;
        }
        getHuffmanCode(tree.leftNode,"0",sb);
        getHuffmanCode(tree.rightNode,"1",sb);
        return byteStringMap;
    }
    //编码压缩
    public void getHuffmanCode(HuffmanNode node,String code,StringBuilder builder){
        //注意builder1的传入
        StringBuilder builder1=new StringBuilder(builder);
        builder1.append(code);
        if(node.getData()==null){
            //这里遍历时传入新的字符串
            getHuffmanCode(node.leftNode,"0",builder1);
            getHuffmanCode(node.rightNode,"1",builder1);
        }else{
            byteStringMap.put((byte)node.getData(),builder1.toString());
        }
    }

    //创建赫夫曼树
    private  HuffmanNode creatHuffmanTree(List<HuffmanNode> list) {
        if(list==null||list.size()<=1){
            if(list.size()==0){
                System.out.println("error:无节点或node不存在！");
            }
            if(list.size()==1){
                return list.get(0);
            }
        }
        HuffmanNode parentNode = null;
        while(list.size()>1){
            HuffmanNode firstMin=getMinNode(list);
            list.remove(firstMin);
            HuffmanNode secondMin=getMinNode(list);
            list.remove(secondMin);
            int parentWeight=firstMin.getWeight()+secondMin.getWeight();
            parentNode=new HuffmanNode(null,parentWeight);
            parentNode.leftNode=secondMin;
            parentNode.rightNode=firstMin;
            list.add(parentNode);
        }
        return parentNode;
    }
    //获取权值最小的node
    public HuffmanNode getMinNode(List<HuffmanNode> nodes){
        int min=Integer.MAX_VALUE;
        HuffmanNode huffmanNode=new HuffmanNode(null,min);
        for(HuffmanNode node:nodes){
            if(node.getWeight()<huffmanNode.getWeight()){
                huffmanNode=node;
            }
        }
        return huffmanNode;
    }
    //将字节数组转换为node的list，并获取相应出现的次数
    private static List<HuffmanNode> getNodeList(byte[] aByte) {
        Map<Byte, Integer> map=new HashMap<>();
        for(byte b:aByte){
            Integer count=map.get(b);
            if(count==null){
                map.put(b,1);
            }else{
                map.put(b, count+1);
            }
        }
        List<HuffmanNode> list=new ArrayList<>();
        for(Map.Entry<Byte,Integer> entry:map.entrySet()){
            HuffmanNode node=new HuffmanNode(entry.getKey(),entry.getValue());
            list.add(node);
        }
        return  list;
    }
}
