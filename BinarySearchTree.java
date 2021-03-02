// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   int insertOpCount = 0;
   int opCount = 0;
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) <= 0)
      {
         insertOpCount++;
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   public BinaryTreeNode<dataType> find ( dataType d )
   {   
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      
      //System.out.println(d+" ||||| "+node.data);
      String s = (String)node.data.toString();
      String stageAreaTime = s.substring(0, s.indexOf(" "));
      
      
      //opCount++;
      if (d.compareTo ((dataType) stageAreaTime) == 0){ 
         opCount++;
         return node; 
      }   
      
      else if (d.compareTo ((dataType) stageAreaTime) < 0){
         opCount++;
         return (node.left == null) ? null : find (d, node.left);
         }
         
      else{
         //opCount++;
        // System.out.println(opCount+" Comparisons.");

         return (node.right == null) ? null : find (d, node.right);
      }

        
   }
   public int getCount(){ return opCount;}
   public int getInsertOpCount(){System.out.println(insertOpCount);return this.insertOpCount;}
   public void setCount(){
      opCount = 0;
   }
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
