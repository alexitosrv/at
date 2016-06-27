import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

class BSTree{
	Node root;
	
	private class Node{
		Integer key;
		Node left;
		Node right;
		
		public Node(int i){
			key = i;
			left = right = null;
		}
	}
	
	public void insert(Integer d){
		
		Node n = new Node(d);
		
		if (root == null){
			root = n;
			return;
		}
		
		Node ptr = root;
		int cmp; 
		
		while(ptr != null){
			
			cmp = Integer.compare(n.key, ptr.key);
			
			if (cmp < 0) {
				if (ptr.left == null){
					ptr.left = n;
					return;
				}
				ptr = ptr.left; 
			}
			if (cmp > 0) { 
				if (ptr.right == null){
					ptr.right = n;
					return;
				}
				ptr = ptr.right; 
			}
			if (cmp == 0) { return; }
		}
		
	/*
	   2
	  1 3
	  
	  2 vs 4
	  
	  
	*/
		
		
			
	}
	
	public void delete(Integer d){
		// search for d
		
		Node ptr = root;
		Node parent = null;
		int left_or_right_parent = 0;
		
		
		while(ptr!=null){
			
			parent = ptr;
			
			int comp = Integer.compare(d, ptr.key);	
			
			if(comp==0){
				System.out.println("encontrado");
				
				break;
			}
			if(comp<0){
				parent = ptr;
				ptr = ptr.left;
				left_or_right_parent = -1;
			}
			if(comp>0){}
				parent = ptr;
				ptr = ptr.right;
				left_or_right_parent = 1;
		}
		
		if (ptr == null){
			return; // the item does not exist here
		}
		
		// if ptr is a leaf:
		if (ptr.right == null && ptr.left == null){
			if (left_or_right_parent < 0){
				parent.left = null;
			}
			else if (left_or_right_parent >0){
				parent.right = null;
			}
			return;
		}
		
		// else if ptr has right or left subtree what to do with them?
		if (ptr.right != null){
			// find the lowest of the right subtree:
			Node pR = ptr;
			Node r = ptr.right;
			
			while(r.left!=null){
				pR = r;
				r = r.left;
			}
			
			ptr.key = r.key;
			
			if(pR.left == r){ // al abuelo (pR), le asigno el subarbol de la derecha de r en la izq
				pR.left = r.right;
			}else {
				pR.right = r.right; // al abuelo pR le asigno en la derecha el subarbol derecho de r
			}
			
			r.right = null;
		}else{
			if (root == ptr){
				root = ptr.left;
				ptr.left = null;				
			}else{
				if(parent.left == ptr){
					parent.left = ptr.left;
				}else{
					parent.right = ptr.left;
				}
				ptr.left = null;
			}
		}
			
	}
	
	@Override
	public final String toString(){
		return inOrder(root);
	}
	
	
	public String inOrder(Node b){
		if (b==null)
			return "";
		
		return (inOrder(b.left) + " " + b.key + " " + inOrder(b.right));
	}
	
	
}

public class T{
	
	public static void main(String [] arg){
		
		int[][] x = new int[][]{{1,1},{2,2},{3,3}};
		 int[][] twoDim = { {1, 2}, {3, 7}, {8, 9}, {4, 2}, {5, 3} };
		 
		Integer[] w = new Integer []{1,3,4,6,3,12,5};
		
	
		Arrays.sort(w, new Comparator<Integer>(){
			@Override
			public int compare(Integer x, Integer y){
				return -1;
			}
		});
		//Integer i = Integer.valueOf("1");
		//String ii = String.valueOf(1);
		//BSTree a = new BSTree();
		//Random r = new Random();
		//r.nextInt();
		////System.out.println(Integer.compare(1,2));
		//a.insert(2);
		//a.insert(1);
		//a.insert(3);
		//a.insert(4);
		//System.out.println("my tree:");
		//System.out.println(a);
		//
		//a.delete(3);
		//System.out.println("my tree after deletion:");
		//System.out.println(a);
		//
	}
	
	
	
}