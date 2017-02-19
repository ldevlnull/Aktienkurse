package de.controller;

import de.pojo.Firm;
import de.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by devnull on 17.01.17.
 */
@Controller
public class FirmController {

    private static final String MENU = "main";
    private static final String REFRESH = "redirect:/";
    private static final String FIRM = "firm";
    private int kriterium = 0;

    @Autowired
    private FirmService service;

    @RequestMapping(value = "/kriterium/{kriterium}")
    public String kriterium(@PathVariable int kriterium) {
        this.kriterium = kriterium;
        return REFRESH;
    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Firm> getData() {
        return service.findAll();
    }

    @RequestMapping(value = "/getKriterium1", method = RequestMethod.POST)
    public @ResponseBody List<Firm> kriterium1() {
        return service.getKriterium1();
    }

    @RequestMapping(value = "/getKriterium2", method = RequestMethod.POST)
    public @ResponseBody List<Firm> kriterium2(){
        return service.getKriterium2();
    }

    @RequestMapping(value = "/getKriterium3", method = RequestMethod.POST)
    public @ResponseBody List<Firm> kriterium3(){
        return service.getKriterium3();
    }
    @RequestMapping(value = "/getKriterium5", method = RequestMethod.POST)
    public @ResponseBody List<Firm> kriterium5(){
        return service.getKriterium5();
    }
    @RequestMapping(value = "/firm")
    public String firm(Model model) {
        model.addAttribute("firm", new Firm());
        return FIRM;
    }

    @RequestMapping(value = {"/", "/main"})
    public String menu(Model model) {
        model.addAttribute("kriterium", this.kriterium);
        return MENU;
    }

    @RequestMapping(value = "/newFirm", method = RequestMethod.POST)
    public String newFirm(@ModelAttribute Firm firm) {
        service.save(firm);
        return REFRESH;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update() {
        try {
            service.updateData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return REFRESH;
    }
}
