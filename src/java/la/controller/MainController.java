package la.controller;

import la.model.Libro;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final ArrayList<Libro> l;

    public MainController() {
        l = new ArrayList<>();
        l.add(new Libro("Libro1", "Autore1"));
        l.add(new Libro("Libro2", "Autore2"));
        l.add(new Libro("Libro3", "Autore3"));
    }

    @RequestMapping(value = {"/"})
    public ModelAndView index(ModelMap m) {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    /**
     * Serializza con Json
     *
     * @return array list serializzato con json
     */
    @RequestMapping(value = "/allLibri", method = RequestMethod.POST)
    @ResponseBody
    public String allLibri() {
        return new Gson().toJson(l);
    }
    

    @RequestMapping(value = "/addLibro", params={"tit","aut"}, method = RequestMethod.POST)
    @ResponseBody
    public String addLibro(@RequestParam(value = "tit", required=true) String titolo,@RequestParam(value = "aut",required=true) String autore) {
        Libro toAdd = new Libro(titolo,autore);
        this.l.add(toAdd);
        return "";
    }
    
    /**
     * Rimuove un libro dato il titolo dall'array
     * @param titolo titolo del libro da rimuovere
     * @return 
     */
    @RequestMapping(value = "/deleteLibro", params={"tit"}, method = RequestMethod.GET)
    @ResponseBody
    public String deleteLibro(@RequestParam(value = "tit", required=true)String titolo){
        for(Libro lt : this.l){
            if(lt.getTitolo().equals(titolo)){
                this.l.remove(lt);
            }
        }
        return "";
    }
}
