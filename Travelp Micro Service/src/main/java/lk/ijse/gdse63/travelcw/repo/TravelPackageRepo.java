package lk.ijse.gdse63.travelcw.repo;


import lk.ijse.gdse63.travelcw.entity.TravelPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelPackageRepo extends CrudRepository<TravelPackage, String> {
    List<TravelPackage> findByCategory(String category);
    List<TravelPackage> findAll();

}
