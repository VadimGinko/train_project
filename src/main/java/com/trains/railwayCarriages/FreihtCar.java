package com.trains.railwayCarriages;

import com.google.common.base.Objects;
import com.trains.Cargo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.ArrayList;

import static com.google.common.base.Preconditions.*;

@Slf4j
public final class FreihtCar extends RailwayCarriage {
    @Getter private final int maxCapacity;
    private final List<Cargo> cargos = new ArrayList<>();

    public FreihtCar(int weight, int length, int maxCapacity) {
        super(weight, length);
        checkArgument(maxCapacity > 0, "maxCapacity cannot be less than one");
        this.maxCapacity = maxCapacity;
    }

    public static FreihtCar of(int weight, int length, int maxCapacity){return new FreihtCar(weight, length, maxCapacity);}

    public void addCargo(Cargo cargo) {
        checkNotNull(cargo);
        boolean isValid = this.reduceCapacity(cargo.getVolume());
        checkState(isValid, "cargo does not fit into the wagon");
        this.cargos.add(cargo);
        log.info("com.trains.Cargo {} was added to the Railway Carriage {}", cargo.getName(), this.id);
    }

    //unload a wagon
    public List<Cargo> takeCargos() {
        List<Cargo> rtnCargos = getCargos();
        this.removeCargos();
        log.info("the cargo was unloaded from the Railway Carriage {}", this.id);
        return rtnCargos;
    }

    private void removeCargos() {
        this.cargos.clear();
    }

    private boolean reduceCapacity(int volume){
        if(this.sumCargosVolume() + volume > this.maxCapacity) {
            log.info("cargo does not fit into the Railway Carriage {}", this.id);
            return false;
        }
        log.info("the current capacity of the Railway Carriage {} has been reduced by {}", this.id, volume);
        return true;
    }

    public int sumCargosVolume(){
        int sum =0;
        for(var i: this.cargos){
            sum+= i.getVolume();
        }
        return sum;
    }

    public List<Cargo> getCargos() {
        return new ArrayList<>(cargos);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\nmaxCapacity", maxCapacity)
                .add("\ncargos", cargos)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FreihtCar freihtCar = (FreihtCar) o;
        return maxCapacity == freihtCar.maxCapacity &&
                Objects.equal(cargos, freihtCar.cargos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), maxCapacity, cargos);
    }
}
