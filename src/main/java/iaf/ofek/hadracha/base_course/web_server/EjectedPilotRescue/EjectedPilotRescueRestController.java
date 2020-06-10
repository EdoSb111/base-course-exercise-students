package iaf.ofek.hadracha.base_course.web_server.EjectedPilotRescue;

import iaf.ofek.hadracha.base_course.web_server.AirSituation.AirSituationProvider;
import iaf.ofek.hadracha.base_course.web_server.AirSituation.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ejectedPilotRescue")
public class EjectedPilotRescueRestController {

    @Autowired
    private EjectionsImporter ejectionsImporter;

    public EjectedPilotRescueRestController( @Autowired EjectionsImporter ejectionsImporter) {
        this.ejectionsImporter = ejectionsImporter;
    }

    @GetMapping("/infos")
    public List<EjectedPilotInfo> getAirSituation(){
        return ejectionsImporter.getAllEjections();
    }
}
