class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(st.isEmpty() || asteroids[i]>0 ){
              st.push(asteroids[i]);
            }else{
                while(true){
                    int peek = st.peek();
                    if(peek<0){
                        st.push(asteroids[i]);
                        break;
                    }else if(peek == -asteroids[i]){
                        st.pop();
                        break;
                    }else if(peek > -asteroids[i]){
                        break;
                    }else{
                        st.pop();
                        if(st.isEmpty()){
                            st.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int[] res = new int[st.size()];
        for(int i = st.size()-1; i>=0; i--){
            res[i] = st.pop();
        }
         return res;
        }
    }
