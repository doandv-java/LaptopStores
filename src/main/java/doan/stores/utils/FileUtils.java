package doan.stores.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

@Slf4j
public class FileUtils {
    public static boolean checkNullOrEmptyImage(MultipartFile file) {
        return file == null || file.isEmpty() || file.getSize() == 0;
    }

    public static String saveImage(String theDir, MultipartFile file) {
        Path root = Path.of(theDir);
        Long timeNow = Instant.now().getEpochSecond();
        try {
            String newFileName = timeNow + "-" + file.getOriginalFilename();
            Files.copy(file.getInputStream(),
                    root.resolve(newFileName));
            return newFileName;
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public static boolean createDirectoryIfNotExist(String directory) {
        try {
            File theDir = new File(directory);
            if (theDir.exists()) {
                log.info("The {} directory had existed", theDir);
                return true;
            }
            theDir.mkdirs();
            log.info("Created {} directory", theDir);
        } catch (Exception e) {
            log.info("Exception: {}", e.getMessage());
            return false;
        }
        return true;

    }
}
