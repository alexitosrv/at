public class LCA{
	
	
	private class BinaryTreeNode{
		int data;
		BinaryTreeNode left, right;
		
		BinaryTreeNode(int _d, BinaryTreeNode _left, BinaryTreeNode _right){
			
			data = _d;
			left = _left;
			right = _right;
		}
		
		@Override 
		public String toString(){
			return Integer.toString(data);
		}
	}

	public static BinaryTreeNode lca(BinaryTreeNode tree, BinaryTreeNode a, BinaryTreeNode b){
		
		if (tree == null){
			return null;
		}
		
		if (tree.data == a.data || tree.data == b.data)
			return tree;
		
		BinaryTreeNode l = lca(tree.left, a, b);
		BinaryTreeNode r = lca(tree.right, a, b);
		
		if (l == null)
			return r;
		
		if (r == null)
			return l;
		
		return tree;
	}

	public static void main (String [] args){
		
		LCA m = new LCA();
		
		BinaryTreeNode tree = m.new BinaryTreeNode(0, null, null);
		
		BinaryTreeNode n1 = m.new BinaryTreeNode(1, null, null);
		BinaryTreeNode n2 = m.new BinaryTreeNode(2, null, null);
		BinaryTreeNode n3 = m.new BinaryTreeNode(3, null, null);
		BinaryTreeNode n4 = m.new BinaryTreeNode(4, null, null);
		BinaryTreeNode n5 = m.new BinaryTreeNode(5, null, null);
		BinaryTreeNode n6 = m.new BinaryTreeNode(6, null, null);
		
		n4.left = n3;
		n4.right = n5;
		
		n5.left = n6;
		
		n3.left = n1;
		n3.right = n2;
		
		/*
		
		    4
	     3     5
	   1   2      6	 

		*/
	

		System.out.println(lca(n4, n1, n6));
	}


}