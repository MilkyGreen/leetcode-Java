public class Solution {
    public boolean canMeasureWater(int x, int y, int t) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        Set<Long> seen = new HashSet<>();
        while(stack.size() > 0){
            int[] state = stack.pop();
            if(seen.contains(hash(state[0],state[1]))){
                continue;
            }
            seen.add(hash(state[0],state[1]));
            if(state[0] == t || state[1] == t || Math.abs(state[0] - state[1]) == t || state[0] + state[1] == t){
                return true;
            }
            int remainX = state[0];
            int remainY = state[1];
            stack.push(new int[]{x,remainY});
            stack.push(new int[]{remainX,y});
            stack.push(new int[]{0,remainY});
            stack.push(new int[]{remainX,0});

            stack.push(new int[]{remainX - Math.min(remainX,y - remainY),remainY + Math.min(remainX,y - remainY)});
            stack.push(new int[]{remainX + Math.min(remainY,x - remainX),remainY - Math.min(remainY,x - remainX)});
            
        }
        return false;
    }

    long hash(int remainX,int remainY){
        return (long) remainX * 1000001 + remainY;
    }
}
