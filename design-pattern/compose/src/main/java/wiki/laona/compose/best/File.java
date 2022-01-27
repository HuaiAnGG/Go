package wiki.laona.compose.best;

/**
 * @author laona
 * @description 文件方法
 * @date 2022-01-27 22:46
 **/
public class File extends FileSystemNode{

    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()){
            return 0;
        }
        return file.length();
    }
}
