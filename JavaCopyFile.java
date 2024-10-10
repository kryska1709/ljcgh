import java.io.*;

public class JavaCopyFile {

    public static void main(String[] args) throws InterruptedException, IOException {
        File source = new File("C:/Users/User/IdeaProjects/copyfalee/src/input.txt");
        File dest = new File("C:/Users/User/IdeaProjects/copyfalee/output.txt");

        // копируем файл с помощью потоков
        long start = System.nanoTime();
        // засекаем время до выполнения копирования
        copyFileUsingStream(source, dest);
        System.out.println("Время копирования файла с помощью потоков = " + (System.nanoTime() - start));
        File source1 = new File("C:/Users/User/IdeaProjects/copyfalee/src/input1.txt");
        File dest1 = new File("C:/Users/User/IdeaProjects/copyfalee/output1.txt");

        // копируем файл с помощью потоков
        long start1 = System.nanoTime();
        // засекаем время до выполнения копирования
        copyFileUsingStream1(source1, dest1);
        System.out.println("Время копирования файла с помощью потоков = " + (System.nanoTime() - start1));
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
private static void copyFileUsingStream1(File source1, File dest1) throws IOException {
    InputStream iss = null;
    OutputStream os1 = null;
    try {
        iss = new FileInputStream(source1);
        os1 = new FileOutputStream(dest1);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = iss.read(buffer)) > 0) {
            os1.write(buffer, 0, length);
        }
    } finally {
        iss.close();
        os1.close();
    }
}
}