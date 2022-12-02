package bu;

public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, int value) {
		Node newNode = new Node(key, value);
		
		if(root==null) {
			root = newNode;
		}
		else {
			Node focusNode = root;
			
			Node parent;
			
			
			while(true) {
				parent = focusNode;
				
				if(key < focusNode.key) {
					focusNode = focusNode.left;
					
					if(focusNode==null) {
						parent.left = newNode;
						return;
					}
				}
				else {
					focusNode = focusNode.right;
					
					if(focusNode==null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inOrderTraverse(Node focusNode) {
		if(focusNode!=null) {
			inOrderTraverse(focusNode.left);
			
			System.out.println(focusNode);
			
			inOrderTraverse(focusNode.right);
			
			
		}
		
		
	}
	
	public Node find(int key) {
		Node focusNode = root;
		
		while(focusNode.key!=key) { // loop until key is found
			if(key<focusNode.key) { 
				focusNode = focusNode.left; // traverse tree down left side until node is found
			}
			else {
				focusNode = focusNode.right; // traverse tree down right side until node is found
			}
			if(focusNode==null) {
				return null;
			}
		}
		return focusNode;
	}
	public boolean remove(int key) {
		Node focusNode = root;
		Node parent = root; // always start at top of tree
		
		boolean isLeft = true; // if the leaf is not a left child leaf, we need to use a boolean to show that it is a right child leaf
		
		while(focusNode.key!=key) { // this while loop basically does what the find() method does. it looks for a specific key
			parent = focusNode;
			if(key<focusNode.key) {
				isLeft = true;
				
				focusNode = focusNode.left;
			}
			else {
				isLeft = false;
				focusNode = focusNode.right;
			}
			if(focusNode==null)
				return false; // if no key is found, returns null and nothing happens
		}
		if(focusNode.left == null && focusNode.right == null) { // this if statement handles the situation where the key node is found and the key node has no children
			if(focusNode == root) { // very unlikely case, but if there is only one value in the tree, the root is deleted
				root = null;
			}
			else if(isLeft) { //if the node is a left node, it is deleted
				parent.left = null;
			}
			else { // if the node is a right node, it is deleted
				parent.right = null;
			}
				
		}
		else if(focusNode.right==null) { // this else if handles the situation when there is a left child but no right child
			if(focusNode==root) { // if root is deleted, then the left child becomes the root
				root = focusNode.left;
			}
			else if(isLeft) { // if this is a left node, the left node moves up the tree
				parent.left = focusNode.left;
			}
			else { // if right node, left node replaces right node
				parent.right = focusNode.left;
			}
		}
		else if(focusNode.left==null) { // this else if handles situation where there is a right child but no left child
			if(focusNode==root) { // if root is deleted, right node replaces it
				root = focusNode.right;
			}
			else if(isLeft) { // if it is a left node, the right node replaces the parent's left node
				parent.left = focusNode.right;
			}
			else { // if it is a right node, the left node replaces the parent's right node
				parent.right = focusNode.left;
			}
		}
		else { // in the event that there are two children (both right and left) for a given key, we need to create a method to figure out the replacement
			Node replacement = getReplacementNode(focusNode); // call replacement method
			if(focusNode==root) { // replace root if root is deleted
				root = replacement;
			}
			else if(isLeft) { // if it is a left node, replace it with the replacement node
				parent.left = replacement;
			}
			else { // if it is a right node, replace it with replacement node
				parent.right = replacement;
			}
			replacement.left = focusNode.left;
		}
		
		return true; // finally return true since a node was successfully deleted
	}
	
	public Node getReplacementNode(Node replaced) { // replacement node method. requires the node that will be deleted to be passed in
		Node replacementParent = replaced; 
		Node replacement = replaced;
		Node focusNode = replaced.right; // since binary tree stores data in left to right ascending order, the right node (greater value) will replace the deleted node instead of the left
		
		while(focusNode!=null) {
			replacementParent = replacement;
			
			replacement = focusNode;
			
			focusNode = focusNode.left;
		}
		
		if(replacement!=replaced.right) {
			replacementParent.left = replacement.right;
			replacement.right = replaced.right;
		}
		return replacement; // after determining replacement, replacement is returned and replaces deleted node
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.addNode(50, 1);
		tree.addNode(99, 2);
		tree.addNode(847, 3);
		tree.addNode(56, 4);
		tree.addNode(991, 5);
		tree.addNode(12, 6);
		tree.addNode(72, 7);
		
		System.out.println("DELETE KEY 991 - VALUE 5 SHOULD NOT APPEAR");
		tree.remove(991);
		
		
		tree.inOrderTraverse(tree.root);
		
		System.out.println("Search for key 50");
		System.out.println(tree.find(50));
		System.out.println("Value 5 and its key 991, do not appear in traversal");
	}
}

class Node{
	int key;
	int value;
	
	Node left, right;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public String toString() {
		return value + " has a key of " + key;
	}
}
