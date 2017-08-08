package binarysearch;

public class BSTDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert("Vale");
		bst.insert("Sash");
		bst.insert("Shea");
		bst.insert("Aja");
		
		bst.printInOrder(bst.getRoot());
		
	}

}
