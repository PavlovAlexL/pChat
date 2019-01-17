package site.palex.pChat;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller //Контроллер это модуль, который слушает запросы на сервер и возвращает нужный ответ
public class GreetingController {
    @GetMapping("/greeting")    //эта аннотация гарантирует, что HTTP-request GET к /greeting отображаются в методе greeting()
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        //@RequestParam эта аннотация связывает значение запроса String name c параметром name метода greeting()
        //Этот параметр запроса не является обязательным, если он отсутствует в запросе, то используется значение по умолчанию World.
        //Значение параметра name добавляется к объекту Model и в итоге делает его доступным для шаблона представления
        //model.addAttribute("name", name);
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "hello, lets code");
        return "main";
    }
}
