package p200.p155;

import java.util.ArrayList;
import java.util.List;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
public class Solution {

    class MinStack {

        class Node{
            int val;
            Node next;
            int min; // 记录改节点于后面元素的最小值

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }

            public Node() {
            }

            public Node(int val) {
                this.val = val;
            }
        }

        Node data;

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            if(data == null){
                data = new Node(x,x);
            }else {
                Node newData = new Node(x);
                newData.next = data;
                // 新值每次与之前最小值比较，更小的当做改节点最小值
                newData.min = Math.min(data.min,x);
                data = newData;
            }
        }

        // 移除操作不用考虑最小值问题，每个节点已经记录了自己和后面的最小值，移除只会移除前面的节点，自己和后面的节点无关
        public void pop() {
            data = data.next;
        }

        public int top() {
            return data.val;
        }

        public int getMin() {
            return data.min;
        }
    }

}
