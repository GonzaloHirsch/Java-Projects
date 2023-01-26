package interviewProblems.Advent_Of_Code_2022.Day_7.Part_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private long totalSize = 0;
    public long findTotalDirSize(String input, long limit) {
        this.totalSize = 0;
        Node root = this.buildTree(input);
        this.findSizeRecursive(root, limit);
        return this.totalSize;
    }

    private long findSizeRecursive(Node curr, long limit) {
        // Check if no children, terminal directory
        if (curr.children.isEmpty()) {
            // Add the file size to the total
            if (curr.fileSize <= limit) totalSize += curr.fileSize;
            return curr.fileSize;
        }
        // There are children to iterate
        long total = 0;
        for (Node node : curr.children.values()) total += this.findSizeRecursive(node, limit);
        // Check if within limit
        if (total + curr.fileSize <= limit) totalSize += total + curr.fileSize;
        return total + curr.fileSize;
    }

    private Node buildTree(String input) {
        Node root = new Node("/", null), curr = root, tmp;
        String[] lines = input.split("\n"), parts;
        for (String line : lines) {
            // Check if it's a command or not
            if (line.charAt(0) == '$') {
                // Check if command is CD
                if (line.charAt(2) == 'c' && line.charAt(3) == 'd') {
                    // Determine if it's diving up or down
                    parts = line.split(" ");
                    switch (parts[2]) {
                        case "/":
                            curr = root;
                            break;
                        case "..":
                            curr = curr.parent;
                            break;
                        default:
                            curr = curr.children.get(parts[2]);
                    }
                }
                // Cannot do anything if it's ls
            }
            // This will be the result of an LS
            else {
                parts = line.split(" ");
                // Listed line is a directory
                if (parts[0].equals("dir")) {
                    // Create the node with the path and parent
                    tmp = new Node(parts[1], curr);
                    // Add to the current node
                    curr.children.put(parts[1], tmp);
                }
                // Listed line is a file
                else if (!curr.files.contains(parts[1])) {
                    curr.files.add(parts[1]);
                    curr.fileSize += Long.parseLong(parts[0]);
                }
            }
        }

        return root;
    }

    private class Node {
        public String name;
        public long fileSize = 0;
        public Map<String, Node> children;
        public Set<String> files;
        public Node parent;
        public Node(String name, Node parent) {
            this.name = name;
            this.parent = parent;
            this.children = new HashMap<>();
            this.files = new HashSet<>();
        }
    }
}