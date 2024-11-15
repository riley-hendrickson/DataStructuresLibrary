import libraryProject.Library.*;
import libraryProject.TestFunctions;
public class Demonstration
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        HashMap map = new HashMap();
        LinkedList list = new LinkedList();
        Queue queue = new Queue();
        Stack stack = new Stack();

        TestFunctions.testBinaryTree(tree);
        TestFunctions.testHashMap(map);
        TestFunctions.testLinkedList(list);
        TestFunctions.testQueue(queue);
        TestFunctions.testStack(stack);
    }
}