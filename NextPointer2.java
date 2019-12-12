package com.algorimthms;

public class NextPointer2 {

}

class NextPointer2Solution{
	public TreeNodeNext connect(TreeNodeNext root) {
		TreeNodeNext curt = root;
		while(curt!=null) {
			TreeNodeNext dummy = new TreeNodeNext(0);
			TreeNodeNext curtDummy = dummy;
			for(TreeNodeNext p = curt;p!=null;p=p.next) {
				if(p.left!=null) {
					curtDummy.next = p.left;
					curtDummy = curtDummy.next;
				}
				if(p.right!=null) {
					curtDummy.next = p.right;
					curtDummy=curtDummy.next;
				}
			}
			curt = dummy.next;
		}
		return root;
	}
}
