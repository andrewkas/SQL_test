package com.noirix;

import com.noirix.aspect.LoggingAspect;
import com.noirix.domain.Cars;
import com.noirix.domain.User;
import com.noirix.repository.UserRepository;
import com.noirix.service.CarsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Collectors;

public class SpringContextTester {
    public static void main(String[] args) {
  //     ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");

  //     User user1 = (User)classPathXmlApplicationContext.getBean("user1");
  //     User user2 = (User)classPathXmlApplicationContext.getBean("user2");

  //     System.out.println(user1.getId());
  //     System.out.println(user1.getName());
  //     System.out.println(user1.getSurname());
  //     System.out.println(user1.getUserCar());

  //     System.out.println(user2.getId());
  //     System.out.println(user2.getName());
  //     System.out.println(user2.getSurname());


  //     System.out.println("******************************************");

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.noirix");

        CarsService carsService = annotationConfigApplicationContext.getBean(CarsService.class);

        System.out.println(carsService.findAll().stream().map(Cars::getModel).collect(Collectors.joining(", ")));

        System.out.println(carsService.findById(17L));
        System.out.println(carsService.findById(8L));
        System.out.println(carsService.search("Honda"));
        System.out.println(carsService.search("Tesla"));
       // Cars carsForSave =
       //         Cars.builder()
       //                 .model("Tesla")
       //                 .creationYear(2017)
       //                 .userId(1L)
       //                 .price(120000.0)
       //                 .color("red")
       //                 .build();
//
       // System.out.println(carsService.save(carsForSave));

 //       DatabaseConfig bean = annotationConfigApplicationContext.getBean(DatabaseConfig.class);
 //       System.out.println(bean.getLogin());
 //       System.out.println(bean.getDriverName());
 //       System.out.println(bean.getPassword());
 //       System.out.println(bean.getUrl());
/*        This is how to check available beans in context*/

//        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }

      //  Cars generatedCar = annotationConfigApplicationContext.getBean(Cars.class);
      //  System.out.println(generatedCar);
//

        UserRepository userRepository = annotationConfigApplicationContext.getBean(UserRepository.class);
       // LoggingAspect loggingAspect = annotationConfigApplicationContext.getBean(LoggingAspect.class);
        // loggingAspect.Count();
        System.out.println(userRepository.findAll().stream().map(User::getName).collect(Collectors.joining(", ")));
    }
}
