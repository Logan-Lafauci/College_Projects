package avl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author logan 
 */
public class AVL 
{
    
    public static Node root;
    public static int min;
    public static Node firstSplit;
    
    public static void main (String[] args) throws FileNotFoundException
    {
//        These were used to help me run my program
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        
        File input = new  File(fileName + ".txt");
        in = new Scanner(input);
        
        int commandAmount = in.nextInt();
        
        in.next();
        int rangeMin = 0;
        root = new Node(in.nextInt(),in.nextInt());
        for(int i = 1; i < commandAmount; i++)
        {
            switch (in.next())
            {
                case "IN":
                    Node newNode = new Node(in.nextInt(), in.nextInt());
                    insert(root, newNode);
                    break;
                case "RM":
                    min = 0;
                    rangeMin = rangeMinData(root, in.nextInt(), in.nextInt());
                    break;
            }
        }
        System.out.println(rangeMin);
    }
    
    public static class Node
    {
        public int key, data, size, height, minData;
        public Node left, right, parent;
        public Node(int key, int data)
        {
           this.key = key;
           this.data = data;
        }        
    }
    
    public static int rangeMinData(Node x, int k1, int k2)
    { 
        if(x.key >= k1 && x.key <= k2)
        {
            if(min == 0)
            {
                min = x.data;
                firstSplit = x;
            }
            
            if(x != firstSplit)
            {
                if(x.key > firstSplit.key && x.left != null)
                {
                    min = (x.left.minData < min)? x.left.minData: min;
                }
                else if(x.key < firstSplit.key && x.right != null)
                {
                    min = (x.right.minData < min)? x.right.minData: min;
                }
            }
            
            if (x.left != null && !(x.key > firstSplit.key))
            {
                rangeMinData(x.left, k1, k2);
            }
            if(x.right != null && !(x.key < firstSplit.key))
            {
                rangeMinData(x.right, k1, k2);
            }
            
            min = (x.data < min)? x.data : min;
        }
        else if(x.key < k1 && x.right != null)
        {
            rangeMinData(x.right, k1, k2);
        }
        else if(x.key > k2 && x.left != null)
        {
            rangeMinData(x.left, k1, k2);
        }
        
        return min;
    }
    
    public static void insert(Node x, Node z)
    {
        if(x.key > z.key)
        {
            if(x.left != null)
            {
                insert(x.left, z);
            }
            else
            {
                x.left = z;
                z.parent = x;
                updateHeight(x.left);
                updateSize(x.left);
                updateMinData(x.left);
            }
            updateHeight(x);
            updateSize(x);
            updateMinData(x);
        }
        else if(x.key <= z.key)
        {
            if(x.right != null)
            {
                insert(x.right, z);
                x.right.parent = x;
            }
            else
            {
                x.right = z;
                updateHeight(x.right);
                updateSize(x.right);
                updateMinData(x.right);
            }   
            updateHeight(x);
            updateSize(x);
            updateMinData(x);
        }
        
        // trying the rotation
        int bf = 0;
        if(x.left != null)
        {
            if(x.right == null)
            {
                bf = x.left.height;
            }
            else
            {
                bf = x.left.height - x.right.height;
            }
        }
        else if(x.right != null)
        {
            if(x.left == null)
            {
                bf = -1 * x.right.height;
            }
            else
            {
                bf = x.left.height - x.right.height;
            }
        }
        
        Node y;
        switch(bf)
        {
            case 2:
                y = x.left;
                if(y.right == null || (y.right != null && y.left != null))
                {
                    x = rightRotate(x);
                }
                else if(y.left == null)
                {
                    y = leftRotate(y);
                    x = rightRotate(x);
                }
                break;
            case -2:
                y = x.right;
                if(y.left == null || (y.left != null && y.right != null))
                {
                    x = leftRotate(x);
                }
                else if(y.right == null)
                {
                    y = rightRotate(y);
                    x = leftRotate(x);
                }
                break;
        }
    }
    
    public static void updateHeight(Node x)
    {
        if((x.left == null) && (x.right == null))
        {
            x.height = 1;
        }
        else if(x.left == null)
        {
            x.height = x.right.height + 1;
        }
        else if(x.right == null)
        {
            x.height = x.left.height + 1;
        }
        else
        {
            int maxHeight = x.left.height;
            if(maxHeight < x.right.height)
            {
                maxHeight = x.right.height;
            }
            x.height = 1 + maxHeight;        
        }
    }
    
    public static void updateSize(Node x)
    {
        if((x.left == null) && (x.right == null))
        {
            x.size = 1;
        }
        else if(x.left == null )
        {
            x.size = x.right.size + 1;
        }
        else if(x.right == null )
        {
            x.size = x.left.size + 1;
        }
        else
        {
            x.size = 1 + x.left.size + x.right.size;
        }
    }
    
    public static void updateMinData(Node x)
    {
        if((x.left == null) && (x.right == null))
        {
            x.minData = x.data;
        }
        else if (x.left == null)
        {
            x.minData = (x.right.minData < x.data)? x.right.minData : x.data;
        }
        else if (x.right == null)
        {
            x.minData = (x.left.minData < x.data)? x.left.minData : x.data;
        }
        else
        {
            int min = x.data;
            if(x.left.minData < min)
            {
                min = x.left.minData;
            }
            if(x.right.minData < min)
            {
                min = x.right.minData;
            }
            x.minData = min;
        }
    }
    
    public static void printHeight(Node x)
    {
        if(x == null)
        {
            System.out.printf("%d/n", -1);
        }
        else
        {
            System.out.printf("%d/n", x.height);
        }
    }
    
    public static Node leftRotate(Node x)
    {
        Node p = x.parent;
        Node y = x.right;
        Node z = y.left;
        
        y.left = x;
        x.parent = y;
        x.right = z;
        if(z != null)
        {
            z.parent = x;
        }
        
        if(p != null)
        {
            if(p.left == x)
            {
                p.left = y;
                y.parent = p;
            }
            if(p.right == x)
            {
                p.right = y;
                y.parent = p;
            }
        }
        else
        {
            root = y;
            root.parent = null;
        }
        
        updateHeight(x);
        updateHeight(y);
        updateSize(x);
        updateSize(y);
        updateMinData(x);
        updateMinData(y);
        
        return y;
    }
    
    public static Node rightRotate(Node x)
    {
        Node p = x.parent;
        Node y = x.left;
        Node z = y.right;
        
        y.right = x;
        x.parent = y;
        x.left = z;
        if(z != null)
        {
            z.parent = x;
        }
        
        if(p != null)
        {
            if(p.left == x)
            {
                p.left = y;
                y.parent = p;
            }
            if(p.right == x)
            {
                p.right = y;
                y.parent = p;
            }
        }
        else
        {
            root = y;
            root.parent = null;
        }
        
        updateHeight(x);
        updateHeight(y);
        updateSize(x);
        updateSize(y);
        updateMinData(x);
        updateMinData(y);
        
        return y;
    }
}

