package wiki.laona.file;

import java.io.*;

/**
 * @author laona
 * @description 拷贝目录到另外一个目录
 * @date 2022-01-22 14:52
 **/
public class CopyDirectory {

    /**
     * 源文件
     */
    private static final String SOURCE = "springboot/io-stream/src/main/resources/file";
    /**
     * 目标文件
     */
    private static final String DESTINATION = "springboot/io-stream/src/main/resources/temp";

    public static void main(String[] args) {
        CopyDirectory cd = new CopyDirectory();
        boolean res = cd.copyDirTo(SOURCE, DESTINATION);
        System.out.println("拷贝结果 = " + res);
    }

    /**
     * 拷贝文件目录
     *
     * @param source 源文件夹
     * @param dest   目标文件夹
     * @return 成功 -> true, 失败  -> false
     */
    private boolean copyDirTo(String source, String dest) {
        try {
            checkPath(source, dest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        File sourceFile = new File(source);
        if (!sourceFile.exists()) {
            System.out.println("目标文件不存在");
        }
        File[] files = sourceFile.listFiles();
        if (files == null || files.length == 0) {
            return true;
        }
        for (File file : files) {
            // 没有目标文件夹则创建
            String fileName = file.getName();
            File targetFile = new File(dest + "/" + fileName);
            if (file.isDirectory() && !targetFile.exists()) {
                targetFile.mkdirs();
            }
            // 是文件夹进行文件夹的处理
            if (file.isDirectory()) {
                String directoryName = file.getName();
                copyDirTo(file.getAbsolutePath(), dest + "/" + directoryName);
                continue;
            }
            // 进行拷贝文件
            try {
                copyFileTo(file.getAbsolutePath(), targetFile.getAbsolutePath());
            } catch (FileNotFoundException e) {
                System.out.println("文件拷贝失败");
                return false;
            }
        }
        return true;
    }

    /**
     * 拷贝文件
     *
     * @param source 源文件
     * @param dest   目标文件夹
     */
    private void copyFileTo(String source, String dest) throws FileNotFoundException {
        try {
            checkPath(source, dest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(dest)) {
            int read;
            byte[] buffer = new byte[1024];
            while ((read = in.read()) != -1) {
                out.write(buffer, 0, read);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查文件路径的合法性
     *
     * @param source 源路径
     * @param dest   目标路径
     */
    private void checkPath(String source, String dest) {
        if (source == null || dest == null || source.isEmpty() || dest.isEmpty()) {
            throw new IllegalArgumentException("文件路径不存在");
        }
    }
}
