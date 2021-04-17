package Ada.APIRest.controller;

import Ada.APIRest.DTO.RepDTO;
import Ada.APIRest.entity.Rep;
import Ada.APIRest.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Rep")
public class RepController {

    @Autowired
    RepService repService;

    @GetMapping("/")
    public @ResponseBody
    List<RepDTO> getAll() {
        return repService.findAll();
    }

    @PostMapping(path = "/newRep")
    public ResponseEntity<Rep> newRep(@RequestBody Rep rep ) {

        Rep newRep = repService.save(rep);
        return new ResponseEntity<>(newRep, HttpStatus.OK);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<RepDTO> getRep(@PathVariable("id") Long id) {
        RepDTO rep = repService.findById(id);
        return new ResponseEntity<>(rep, HttpStatus.OK);
    }*/
}
