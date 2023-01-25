package si.nkbm.feriwinter.winterdemobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("osebe")
public class OsebaRestController {
    @Autowired
    private OsebaRepository osebaRepository;

    private static final Logger log = Logger.getLogger(OsebaRestController.class.toString());

    //private static Map<String,Oseba> osebe= Collections.synchronizedMap(new HashMap<String, Oseba>());

    @GetMapping()
    public Iterable<Oseba> getOseba() {
        log.info("Get osebe");
        return osebaRepository.findAll();
    }

    @GetMapping("/{email}")
    public Oseba getOseba(@PathVariable String email) {
        log.info("Get osebe z email "+email);
        return osebaRepository.findById(email).orElseThrow();
    }

    @PostMapping
    public Oseba postOseba(@RequestBody Oseba oseba) {
        log.info("Dodajanje nove osebe "+oseba);
        osebaRepository.save(oseba);
        return osebaRepository.findById(oseba.getEmail()).orElseThrow();
    }

}
