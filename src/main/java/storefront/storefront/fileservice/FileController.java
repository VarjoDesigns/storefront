package storefront.storefront.fileservice;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {
	
	@Autowired
	private FileModelRepository repository;
	
	@GetMapping("/fileupload")
	public String index() {
		return "upload";
		}
	
	@Value("${upload.path}")
	private String uploadFolder;
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file, Model model) {
		// Used for file handling
		
		// Checks if file is empty
		if (file.isEmpty()) {
			model.addAttribute("msg", "Upload failed");
			return "uploadstatus";
		}
		
		try {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            repository.save(fileModel);
    
            return "redirect:/filelist";
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return "uploadstatus";
	}
	
	@GetMapping("/filelist")
	public String fileList(Model model) {
		model.addAttribute("files", repository.findAll());  
		return"filelist";
		}
	
	@GetMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<FileModel> fileOptional = repository.findById(id);
		
		if(fileOptional.isPresent()) {
			FileModel file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
					.body(file.getFile());
			}
		return ResponseEntity.status(404).body(null);
	}
}

	