package Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *      int label;
 *      List<UndirectedGraphNode> neighbors;
 *      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node, new HashMap<>());
    }

    public UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> visited) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.put(newNode.label, newNode);
        for (UndirectedGraphNode ugn : node.neighbors) {
            if (!visited.containsKey(ugn.label)) {
                newNode.neighbors.add(clone(ugn, visited));
            } else {
                newNode.neighbors.add(visited.get(ugn.label));
            }
        }
        return newNode;
    }

    public static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}

