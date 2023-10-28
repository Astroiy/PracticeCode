package DataStructuresAndAlgorithm.Tree;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class DepthOfBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 把一个二叉树化成数组，把每一层级按照从左到右放入数组中
    public static void tree2Array(TreeNode node,int[] target) {


    }

    static class Solution {
        // 二叉树深度
        public int maxDepth(TreeNode root) {
            // 前序遍历，返回最大层数
            return preTraverse(root,0);
        }

        public int preTraverse(TreeNode root,int depth) {
            if (root == null) {
                return depth;
            }
            depth++;
            int leftDep = preTraverse(root.left,depth);
            int rightDep = preTraverse(root.right,depth);

            return Math.max(leftDep,rightDep);
        }

        // 相同二叉树
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 相同的树，每一个左子树和右子树都是相同的。在遍历过程中比较即可
            if ((p != null && q != null && q.val != p.val) ||
                    (p == null && q != null) ||
                    (p != null && q == null)) {
                return false;
            } else if (p == q) {
                return true;
            }
            else {
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
        }

        //反转二叉树
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 也就是翻转根节点下的左右子树
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        // 对称二叉树
        public boolean isSymmetric(TreeNode root) {
            // 左子树的左节点等于右子树的右节点，右节点等于左节点
            return check(root,root);
        }

        public boolean check(TreeNode p,TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
        }

        // 广度优先遍历，将树变为数组
        public int[] traverse(TreeNode p) {
            if (p == null) {
                return new int[0];
            }

            ArrayList<Integer> temp = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            // 放入根节点
            queue.offer(p);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            temp = temp.stream().filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
            int[] result = new int[temp.size()];
            for (int i=0; i< temp.size(); i++) {
                result[i] = temp.get(i);
            }
            return result;
        }

        public boolean hasPathSum(TreeNode root, int targetSum) {
            // 遍历到每一个叶子节点时，比较一下路径和值和目标值
            // 深度优先
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    return true;
                } else {
                    return false;
                }
            }
            return hasPathSum(root.left,targetSum - root.val) ||
                    hasPathSum(root.right,targetSum - root.val);

        }


    }
    public static void main(String[] args) {
        // 验证广度优先遍历
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        Solution solution = new Solution();
        int[] result = solution.traverse(root);
        System.out.println(Arrays.toString(result));
    }

    public boolean hasPathSumV2(TreeNode root, int targetSum) {
        // 遍历到每一个叶子节点时，比较一下路径和值和目标值
        // 广度优先
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 得有一个和值的跟踪队列，表示每个node对应的剩下的和值是多少
        Queue<Integer> sumQueue = new LinkedList<Integer>();
        queue.offer(root);
        sumQueue.offer(targetSum);
        while (!queue.isEmpty()) {
            // 每一次循环必须遍历每一层
            int size = queue.size();
            while (size > 0) {
                TreeNode p = queue.poll();
                Integer curSum = sumQueue.poll();
                if (p.left == null && p.right == null && p.val == curSum) {
                    return true;
                }
                if (p.left != null) {
                    queue.offer(p.left);
                    sumQueue.offer(curSum - p.val);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                    sumQueue.offer(curSum - p.val);
                }
                size--;
            }
        }
        return false;
    }

    public boolean hasPathSumV3(TreeNode root, int targetSum) {
        // 遍历到每一个叶子节点时，比较一下路径和值和目标值
        // 广度优先
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 得有一个和值的跟踪队列，表示每个node对应的剩下的和值是多少
        Queue<Integer> sumQueue = new LinkedList<Integer>();
        queue.offer(root);
        sumQueue.offer(targetSum);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            Integer curSum = sumQueue.poll();
            if (p.left == null && p.right == null && p.val == curSum) {
                return true;
            }
            if (p.left != null) {
                queue.offer(p.left);
                sumQueue.offer(curSum - p.val);
            }
            if (p.right != null) {
                queue.offer(p.right);
                sumQueue.offer(curSum - p.val);
            }
        }
        return false;
    }

    public int countNodes(TreeNode root) {
        // 完全二叉树的子树也是完全二叉树
        if (root == null) {
            return 0;
        }
        int leftSubTree = countNodes(root.left);
        int rightSubTree = countNodes(root.right);

        return leftSubTree + rightSubTree + 1;
    }


}
