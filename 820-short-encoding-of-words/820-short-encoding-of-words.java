class Solution {
    static class Node {
		char data;
		Map<Character, Node> childs;

		Node(char data) {
			this.data = data;
			childs = new HashMap<>();
		}

		public Node addChild(char data) {
			if (!childs.containsKey(data))
				childs.put(data, new Node(data));
			return childs.get(data);
		}

		public Node getChild(char data) {
			return childs.get(data);
		}
	}

	public void formTrie(Node node, String word, int idx) {
		if (idx == -1)
			return;
		formTrie(node.addChild(word.charAt(idx)), word, idx - 1);
	}

	public boolean containsWord(Node node, String word, int idx) {
		if (idx == -1)
			return true;
		node = node.getChild(word.charAt(idx));
		if (node == null)
			return false;
		return containsWord(node, word, idx - 1);
	}

	public int minimumLengthEncoding(String[] words) {
		Node root = new Node('\0');
		int len = 0;
        
		Arrays.sort(words, (a, b) -> b.length() - a.length());

		for (String word : words) {
			if (!containsWord(root, word, word.length() - 1)) {
				formTrie(root, word, word.length() - 1);
				len += (word.length() + 1);
			}
		}

		return len;
	}
}