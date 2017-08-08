package binarysearch;

import java.util.ArrayList;

public class BinarySearchTree {
	private Node root;
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public Node getRoot() { return this.root; }
	
	public boolean isEmpty(){ return this.root == null; }
	
	public void destroy(){ this.root = null; }
	
	public int depth(Node root){
		if(root == null) return 0;
		if(depth(root.getLeftChild()) > depth(root.getRightChild()) ){
			return depth(root.getLeftChild()) + 1;
		}
		return depth(root.getRightChild()) + 1;
	}
	
	public void buildNodeAL(Node root, ArrayList<Node> node_arr){
		if(root == null) return;
		buildNodeAL(root.getLeftChild(), node_arr);
		node_arr.add(root);
		buildNodeAL(root.getRightChild(), node_arr);
	}
	
	public Node buildBalancedBST(ArrayList<Node> node_arr, int left, int right){
		if(left > right) return null;
		int midpoint = (left + right) / 2;
		Node mid_node = node_arr.get(midpoint);
		mid_node.setLeftChild(buildBalancedBST(node_arr, left, midpoint - 1));
		mid_node.setRightChild(buildBalancedBST(node_arr, midpoint + 1, right));
		return mid_node;
	}
	
	public Node balance(Node root){
		ArrayList<Node> node_arr = new ArrayList<Node>();
		buildNodeAL(root, node_arr);
		Node node = buildBalancedBST(node_arr, 0, node_arr.size() - 1);
		return node;
	}

	public Node insert(Node root, String data){
		Node new_node = new Node(data);
		if(root == null){
			System.out.println("------");
			balance(root);
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
	
	public void insert(String data){ this.root = insert(root, data); }
	
	public Node search(Node root, String data){
		if(root == null) return root;
		if(root.getData().equals(data)) return root;
		if(root.compareTo(data) > 0) return search(root.getLeftChild(), data);
		return search(root.getRightChild(), data);
	}
	
	public String inOrderSuccessor(Node root){
		String in_or_success = root.getData();
		while(root.getLeftChild() != null){
			Node left = root.getLeftChild();
			in_or_success = left.getData();
			root = root.getLeftChild();
		}
		return in_or_success;
	}
	
	public Node delete(Node root, String data){
		if(root == null) return root;
		if(root.getData().compareTo(data) > 0){
			root.setLeftChild(delete(root.getLeftChild(), data));
		}
		if(root.getData().compareTo(data) < 0){
			root.setRightChild(delete(root.getRightChild(), data));
		}
		if(root.getData().compareTo(data) == 0){
			if(root.getLeftChild() == null) return root.getRightChild();
			else if(root.getRightChild() == null) return root.getLeftChild(); // both cases for 0-1 children
			root.setData(inOrderSuccessor(root.getRightChild()));
			root.setRightChild(delete(root.getRightChild(), root.getData()));
		}
		return root;
	}
	
	public Node delete(String data){ return delete(this.root, data); }
	
	public void print(Node root, int mode){
		if(mode == 0){ // print in-order 
			if(root == null) return;
			print(root.getLeftChild(), 0);
			System.out.println(root.toString());
			print(root.getRightChild(), 0);	
		}
		if(mode == 1){ // print pre-order
			if(root == null) return;
			System.out.println(root.toString());
			print(root.getLeftChild(), 1);
			print(root.getRightChild(), 1);
			
		}
		if(mode == 2){ // print post-order
			if(root == null) return;
			print(root.getLeftChild(), 2);
			print(root.getRightChild(), 2);
			System.out.println(root.toString());
			
		}
	}
	
}
