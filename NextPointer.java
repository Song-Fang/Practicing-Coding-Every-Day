package com.algorimthms;

public class NextPointer {

}

class NextPointerSolution{
	public TreeNodeNext connect(TreeNodeNext root) {
		if(root==null) {
			return null;
		}
		
		TreeNodeNext dummy = new TreeNodeNext(0);
		TreeNodeNext curt = dummy;
		TreeNodeNext p = root;
		while(p!=null) {
			if(p.left!=null) {
				curt.next = p.left;
				curt = curt.next;
			}
			if(p.right!=null) {
				curt.next = p.right;
				curt = curt.next;
			}
			p = p.next;
		}
		connect(dummy.next);
		return root;
	}
}


class TreeNodeNext{
	int val;
	TreeNodeNext next;
	TreeNodeNext left;
	TreeNodeNext right;
	
	public TreeNodeNext(int val) {
		super();
		this.val = val;
	}
	
	
	
}
