package top_interview_150.binary_tree_general.easy
class TreeNode100(var `val`: Int) {
    var left: TreeNode100? = null
    var right: TreeNode100? = null
}
class Solution100 {
    fun isSameTree(p: TreeNode100?, q: TreeNode100?): Boolean {
        if (p == null && q == null) return true

        return (p?.`val` == q?.`val`) && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}