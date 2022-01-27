package wiki.laona.compose.best;

/**
 * @author laona
 * @description 文件系统节点
 * @date 2022-01-27 22:37
 **/
public abstract class FileSystemNode {
    
    protected final String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    /**
     * 统计指定目录下的文件个数
     *
     * @return 文件个数
     */
    public abstract int countNumOfFiles();

    /**
     * 统计指定目录下的文件总大小
     *
     * @return 文件总大小
     */
    public abstract long countSizeOfFiles();
    
    public String getPath() {
        return path;
    }
}
