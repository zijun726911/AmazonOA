package oa.lc901;

import java.util.Stack;

//monotonic stack
class StockSpanner {
    class Item{
        int price;
        int res;

        public Item(int price, int days) {
            this.price = price;
            this.res = days;
        }
    }

    Stack<Item> stack;
    public StockSpanner() {
        stack=new Stack<>();

    }
    //stack.peek() always be the minimum value
    public int next(int price) {
        int res=1;
        while (!stack.isEmpty()&&stack.peek().price<=price){
            res+=stack.pop().res;
        }
        stack.push(new Item(price,res));
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */