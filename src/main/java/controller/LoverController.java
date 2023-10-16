package controller;


import model.Lover;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.LoverService;

import java.util.List;

@Controller
@RequestMapping("/lover")
public class LoverController {
    private LoverService loverService;
    public LoverController(){
        loverService = new LoverService();
    }
    @GetMapping("/list")
    public ModelAndView showListLover(){
        List<Lover> loverList = loverService.showAllLover();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listLover",loverList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("newLover",new Lover());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createLover(Lover lover){
        loverService.addLover(lover);
        return("redirect:/lover/list");
    }

    @GetMapping("/delete/{id}")
    public String deleteLover(@PathVariable int id){
        loverService.deleteLover(id);
        return ("redirect:/lover/list");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/update");
        Lover findLover = loverService.findById(id);
        modelAndView.addObject("chooseLover",findLover);
        return modelAndView;
    }
    @PostMapping("/update/{id}")
    public  String update(@PathVariable int id, Lover lover){
        loverService.updateLover(lover.getId(), lover);
        return("redirect:/lover/list");
    }
}
