package wiki.laona.compose.best;

/**
 * @author laona
 * @description 测试
 * @date 2022-01-27 22:52
 **/
public class Demo {

    public static void main(String[] args) {
        Directory fileSystemTree = new Directory("design-pattern/compose/src/main/resources/file/");
        
        File fileA = new File("design-pattern/compose/src/main/resources/file/a");
        fileSystemTree.addSudNode(fileA);
        
        Directory nodeB = new Directory("design-pattern/compose/src/main/resources/file/b/");
        fileSystemTree.addSudNode(nodeB);


        File fileC = new File("design-pattern/compose/src/main/resources/file/b/c");
        nodeB.addSudNode(fileC);
        Directory nodeD = new Directory("design-pattern/compose/src/main/resources/file/b/d");
        nodeB.addSudNode(nodeD);
        File fileE = new File("design-pattern/compose/src/main/resources/file/b/e");
        nodeB.addSudNode(fileE);

        int countNumOfFiles = fileSystemTree.countNumOfFiles();
        System.out.println("countNumOfFiles = " + countNumOfFiles);

        long countSizeOfFiles = fileSystemTree.countSizeOfFiles();
        System.out.println("countSizeOfFiles = " + countSizeOfFiles);
    }
}
