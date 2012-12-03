/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Wine;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author adminl
 */
@Stateless
@Path("entity.wine")
public class WineFacadeREST extends AbstractFacade<Wine> {

    @PersistenceContext(unitName = "CellarPU")
    private EntityManager em;

    public WineFacadeREST() {
        super(Wine.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Wine entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Wine entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Wine find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Wine> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Wine> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("name/{name}")
    @Produces({"application/xml", "application/json"})
    public List<Wine> findbyName(@PathParam("name") String name) {
        Query q = em.createQuery("SELECT w FROM Wine w WHERE w.name LIKE :name");
        q.setParameter("name", "%" + name + "%");
        return q.getResultList();
    }
    
    @GET
    @Path("region/{region}")
    @Produces({"application/xml", "application/json"})
    public List<Wine> findbyRegion(@PathParam("region") String region) {
        Query q = em.createQuery("SELECT w FROM Wine w WHERE w.region LIKE :region");
        q.setParameter("region", "%" + region + "%");
        return q.getResultList();
    }
    
    @GET
    @Path("grapes/{grapes}")
    @Produces({"application/xml", "application/json"})
    public List<Wine> findbyGrapes(@PathParam("grapes") String grapes) {
        Query q = em.createQuery("SELECT w FROM Wine w WHERE w.grapes LIKE :grapes");
        q.setParameter("grapes", "%" + grapes + "%");
        return q.getResultList();
    }
}
