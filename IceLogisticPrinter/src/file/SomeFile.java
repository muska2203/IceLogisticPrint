package file;


import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class SomeFile {
    private File file;
    private FileType fileType;
    
    public SomeFile(File file) {
        this.file = file;
        if(this.file!=null) {
            switch(file.getName().substring(file.getName().lastIndexOf('.')+1).toLowerCase()) {
                case "xls": fileType = FileType.XLS; break;
                case "xlsx": fileType = FileType.XLSX; break;
                default : fileType = FileType.ANOTHER; break;
            }
            System.out.println(fileType);
        }
    }

    public File getFile() {
        return file;
    }

    public FileType getFileType() {
        return fileType;
    }
    
}
