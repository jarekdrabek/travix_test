package drabek.jaroslaw.supplier;

import drabek.jaroslaw.Flight;

public interface DTO2FlightConverter <E>{
    default Flight fromDTO(E dto) { throw new UnsupportedOperationException();}
}
