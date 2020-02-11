package ua.kiev.prog.TestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kiev.prog.TestApp.model.App;
import ua.kiev.prog.TestApp.model.People;
import ua.kiev.prog.TestApp.service.PeopleService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    static final int ITEMS_PER_PAGE = 6;
    private static final int DEFAULT_APP_ID = -1;

    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam(required = false,defaultValue = "0") Integer page) {
        if(page < 0) page = 0;
        List<App> app = peopleService.findApps(PageRequest.of(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("apps", app);
        return "list_app";
    }

    @RequestMapping(value = "/add_appertment", method = RequestMethod.POST)
    public String addAppWithPeople(Model model, @RequestParam(value = "adr") String adr,
                            @RequestParam(value = "firstname") String firstname,
                            @RequestParam(value = "secondname") String secondname,
                            @RequestParam(value = "thirdname") String thirdname)
    {
        App app = new App(adr);
        List<People> ppl = new ArrayList<>();
        ppl.add(new People(firstname));
        ppl.add(new People(secondname));
        ppl.add(new People(thirdname));
        app.setPeople(ppl);
        for (People people: ppl) {
            people.setApp(app);
            //peopleService.addPeople(people);
        }
        peopleService.addApp(app);
        model.addAttribute("id", app.getId());
        return "redirect:/";
    }


    @RequestMapping("/add_app")
    public String appAddPage(Model model){
        return "add_app";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam long id, Model model) {
        List<App> apps = new ArrayList<>();;
        apps.add(peopleService.findApp(id));
        model.addAttribute("apps", apps);
        return "list_app";
    }


}
