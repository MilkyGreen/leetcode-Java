class Solution:

    

    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        sum = 0
        def dfs(node):
            nonlocal sum
            if node != None:
                dfs(node.right)
                v = node.val
                sum += v
                node.val = sum
                
                dfs(node.left)
        
        dfs(root)

        return root

    