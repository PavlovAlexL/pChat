package site.palex.pChat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//Приложение основано на Spring MVC.
// Т.о. вам необходимо настроить Spring MVC и контроллеры представлений для отображения этих шаблонов.
// Ниже конфигурационный класс для настройки Spring MVC в приложении.
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("registration");
    }

}

//Метод addViewControllers() (переопределение метода с таким же названием в WebMvcConfigurerAdapter), добавляющий четыре контроллера.
// Двое из них настроены на представление с именем "home"(home.html), другой настроен на "hello".
// Четвертый контроллер настроен на представление с названием "login". Вы создадите это представление в следующей главе.