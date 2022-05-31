//Sinan Hacisoyu
//119200060

public class Assigment06 {
	
	class Node{
		int data;
		Node right;
		Node left;
		
		public Node(int data) {
			this.data=data;
			right=null;
			left=null;
		}
	}
	
	Node root; // en önemli node
	
	public Assigment06() {
		root = null;
	}
	
	Node newNode(int data) {
		root = new Node(data); //roota(aðaca) data eklendi
		System.out.println(data);
		return root;
		
	}
	
	Node insert(Node root, int data) {
		if( root!= null) { // rootta eleman varsa
			if(data < root.data) // sola ekleme kýsmý
				root.left=insert(root.left, data);
			else //saða ekleme kýsmý
				root.right = insert(root.right,data);	
		}
		else //root boþsa datayý oraya ekle
			root = newNode(data);
		return root; // geri dönüþ deðeri - node tipinde
	}
	
	
	//Question 2
	int minvalue(Node node) {
		Node current = node;
		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return (current.data);
	}
	
	
	//Question 3
	static int maxValue(Node node){
	    if (node.right == null)
	        return node.data;
	    return maxValue(node.right);
	}
	
	//Question 4
	static int maxDepth(Node node){
        if (node == null)
            return -1;
        else{
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }
	
	 static int prev = Integer.MIN_VALUE;
    // Utility function to check if Binary Tree is BST
    static boolean isBSTUtil(Node root)
    {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null) {
            if (!isBSTUtil(root.left))
                return false;
 
            // Allows only distinct valued nodes
            if (root.data <= prev)
                return false;
 
            // Initialize prev to current
            prev = root.data;
 
            return isBSTUtil(root.right);
        }
 
        return true;
    }
    
	public static void main(String[] args) {
		Assigment06 b = new Assigment06();
		
		//insert methodunun geri dönüþ deðeri var (return kýsmý) 
		// so b.root ile bu deðeri tutuyoruz
		b.root = b.insert(b.root, 32);
		b.root = b.insert(b.root, 41);
		b.root = b.insert(b.root, 24);
		b.root = b.insert(b.root, 58);
		b.root = b.insert(b.root, 46);
		b.root = b.insert(b.root, 27);
		b.root = b.insert(b.root, 12);
		b.root = b.insert(b.root, 14);

		System.out.println("root= " + b.root.data);
		
		System.out.println("Minimum value of BST is " + b.minvalue(b.root));
		System.out.println("Maximum value is " + maxValue(b.root));
		
		if (isBSTUtil(b.root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
    
		System.out.println("Height of tree is " +b.maxDepth(b.root));
	}
}