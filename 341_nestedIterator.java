// 341. Flatten Nested List Iterator

// Given a nested list of integers, implement an iterator to flatten it.

// Each element is either an integer, or a list -- whose elements may also be integers or other lists.

// Example 1:

// Input: [[1,1],2,[1,1]]
// Output: [1,1,2,1,1]
// Explanation: By calling next repeatedly until hasNext returns false, 
//              the order of elements returned by next should be: [1,1,2,1,1].
// Example 2:

// Input: [1,[4,[6]]]
// Output: [1,4,6]
// Explanation: By calling next repeatedly until hasNext returns false, 
//              the order of elements returned by next should be: [1,4,6].

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// // This only works for cases when no empty list at the end of list
// public class NestedIterator implements Iterator<Integer> {
//     Iterator<NestedInteger> iterator;
//     Stack<Iterator<NestedInteger>> stack;
    
//     public NestedIterator(List<NestedInteger> nestedList) {
//         stack = new Stack<>();
//         iterator = nestedList.iterator();
//     }

//     @Override
//     public Integer next() {
//         if (!iterator.hasNext()) {
//             iterator = stack.pop();
//         }
//         NestedInteger next = iterator.next();
//         while (!next.isInteger()) {
//             if (next.getList().size() == 0) {
//                 next = iterator.next();
//                 continue;
//             }
//             if (iterator.hasNext()) stack.push(iterator);
//             iterator = next.getList().iterator();
//             next = iterator.next();
//         }
//         return next.getInteger();
//     }

//     @Override
//     public boolean hasNext() {
//         return (!stack.empty() || iterator.hasNext());
//     }
// }

public class NestedIteratorBetter implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    
    public NestedIteratorBetter(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            NestedInteger next = stack.peek();
            if (next.isInteger()) {
                return true;
            } else {
                List<NestedInteger> list = stack.pop().getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }
}



// This works but it defeats the purpose of iterator;
public class NestedIterator implements Iterator<Integer> {
    List<Integer> result;
    Iterator<Integer> iterator;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        result = new ArrayList<>();
        traverse(nestedList);
        iterator = result.iterator();
    }
    
    private void traverse(List<NestedInteger> nestedList) {
        for (NestedInteger n: nestedList) {
            if (n.isInteger()) {
                result.add(n.getInteger());
            } else {
                traverse(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */