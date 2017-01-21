
import java.util.*;

public class c {

	public static int n;
	public static int k;
	public static node[] trees;

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		n = stdin.nextInt();
		k = stdin.nextInt();
		trees = new node[n];

		// Read in each tree and form each tree.
		for (int i=0; i<n; i++) {
			int root = stdin.nextInt();
			trees[i] = new node(root);
			for (int j=1; j<k; j++) {
				int item = stdin.nextInt();
				trees[i].insert(item);
			}
		}

		// The first tree must be unique.
		int res = 1;

		// Test each other tree.
		for (int i=1; i<n; i++) {

			boolean countIt = true;

			// If this tree is like one of the ones before, we don't count it.
			for (int j=0; j<i; j++) {
				if (trees[i].sameStructure(trees[j])) {
					countIt = false;
					break;
				}
			}

			// Count only if this is new.
			if (countIt) res++;

		}

        // Here is our result.
		System.out.println(res);
	}
}

class node {

	public int x;
	public node left;
	public node right;

	public node(int val) {
		x = val;
		left = null;
		right = null;
	}

	public int numNull() {
		if (left == null && right == null) return 2;
		if (left == null || right == null) return 1;
		return 0;
	}

	// Standard recursive insert function.
	public void insert(int item) {
		if (item < x) {
			if (left == null) left = new node(item);
			else left.insert(item);
		}
		else {
			if (right == null) right = new node(item);
			else right.insert(item);
		}
	}

	// Returns true iff this and other have the same structure.
	public boolean sameStructure(node other) {

		// One node case match.
		if (numNull() == 2 && other.numNull() == 2) return true;

		// nulls have to be consistent!
		if (numNull() != other.numNull()) return false;
		if (numNull() == 1 && ((left == null && other.left != null) || (right==null && other.right != null)))
			return false;

		// Both non-null sides must match...
		boolean result = true;
		if (left != null) result = result && left.sameStructure(other.left);
		if (right != null) result = result && right.sameStructure(other.right);
		return result;
	}
}
