package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private DataRepo dataRepo;

    public HomeController(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Application war deployed with cargo gliwson";
    }


    @GetMapping("/wirus")
    public String getMap(Model model) {
        model.addAttribute("pointList", dataRepo.getPointList());
        return "index";
    }

    @GetMapping("/wirus2")
    public String getMa2p(Model model) {
        model.addAttribute("pointList", dataRepo.getPointList());
        return "index";
    }
    
}
