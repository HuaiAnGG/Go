package wiki.laona.compose.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laona
 * @description 文件系统节点
 * @date 2022-01-27 20:18
 **/
public class FileSystemNode {

    private final String path;
    private final boolean isFile;
    private final List<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    /**
     * 统计指定目录下的文件个数
     *
     * @return 文件个数
     */
    public int countNumOfFiles() {
        if (isFile) {
            return 1;
        }
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    /**
     * 统计指定目录下的文件总大小
     *
     * @return 文件总大小
     */
    public long countSizeOfFiles() {
        if (isFile) {
            File file = new File(path);
            if (!file.exists()){
                return 0;
            }
            return file.length();
        }
        long totalSize = 0L;
        for (FileSystemNode fileOrDir : subNodes) {
            totalSize += fileOrDir.countSizeOfFiles();
        }
        return totalSize;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
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

    public String getPath() {
        return path;
    }
}
