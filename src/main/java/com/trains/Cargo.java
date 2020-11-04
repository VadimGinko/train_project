package com.trains;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
@Slf4j
public class Cargo{
    private String name;
    private int weight;
    private int volume;

    public Cargo(String name) {
        this.name = name;
    }

    public static Cargo of(String name){return new Cargo(name);}

    public void setWeight(int weight) {
        checkArgument(weight > 0, "weight cannot be less than one");
        this.weight = weight;
        log.info("weight added to com.trains.Cargo with name {}", this.name);
    }

    public void setVolume(int volume) {
        checkArgument(volume > 0, "volume cannot be less than one");
        this.volume = volume;
        log.info("volume added to com.trains.Cargo with name {}", this.name);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\n\nname", name)
                .add("\nweight", weight)
                .add("\nvolume", volume)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return weight == cargo.weight &&
                volume == cargo.volume &&
                Objects.equal(name, cargo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, weight, volume);
    }
}
