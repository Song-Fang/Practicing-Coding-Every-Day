package com.algorimthms;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedList {

}

interface NestedInteger{
	public boolean isInteger();
	
	public Integer getInteger();
	
	public List<NestedInteger> getList();
	
}

class NestedIterator implements Iterator<Integer>{
	
	private Stack<NestedInteger> stack;
	
	private void pushListToStack(List<NestedInteger> nestedList) {
		Stack<NestedInteger> buffer = new Stack<NestedInteger>();
		for(NestedInteger nested:nestedList) {
			buffer.push(nested);
		}
		
		while(buffer.isEmpty()) {
			stack.push(buffer.pop());
		}
		
		while(!stack.isEmpty()&&!stack.peek().isInteger()) {
			pushListToStack(stack.pop().getList());
		}
	}
	
	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<NestedInteger>();
		pushListToStack(nestedList);
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		return !stack.isEmpty();
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		while(hasNext()) {
		return stack.pop().getInteger();
		}
		return null; 
	}
	
	
}
