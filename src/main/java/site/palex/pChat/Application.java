package site.palex.pChat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Эта анотация добавляет следующие анотации:
//@Configuration - помечает класс как источник определений компонента для контекста приложения
//@EnableAutoConfiguration говорит Spring boot начать добавлять beans на основе настроек classpath, другие бины и прочие настройки.
//@EnableWebMvc - помечает приложение как ВЭБ приложение и активирует ключевые поведения, такие как настройка DispatcherServlet
//@ComponentScan говорит Spring посмотреть другие компоненты, конфигурации и сервисы в текущем пакете, разрешает найти контроллеры.


public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
