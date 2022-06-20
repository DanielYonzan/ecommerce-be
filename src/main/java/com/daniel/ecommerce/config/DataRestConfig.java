package com.daniel.ecommerce.config;

import com.daniel.ecommerce.entity.Product;
import com.daniel.ecommerce.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author daniel <daniel.tamang@f1soft.com>
 * created on 2022-06-17
 */
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public DataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedMethods = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};

        // disable HTTP methods for Product: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)));

        // disable HTTP methods for ProductCategory: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)));

        // call an internal helper method

        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids


        //- get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //- create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        //- get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        //- expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}
