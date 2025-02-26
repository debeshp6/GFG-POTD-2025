
class Solution {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public Solution() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto stack
    public void push(int x) {
        mainStack.push(x);
        // Push to minStack if it is empty or x is the new minimum
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Remove top element from stack
    public void pop() {
        if (!mainStack.isEmpty()) {
            int removed = mainStack.pop();
            // If popped element is the minimum, remove it from minStack too
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    // Return top element of stack
    public int peek() {
        return mainStack.isEmpty() ? -1 : mainStack.peek();
    }

    // Get the minimum element in stack
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
