package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * This file was automatically generated by EvoSuite
 * Mon Apr 20 19:21:21 GMT 2020
 */

import java.util.HashMap;
import java.util.Map;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;

public class RelationshipDirectedWeightedEdgeTest {

  @Test
  public void test00()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      relationshipDirectedWeightedEdge0.setAttrs((Map<String, Attribute>) null);
      Map<String, Attribute> map0 = relationshipDirectedWeightedEdge0.getAtts();
      assertNull(map0);
  }

  @Test
  public void test01()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      Map<String, Attribute> map0 = relationshipDirectedWeightedEdge0.getAtts();
      assertTrue(map0.isEmpty());
  }

  @Test
  public void test02()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      Attribute attribute0 = DefaultAttribute.createAttribute("");
      relationshipDirectedWeightedEdge0.setAtt("", attribute0);
      Object object0 = relationshipDirectedWeightedEdge0.getAtt("");
      assertSame(object0, attribute0);
  }

  @Test
  public void test03()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge1 = new RelationshipDirectedWeightedEdge("->(");
      boolean boolean0 = relationshipDirectedWeightedEdge0.equals(relationshipDirectedWeightedEdge1);
      assertFalse(boolean0);
  }

  @Test
  public void test04()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      relationshipDirectedWeightedEdge0.setAttrs((Map<String, Attribute>) null);
      // Undeclared exception!
      try { 
        relationshipDirectedWeightedEdge0.toString();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedWeightedEdge", e);
      }
  }

  @Test
  public void test05()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      relationshipDirectedWeightedEdge0.setAttrs((Map<String, Attribute>) null);
      Boolean boolean0 = Boolean.TRUE;
      Attribute attribute0 = DefaultAttribute.createAttribute(boolean0);
      // Undeclared exception!
      try { 
        relationshipDirectedWeightedEdge0.setAtt("", attribute0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedWeightedEdge", e);
      }
  }

  @Test
  public void test06()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      // Undeclared exception!
      try { 
        relationshipDirectedWeightedEdge0.getNeighbour((Object) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedWeightedEdge", e);
      }
  }

  @Test
  public void test07()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      relationshipDirectedWeightedEdge0.setAttrs((Map<String, Attribute>) null);
      // Undeclared exception!
      try { 
        relationshipDirectedWeightedEdge0.getLabel();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedWeightedEdge", e);
      }
  }

  @Test
  public void test08()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      relationshipDirectedWeightedEdge0.setAttrs((Map<String, Attribute>) null);
      // Undeclared exception!
      try { 
        relationshipDirectedWeightedEdge0.getAtt((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedWeightedEdge", e);
      }
  }

  @Test
  public void test09()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("->(");
      String string0 = relationshipDirectedWeightedEdge0.getLabel();
      assertNotNull(string0);
  }

  @Test
  public void test10()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      HashMap<String, Attribute> hashMap0 = new HashMap<String, Attribute>();
      relationshipDirectedWeightedEdge0.setAttrs(hashMap0);
      String string0 = relationshipDirectedWeightedEdge0.toString();
      assertEquals("(null:null)", string0);
  }

  @Test
  public void test11()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      String string0 = relationshipDirectedWeightedEdge0.toString();
      assertNotNull(string0);
  }

  @Test
  public void test12()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      relationshipDirectedWeightedEdge0.hashCode();
  }

  @Test
  public void test13()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      HashMap<String, Attribute> hashMap0 = new HashMap<String, Attribute>();
      Object object0 = relationshipDirectedWeightedEdge0.getNeighbour(hashMap0);
      assertNull(object0);
  }

  @Test
  public void test14()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      Map<String, Attribute> map0 = relationshipDirectedWeightedEdge0.getAtts();
      assertEquals(1, map0.size());
  }

  @Test
  public void test15()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      boolean boolean0 = relationshipDirectedWeightedEdge0.equals(relationshipDirectedWeightedEdge0);
      assertTrue(boolean0);
  }

  @Test
  public void test16()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      Object object0 = relationshipDirectedWeightedEdge0.getVSource();
      assertNull(object0);
  }

  @Test
  public void test17()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      HashMap<String, Attribute> hashMap0 = new HashMap<String, Attribute>();
      relationshipDirectedWeightedEdge0.setAttrs(hashMap0);
      String string0 = relationshipDirectedWeightedEdge0.getLabel();
      assertEquals("(null:null)", string0);
  }

  @Test
  public void test18()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge();
      // Undeclared exception!
      try { 
        relationshipDirectedWeightedEdge0.equals((RelationshipDirectedWeightedEdge) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedWeightedEdge", e);
      }
  }

  @Test
  public void test19()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      Object object0 = relationshipDirectedWeightedEdge0.getVTarget();
      assertNull(object0);
  }

  @Test
  public void test20()  throws Throwable  {
      RelationshipDirectedWeightedEdge relationshipDirectedWeightedEdge0 = new RelationshipDirectedWeightedEdge("or.jgapht.graph.Defaultdge");
      Object object0 = relationshipDirectedWeightedEdge0.getAtt("org.jgrapht.nio.DefaultAttribute@0000000002->(null:null)");
      assertNull(object0);
  }
}

