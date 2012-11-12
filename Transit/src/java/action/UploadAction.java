/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;

public class UploadAction extends ActionSupport {

    private File file;
    private String contentType;
    private String filename;

    public void setUpload(File file) {
	this.file = file;
    }

    public void setUploadContentType(String contentType) {
	this.contentType = contentType;
    }

    public void setUploadFileName(String filename) {
	this.filename = filename;
    }
    
    public String setUploadFileName() {
	return this.filename;
    }

    @Override
    public String execute() {
	if (file != null) {
	    System.out.println(file.getPath());
	}
	return SUCCESS;
    }
}