package binarysearch;

public class BinarySearchTree {
	private Node root;
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public Node getRoot() { return this.root; }
	
	public Node insert(Node root, String data){
		Node new_node = new Node(data);
		if(root == null){
			System.out.println("------");
			return new_node;
		}
		if(root.getData().compareTo(data) > 0){
			System.out.println("GOING LEFT OF " + root.getData());
			root.setLeftChild(insert(root.getLeftChild(), data));
		}
		else if(root.getData().compareTo(data) < 0){
			System.out.println("GOING RIGHT OF " + root.getData());
			root.setRightChild(insert(root.getRightChild(), data));
		}
		else {
			root.setData(data);
		}
		return root;
	}
	
	public void insert(String data){
		this.root = insert(root, data);
	}
	
	public void printInOrder(Node root){
		if(root == null) {
			return;
		}
		printInOrder(root.getLeftChild());
		System.out.println(root.toString());
		printInOrder(root.getRightChild());	
	}
	
	public boolean isEmpty(){
		return this.root == null;
	}
	
}
