package stack;/*
 *@author:
 *@time
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackTest {

    public static void main(String[] args) throws IOException {
        test02();

    }

    public static void test02() throws IOException {
        String input;
        String output;
        while (true){
            System.out.println("请输入数学表达式：");
            System.out.flush();
            input=getInput();
            if(input.equals("")) {
                break;
            }
            ConvertLam lam=new ConvertLam(input);
            output=lam.convert();
            System.out.println(output);
        }
    }
    public static void test01(){
        Stack stack=new Stack(20);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+"  ");
        }
    }

    public static String getInput()throws IOException{
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(reader);
        return bufferedReader.readLine();
    }
}
