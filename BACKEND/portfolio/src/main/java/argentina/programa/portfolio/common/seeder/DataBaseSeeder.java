package argentina.programa.portfolio.common.seeder;

import argentina.programa.portfolio.common.TechCategory;
import argentina.programa.portfolio.model.entity.*;
import argentina.programa.portfolio.repository.ProfileRepository;
import argentina.programa.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DataBaseSeeder {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    private static final String PASSWORD = "12345678";
    private static final String HOST_EMAIL = "@outlook.com";
    private static final String USER = "martinezrinaudo";


    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {
        if(userRepository.findAll().isEmpty()) {
            createUser();
        }
        if(profileRepository.findAll().isEmpty()) {
            createProfile();
        }
    }

    private void createUser() {
        userRepository.save(User
                .builder()
                .email(USER+HOST_EMAIL)
                .password(passwordEncoder.encode(PASSWORD)).build()
        );
    }

    private void createProfile() {
        profileRepository.save(Profile
                .builder()
                .email("martinezrinaudo@outlook.com")
                .fullName("Mariano Nicolas Martinez Rinaudo")
                .imageUrl("./assets/images/profile.jpg")
                .location("Tandil, Buenos Aires (Argentina)")
                .profession("Java Fullstack Developer")
                .contactInformation(contactInformationSet())
                .languages(languageSet())
                .aboutMe(aboutMe())
                .experience(experienceSet())
                .education(educationSet())
                .technologies(technologiesLists())
                .projects(projectsSet())
                .build()
        );
    }

    private Set<ContactInformation> contactInformationSet() {
        Set<ContactInformation>contactInformationList = new HashSet<>();

        var c1 = ContactInformation
                    .builder()
                    .imageUrl("./assets/images/logo_linkedin.png")
                    .imageName("Linkedin")
                    .link("https://www.linkedin.com/in/mariano-nicolas-martinez-rinaudo-8822a2211/")
                    .socialMedia("LinkedIn: Mariano Martinez Rinaudo")
                    .build();
        var c2 = ContactInformation
                .builder()
                .imageUrl("./assets/images/logo_email.png")
                .imageName("Email")
                .link("#")
                .socialMedia("Email: martinezrinaudo@outlook.com")
                .build();
        var c3 = ContactInformation
                .builder()
                .imageUrl("./assets/images/logo2_github.png")
                .imageName("Github")
                .link("https://github.com/MartinezRinaudo")
                .socialMedia("GitHub: MartinezRinaudo")
                .build();

        contactInformationList.add(c1);
        contactInformationList.add(c2);
        contactInformationList.add(c3);

        return contactInformationList;
    }

    private Set<Language> languageSet() {
        Set<Language>languageList = new HashSet<>();

        var l1 = Language
                    .builder()
                    .name("Spanish - Español: ")
                    .level("Native - Nativo")
                    .build();
        var l2 = Language
                .builder()
                .name("English - Inglés: ")
                .level("Intermediate - Intermedio")
                .build();

        languageList.add(l1);
        languageList.add(l2);

        return languageList;
    }

    private Set<Education> educationSet() {
        Set<Education>educationList = new HashSet<>();

        var e1 = Education
                    .builder()
                    .name("Java Fullstack Developer Jr")
                    .place("Argentina Programa")
                    .startDate(Date.valueOf("2022-02-01"))
                    .endDate(Date.valueOf("2022-08-31"))
                    .build();
        var e2 = Education
                .builder()
                .name("Java Fullstack Developer Engineer")
                .place("Educacion IT")
                .startDate(Date.valueOf("2021-04-01"))
                .endDate(Date.valueOf("2022-04-30"))
                .build();

        educationList.add(e1);
        educationList.add(e2);

        return educationList;
    }

    private Set<TechnologiesList> technologiesLists() {
        Set<TechnologiesList> techList = new HashSet<>();

        var t1 = TechnologiesList
                .builder()
                .category(TechCategory.OTHER.getTechCategory())
                .technologiesList(technologyOtherSet())
                .build();
        var t2 = TechnologiesList
                .builder()
                .category(TechCategory.FRONTEND.getTechCategory())
                .technologiesList(technologyFrontSet())
                .build();
        var t3 = TechnologiesList
                .builder()
                .category(TechCategory.BACKEND.getTechCategory())
                .technologiesList(technologyBackSet())
                .build();

        techList.add(t1);
        techList.add(t2);
        techList.add(t3);

        return techList;
    }

    private Set<Technology> technologyOtherSet() {
        Set<Technology> techList = new HashSet<>();

        var t1 = Technology
                .builder()
                .imageUrl("./assets/images/logo_git.png")
                .imageName("GIT")
                .percentage(75)
                .build();
        var t2 = Technology
                .builder()
                .imageUrl("./assets/images/logo_Github.png")
                .imageName("Github")
                .percentage(80)
                .build();
        var t3 = Technology
                .builder()
                .imageUrl("./assets/images/logo_docker.png")
                .imageName("Docker")
                .percentage(30)
                .build();
        var t4 = Technology
                .builder()
                .imageUrl("./assets/images/logo_jenkins.png")
                .imageName("Jenkins")
                .percentage(40)
                .build();

        techList.add(t1);
        techList.add(t2);
        techList.add(t3);
        techList.add(t4);

        return techList;
    }

    private Set<Technology> technologyFrontSet() {
        Set<Technology> techList = new HashSet<>();

        var t1 = Technology
                .builder()
                .imageUrl("./assets/images/logo_html.png")
                .imageName("HTML")
                .percentage(90)
                .build();
        var t2 = Technology
                .builder()
                .imageUrl("./assets/images/logo_css.png")
                .imageName("CSS")
                .percentage(90)
                .build();
        var t3 = Technology
                .builder()
                .imageUrl("./assets/images/logo_Javascript.png")
                .imageName("Javascript")
                .percentage(80)
                .build();
        var t4 = Technology
                .builder()
                .imageUrl("./assets/images/logo_Bootstrap.png")
                .imageName("Bootstrap")
                .percentage(80)
                .build();
        var t5 = Technology
                .builder()
                .imageUrl("./assets/images/logo_react.png")
                .imageName("React")
                .percentage(30)
                .build();
        var t6 = Technology
                .builder()
                .imageUrl("./assets/images/logo_angular.png")
                .imageName("Angular")
                .percentage(40)
                .build();

        techList.add(t1);
        techList.add(t2);
        techList.add(t3);
        techList.add(t4);
        techList.add(t5);
        techList.add(t6);

        return techList;
    }

    private Set<Technology> technologyBackSet() {
        Set<Technology> techList = new HashSet<>();

        var t1 = Technology
                .builder()
                .imageUrl("./assets/images/logo_Java.jpg")
                .imageName("Java")
                .percentage(70)
                .build();
        var t2 = Technology
                .builder()
                .imageUrl("./assets/images/logo_spring.png")
                .imageName("Spring")
                .percentage(50)
                .build();
        var t3 = Technology
                .builder()
                .imageUrl("./assets/images/logo_hibernate.jpg")
                .imageName("Hibernate")
                .percentage(60)
                .build();
        var t4 = Technology
                .builder()
                .imageUrl("./assets/images/logo_mysql.png")
                .imageName("MySQL")
                .percentage(80)
                .build();
        var t5 = Technology
                .builder()
                .imageUrl("./assets/images/logo_jwt.png")
                .imageName("JWT")
                .percentage(80)
                .build();
        var t6 = Technology
                .builder()
                .imageUrl("./assets/images/logo_swagger.png")
                .imageName("Swagger")
                .percentage(80)
                .build();

        techList.add(t1);
        techList.add(t2);
        techList.add(t3);
        techList.add(t4);
        techList.add(t5);
        techList.add(t6);

        return techList;
    }

    private Set<Experience> experienceSet() {
        Set<Experience> experienceList = new HashSet<>();

        var e = Experience
                    .builder()
                    .job("Java Developer")
                    .place("Alkemy")
                    .startDate(Date.valueOf("2022-06-01"))
                    .endDate(Date.valueOf("2022-07-31"))
                    .skills("Soft skills and agile methodologies")
                    .typeOfJob("Remote-Remoto")
                    .build();

        experienceList.add(e);

        return experienceList;
    }

    private Set<Project> projectsSet() {
        Set<Project> projectList = new HashSet<>();

        var p1 = Project
                    .builder()
                    .name("Portfolio Argentina Programa")
                    .place("ARGENTINA PROGRAMA")
                    .englishDescription("Portfolio showing the developer's profile to the user. In the backend development, the information is provided through the interaction of java with mysql, to be used through the angular framework to finally return it.")
                    .spanishDescription("Portafolio mostrando el perfil del desarrollador al usuario. En el desarrollo del backend, la información se proporciona a través de la interacción de java con mysql, para ser utilizada a través del marco angular para finalmente devolverla.")
                    .build();
        var p2 = Project
                .builder()
                .name("ONG Project")
                .place("ALKEMY")
                .spanishDescription("Desarrollo de una aplicacion restful para una ONG ficticia en lenguaje Java. La aplicación cuenta con una variedad de enpoints y sus metodos CRUD, incorporación  de librerias como jwt, swagger, sendgrid y amazon S3. La metodologia de trabajo de equipo fue basada en los principios scrum.")
                .englishDescription("Development of a restful application for a fictitious NGO in Java language. The application has a variety of enpoints and its CRUD methods, incorporating libraries such as jwt, swagger, sendgrid and amazon S3. The team work methodology was based on the scrum principles.")
                .build();

        projectList.add(p1);
        projectList.add(p2);

        return projectList;
    }

    private AboutMe aboutMe() {
        return AboutMe
                .builder()
                .englishDescription("I'm Java fullstack developer. From the point of view of the backend side, I based my knowledge and skills on the OOP and web development with the best practices of programming. And from the frontend side, I've the basic experience to do a simple web page or a full web site. I've a proactive and results-oriented profile, I always try to learn as much as possible to do my work in the most efficient way and I can work in a team or the independently without any problem.")
                .spanishDescription("Soy desarrollador Java fullstack. Desde el punto de vista del lado del backend, basé mis conocimientos y habilidades en programación orientada a objetos y desarrollo web con las mejores prácticas de programación. Y desde el lado de la interfaz, tengo la experiencia básica para hacer una página web simple o un sitio web completo. Tengo un perfil proactivo y orientado a resultados, siempre trato de aprender lo más posible para hacer mi trabajo de la manera más eficiente. Puedo trabajar en equipo o de forma independiente sin ningún problema.")
                .build();
    }
}
