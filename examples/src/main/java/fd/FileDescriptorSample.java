package fd;

import sun.misc.SharedSecrets;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.management.ManagementFactory;

public class FileDescriptorSample {


    public static void main(String[] args) {
        String currentWorkingDirectory = System.getProperty("user.dir");
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(currentWorkingDirectory + "/somefile.txt"))){
            String jvmName = ManagementFactory.getRuntimeMXBean().getName();
            String processId = jvmName.split("@")[0];
            System.out.println("Current Process Id is:" + processId);
            FileDescriptor fileDescriptor = fileOutputStream.getFD();
            int fileDescriptorNumber = SharedSecrets.getJavaIOFileDescriptorAccess().get(fileDescriptor);
            System.out.println("File Descriptor received is:" + fileDescriptorNumber);

            Thread.sleep(Long.MAX_VALUE);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
