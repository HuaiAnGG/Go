package wiki.laona.compose.best;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laona
 * @description 文件夹
 * @date 2022-01-27 22:49
 **/
public class Directory extends FileSystemNode {

    private final List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long totalSize = 0L;
        for (FileSystemNode fileOrDir : subNodes) {
            totalSize += fileOrDir.countSizeOfFiles();
        }
        return totalSize;
    }

    public void addSudNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(wiki.laona.compose.common.FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
