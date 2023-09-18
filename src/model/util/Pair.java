package model.util;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Pair<First, Second> {
    protected First first;
    protected Second second;

    Pair(First firstElement, Second secondElement){
        this.first = firstElement;
        this.second = secondElement;
    }

    public static <First, Second>
    Pair<First, Second> make(First firstElement, Second secondElement){
        return new Pair<>(firstElement, secondElement);
    }

    public First getFirst() {
        return this.first;
    }
    public Second getSecond() {
        return this.second;
    }

    public Optional<First> maybeGetFirst(){ return Optional.of(this.first); }
    public Optional<Second> maybeGetSecond(){ return Optional.of(this.second); }

}
