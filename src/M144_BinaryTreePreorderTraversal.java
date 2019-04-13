import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class M144_BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(Treenode root) {
        List<Integer> list = new ArrayList<>();
        Stack<Treenode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            } else
                return list;
        }
        return list;
    }

    public static void main(String[] args){
        Treenode root = new Treenode(0);
        Treenode node1 = new Treenode(1);
        Treenode node2 = new Treenode(2);
        Treenode node3 = new Treenode(3);
        Treenode node4 = new Treenode(4);
        Treenode node5 = new Treenode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        List<Integer> res = new ArrayList<>();
        res = preorderTraversal(root);

        Iterator iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
