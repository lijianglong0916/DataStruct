package stack;/*
 *@author:
 *@time
 */

public class ConvertLam {
    private CharSetStack stack;
    private String inPut;
    private String outPut;
    private int size;
    public ConvertLam(String lam){
        inPut = lam;
        size=inPut.length();
        stack=new CharSetStack(size);
        outPut="";
    }
    public String convert(){

        for (int i=0;i<inPut.length();i++){
            char ch=inPut.charAt(i);
            switch (ch){
                case '+':
                case '-':
                    getOper(ch,1);
                    break;
                case '*':
                case '/':
                    getOper(ch,2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    getParent(ch);
                default:
                    outPut+=ch;
            }
        }
        while(!stack.isEmpty()){
//            stack.disPlay();
            outPut+=stack.pop();
        }
        return outPut;
    }

    private void getParent(char ch) {
        while (!stack.isEmpty()){
            char a=stack.pop();
            if(a=='('){
                break;
            }else{
                outPut+=stack.pop();
            }
        }
    }

    private void getOper(char ch, int level) {
        while(!stack.isEmpty()){
            char topData=stack.pop();
            if(topData=='('){
                stack.push(topData);
                break;
            }
            else {
                int levelT;
                if(topData=='+'||topData=='-')
                    levelT=1;
                else
                    levelT=2;
                if(levelT<level){
                    stack.push(topData);
                    break;
                }else {
                    outPut+=topData;
                }
            }
        }
        stack.push(ch);
    }
}
