package TestDiOggi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Prodotti p1 = new Prodotti(9L,"IlSignoreDegliAnnelli","books",35.50);
        Prodotti p2 = new Prodotti(7L,"IlGladiatore","books",20.50);
        Prodotti p3 = new Prodotti(4L,"L'arteDellaGuerra","books",110.50);
        Prodotti p4 = new Prodotti(2L,"Pistola","baby",0.50);
        Prodotti p5 = new Prodotti(3L,"bazzuca","arma",1000);
        Prodotti p6 = new Prodotti(8L,"mitra","arma",500);


        List<Prodotti> books = new ArrayList<>();
        books.add(p1);
        books.add(p2);
        books.add(p3);
        books.add(p4);



        List<Prodotti> booksPrice = books.stream()
                .filter(prodotti -> prodotti.getCategory().equals("books") && prodotti.getPrice() > 100)
                .toList();

        System.out.println(booksPrice.toString());


        Customer Riccardo = new Customer(1L,"Riccardo", 1);


        Order o1 = new Order(11L,"spedito", LocalDate.now(),LocalDate.now(),books,Riccardo);
        Order o2 = new Order(12L,"disperso", LocalDate.now(),LocalDate.now(),books,Riccardo);

        List<Order> ordersBaby = new ArrayList<>();
        ordersBaby.add(o1);
        ordersBaby.add(o2);

        List<Order> babyOrd = ordersBaby.stream()
                .filter(order -> order.getProducts().stream().anyMatch(prodotti -> prodotti.getCategory().equals("baby")))
                .collect(Collectors.toList());


        babyOrd.forEach(System.out::println);


        List<Prodotti> armi = new ArrayList<>();
        armi.add(p5);
        armi.add(p6);

        List<Prodotti> armiBianche = armi.stream()
                .filter(prodotti -> prodotti.getCategory().equals("arma"))
                .map(prodotti -> new Prodotti(
                        prodotti.getId(),
                        prodotti.getName(),
                        prodotti.getCategory(),
                        prodotti.getPrice() * 0.90
                ))
                .collect(Collectors.toList());

        armiBianche.forEach(prodotti -> System.out.println(prodotti.toString()));





    }
}