package iaf.ofek.hadracha.base_course.web_server.EjectedPilotRescue;

import iaf.ofek.hadracha.base_course.web_server.AirSituation.AirSituationProvider;
import iaf.ofek.hadracha.base_course.web_server.AirSituation.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejectedPilotRescue")
public class EjectedPilotRescueRestController {

    private EjectionsImporter ejectionsImporter;

    public EjectedPilotRescueRestController( @Autowired EjectionsImporter ejectionsImporter) {
        this.ejectionsImporter = ejectionsImporter;
    }

    @GetMapping("/infos")
    public List<EjectedPilotInfo> getEjections() {
        return ejectionsImporter.getAllEjections();
    }

    @GetMapping("/takeResponsibility")
    public void takeResponsibility(@CookieValue(value = "client-id", defaultValue = "") String clientId, @RequestParam int ejectionId) {
        ejectionsImporter.updateRescueEjection(ejectionId, clientId);
    }
}
