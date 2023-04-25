class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        sum = 0
        def dfs(node:TreeNode):
            nonlocal sum
            if node != None:
                if node.val >= low and node.val <= high:
                    sum += node.val
                    dfs(node.right)
                    dfs(node.left)
                elif node.val < low:
                    dfs(node.right)
                else:
                    dfs(node.left)
        
        dfs(root)
        return sum