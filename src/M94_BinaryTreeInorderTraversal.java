import sun.reflect.generics.tree.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Treenode{
    int val;
    Treenode left;
    Treenode right;
    Treenode (int value) { val = value; }
}
public class M94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(Treenode root) {
        Stack<Treenode> stack = new Stack<Treenode>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
