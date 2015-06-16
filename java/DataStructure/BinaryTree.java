/**
 * This is a class implementation for a binary search tree.
 * @version 1.1
 * @author luca
 * */
public class BinaryTree {

	private Node root;
	
	public static void main(String [] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(7);
		bt.insert(2);
		bt.insert(1);
		bt.insert(4);
		bt.delete(2);
		printTraverse(bt.root);
		System.out.println();
		bt.delete(4);
		bt.insert(6);
		bt.insert(8);
		bt.insert(9);
		printTraverse(bt.root);
		System.out.println("Bummer");
		bt.delete(5);
		printTraverse(bt.root);
		System.out.println();
	}

	public BinaryTree() {
		this.root = null;
	}
	
	public static void printTraverse(Node N) {
		if(N == null) return;
		printTraverse(N.left);
		System.out.print(N.value + " ");
		printTraverse(N.right);
	}
	
	//insertion is simple, 
	//First we check if the value of the number we want to insert is already exist
	//if it's already exist: return void.
	public void insert(int value) {
		if(this.root == null) {
			this.root = new Node(value);
			return;
		} else {
			Node par = null;
			Node curr = this.root;
			while(curr!= null) {
				if(curr.value < value) {
					par = curr;
					curr = curr.right;
				} else if (curr.value > value) {
					par = curr;
					curr = curr.left;
				} else {
					return;
				}
			}
			if(par.value < value) {
				par.right = new Node(value);
			} else {
				par.left = new Node(value);
			}
		}
	}
	
	public Node search(int value) {
		Node curr = this.root;
		while(curr != null) {
			if(curr.value == value) {
				return curr;
			} else if(curr.value < value) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		//search is not found
		return null;
	}
	
	
	//deletion is a bit tricky. 
	//we need to search the item first and apply the rule based on the children of the node that need to be deleted.
	//2 children
	//1 child, either left or right
	//no child
	public boolean delete(int value) {
		Node par = null;
		Node curr = this.root;
		while(curr != null) {
			if(curr.value == value) {
				break;
			} else if(curr.value < value) {
				par = curr;
				curr = curr.right;
			} else {
				par = curr;
				curr = curr.left;
			}
		}
		if(curr == null) return false;
		//if the node has two child
		//find the maximum value of left child
		Node tmp = new Node(curr.value);
		if(curr.left !=null && curr.right != null) {
			par = curr;
			Node y = curr.right;
			while(y.right!= null) {
				par = y;
				y = curr.right;
			}
			curr.value = y.value;
			curr = y;
		}
		if(par == null) {
			//this is the root element;
			this.root =null;
		}
		//for node with left/right child
		if(curr.left == null && curr.right != null) {
				if(par.value < curr.value) {
					par.right = curr.right;
				} else {
					par.left = curr.right;
				}
		} else if (curr.left != null && curr.right == null) {
				if(par.value < curr.value) {
					par.right = curr.left;
				} else {
					par.left = curr.left;
				}		
		} else { //no child
				if(tmp.value < curr.value) {
					par.right = null;
				} else {
					par.left = null;
				}	
			
		}
		return true;
	}
	
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}


	static class Node {
		private int value;
		private Node left;
		private Node right;
		
   		public Node(int v) {
			this.value = v;
			left = null;
			right = null;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.value);
		}
	}
}


