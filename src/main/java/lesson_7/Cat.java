package lesson_7;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Cat {
    public String name;
    private Integer age;

    public String info(String str1, String str2) {
        return str1 + str2;
    }

    private String info(String str, Integer integer) {
        return str + integer;
    }
}
