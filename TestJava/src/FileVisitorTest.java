import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author kencs@foxmail.com
 */
public class FileVisitorTest extends SimpleFileVisitor<Path> {
    
    private void find(Path path){
        System.out.printf("访问-%s:%s%n",(Files.isDirectory(path)?"目录":"文件"),path.getFileName());
    }
    @Override
    public FileVisitResult visitFile(Path file,BasicFileAttributes attrs){
        find(file);
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs){
        find(dir);
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult visitFileFailed(Path file,IOException e){
        System.out.println(e);
        return FileVisitResult.CONTINUE;
    }
    
    public static void main(String[] args) throws IOException{
    	args = new String[]{"/Library/Java/JavaVirtualMachines"};
        if(args.length!=1){
            System.out.println("请输入一个文件路径作为参数");
            System.exit(-1);
        }
        Files.walkFileTree(Paths.get( args[0]), new FileVisitorTest());
    }
}
