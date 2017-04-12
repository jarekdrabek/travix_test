package drabek.jaroslaw.supplier;

import drabek.jaroslaw.SearchCriteria;

public interface SearchCriteria2DTOConverter<E> {

    default E toDTO(SearchCriteria searchCriteria) { throw new UnsupportedOperationException();}

}
