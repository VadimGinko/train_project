package com.trains.railwayCarriages;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.UUID;

@Slf4j
@Getter
public class RailwayCarriage {
    protected final String id = UUID.randomUUID().toString();
    protected int weight;
    protected int length;
    protected RailwayCarriage nextRailwayCarriage;

    public RailwayCarriage(int weight, int length) {
        checkArgument(weight > 0, "weight cannot be less than one");
        this.weight = weight;
        checkArgument(length > 0, "length cannot be less than one");
        this.length = length;
    }

    public static RailwayCarriage of(int weight, int length){return new RailwayCarriage(weight, length);}



    public void attachRailwayCarriage(RailwayCarriage nRailwayCarriage) throws LocomotiveException {
        if(nRailwayCarriage instanceof Locomotive){
            throw new LocomotiveException("the locomotive cannot be hooked into the cars, it must be alone");
        }
        nextRailwayCarriage = nRailwayCarriage;
        log.info("RailwayCarriage {} ------> RailwayCarriage {}", this.id, nRailwayCarriage.getId());
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("\n\n\nid", id)
                .add("\nweight", weight)
                .add("\nlength", length)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RailwayCarriage that = (RailwayCarriage) o;
        return weight == that.weight &&
                length == that.length &&
                Objects.equal(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, weight, length);
    }
}
