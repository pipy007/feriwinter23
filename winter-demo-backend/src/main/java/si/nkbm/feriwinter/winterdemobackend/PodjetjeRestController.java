package si.nkbm.feriwinter.winterdemobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("podjetje")
public class PodjetjeRestController {

    private static final Logger log = Logger.getLogger(OsebaRestController.class.toString());

    @Autowired
    private PodjetjeRepository podjetjeRepository;

    @GetMapping()
    public Iterable<Podjetje> getPodjetja() {
        log.info("Get podjetja");
        return podjetjeRepository.findAll();
    }

    @PostMapping
    public Podjetje postPodjetje(@RequestBody Podjetje podjetje) {
        log.info("Dodajanje nove osebe "+podjetje);
        podjetjeRepository.save(podjetje);
        return podjetjeRepository.findById(podjetje.getId()).orElseThrow();
    }



}
