import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import Persona.Persona;

public class Main {
  public static final void main(String[] args) {
    Optional<String>nombre2=Optional.of("Veronica");
    Optional<Persona >persona2= nombre2.map(per->new Persona(per));
    System.out.println(persona2.get().getNombre());
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
    numeros.stream().map(x -> x * 2).forEach(System.out::println);

    Stream<String> datos = Stream.of("oscar", "veronica");
    Stream<String> datos1 = datos.map(x -> x + "!");
    Stream<String> datos2 = datos1.filter(x -> x.contains("oscar"));
    datos2.forEach(System.out::println);

  }
}
