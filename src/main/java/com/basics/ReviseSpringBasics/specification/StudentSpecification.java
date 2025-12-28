package com.basics.ReviseSpringBasics.specification;

import com.basics.ReviseSpringBasics.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


// single search bar for name and college name

public class StudentSpecification {
    public static Specification<Student> getSpecification(String search){
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (search == null || search.isEmpty()) {
                    return null;
                }

                List<Predicate> list= new ArrayList<>();
                String searchPattern = "%" + search.toLowerCase() + "%";

                list.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), searchPattern));
                list.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("collegeName")), searchPattern));

                return criteriaBuilder.or(list.toArray(new Predicate[0]));

            }
        };
    }
}










//package com.basics.ReviseSpringBasics.specification;
//
//import com.basics.ReviseSpringBasics.entity.Student;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import org.jspecify.annotations.Nullable;
//import org.springframework.data.jpa.domain.Specification;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentSpecification {
//    public static Specification<Student> getSpecification(String search){
//        return new Specification<Student>() {
//            @Override
//            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
////                if(search==null || search.isEmpty()){
////                    criteriaBuilder.conjunction();
////                }
//
//                if (search == null || search.isEmpty()) {
//                    return null;
//                }
//
//
//                List<Predicate> list= new ArrayList<>();
//
//
//                // for exact match
//
//                // select * from employee where name=:search or collegeName=:search
//
////                list.add(criteriaBuilder.equal(root.get("name"),search));
////                list.add(criteriaBuilder.equal(root.get("collegeName"),search));
//
//
//
//                // 2. IMPROVEMENT: Use 'like' for search instead of 'equal'
//                // 'equal' looks for exact matches only. 'like' allows partial matches.
//                // We add "%" around the string to search anywhere in the text.
//                String searchPattern = "%" + search.toLowerCase() + "%";
//
//                list.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), searchPattern));
//                list.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("collegeName")), searchPattern));
//
//
//
////                // sorting logic
////                query.orderBy()
//
//               return criteriaBuilder.or(list.toArray(new Predicate[0]));
//
//            }
//        };
//    }
//}
