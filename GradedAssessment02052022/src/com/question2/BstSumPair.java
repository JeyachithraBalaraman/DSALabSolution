package com.question2;
// Jeyachithra Balaraman- Find a pair with a given sum in Binary Search Tree 
import java.util.HashSet;

// BST node
class Node {
	int key;
	Node left, right;
};

public class BstSumPair {
// creation of new node
	
	static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

//Insertion of nodes
	public Node insert(Node root,int key) {
		if(root==null)
			return newNode(key);
		if(key<root.key)
			root.left=insert(root.left,key);
		else
			root.right=insert(root.right,key);
		return root;
	}
	//Inorder printing of BST
	public void Inorder(Node root) {
		if (root == null)
			return;
		else {
			Inorder(root.left);
			System.out.print(root.key + " ");
			Inorder(root.right);
		}
	}
// Finding Node pairs
	static boolean findPair(Node root, int sum, HashSet<Integer> set) {
		
		if (root == null)
			return false;
		if (findPair(root.left, sum, set))
			return true;
		if (set.contains(sum - root.key)) {
			System.out.println("Pair(" + (sum - root.key) + "," + root.key + ") is found for Sum = "+sum);
			return true;
		} else
			set.add(root.key);
		return findPair(root.right, sum, set);
	}
// Finding NodePairs for given sum
	public void PairWithSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPair(root, sum, set))
			System.out.println("Pairs do not exit");
	}
// Driver code
	public static void main(String[] args) {
		Node root = null;
		BstSumPair sumPair = new BstSumPair();
		root = sumPair.insert(root, 40);
		root = sumPair.insert(root, 20);
		root = sumPair.insert(root, 60);
		root = sumPair.insert(root, 90);
		root = sumPair.insert(root, 30);
		root = sumPair.insert(root, 100);
		root = sumPair.insert(root, 70);
		System.out.println("Given Binary Tree");
		sumPair.Inorder(root);
		System.out.println();
		int sum = 80;
		sumPair.PairWithSum(root, sum);

	}
}