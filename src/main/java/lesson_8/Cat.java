package lesson_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cat {
    private final StringBuilder names = new StringBuilder("Barsik");

    public Cat() {
    }

    public StringBuilder getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "names=" + names +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return names.equals(cat.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
