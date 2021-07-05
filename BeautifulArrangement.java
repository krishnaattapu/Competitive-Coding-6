// Time Complexity : O(N pow 2)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * 1. Maintain a visited map to find already existing values
 * 2. similar to other for loop recursion but here for each element loop will go through 0 to n.
 * 3. if any element is not beautiful return. 
 * 4. if it reaches end of list then increment count;
 */

import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangement {
	int count;

	public int countArrangement(int n) {
		count = 0;
		cal(n, 1, new HashSet<Integer>());
		return count;
	}

	private void cal(int n, int index, Set<Integer> visited) {
		// base
		if (visited.size() != 0 && index % visited.size() != 0 && visited.size() % index != 0)
			return;
		if (visited.size() == n) {
			count++;
			return;
		}

		// logic
		for (int i = 1; i <= n; i++) {
			if (!visited.contains(i)) {
				// action
				visited.add(i);
				// recur
				cal(n, i, visited);
				// backtrack
				visited.remove(i);
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(new BeautifulArrangement().countArrangement(3));
	}
}
