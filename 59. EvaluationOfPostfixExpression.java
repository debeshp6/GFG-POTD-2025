

class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            
            if(arr[i].equals("+")){
                int b= st.pop();
                int a=st.pop();
                int temp=a+b;
                st.push(temp);
            }else if(arr[i].equals("-")){
                int b=st.pop();
                int a=st.pop();
                int temp=a-b;
                st.push(temp);
                
            }else if(arr[i].equals("*")){
                int b=st.pop();
                int a=st.pop();
                int temp=a*b;
                st.push(temp);
                
            }else if(arr[i].equals("/")){
                int b=st.pop();
                int a=st.pop();
                int temp=a/b;
                st.push(temp);
                
            }else{
                int a=Integer.parseInt(arr[i]);
                st.push(a);
            }
        }
        return st.peek();
    }
}
