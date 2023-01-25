package si.nkbm.feriwinter.winterdemobackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class InfoController {

    private static final Logger log = Logger.getLogger(InfoController.class.toString());

    @GetMapping("/info")
    public ResponseEntity<String> getServiceInfo() {
        return ResponseEntity.ok("Zdravo");
    }

}
