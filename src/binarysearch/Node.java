package binarysearch;

public class Node {
	private String data;
	private Node left;
	private Node right;
	
	public Node(String data){
		this.data = new String(data);
		this.left = null;
		this.right = null;
	}
	
	public String getData() { return this.data; }
	public Node getLeftChild() { return this.left; }
	public Node getRightChild() { return this.right; }
	
	public void setData(String data) { this.data = data; }
	public void setLeftChild(Node node) { this.left = node; }
	public void setRightChild(Node node) { this.right = node; }
	
	public int compareTo(String data){
		int res = this.data.compareTo(data);
		if(res < 0) return -1;
		if(res > 0) return 1;
		return 0;
	}
	
	public String toString(){
		return "Node value: " + this.data;
	}
	
}
