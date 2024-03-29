/***********************************************************************
 * Module:  Cenovnik.java
 * Author:  Nemanja
 * Purpose: Defines the Class Cenovnik
 ***********************************************************************/
package model;

import java.util.*;

public class Cenovnik {
   private String id;
   private Date datumFormiranja;
   private Date vaziDo;
   
   public java.util.Collection<StavkaCenovnika> stavkaCenovnika;
   
   public void dodajStavku(StavkaCenovnika stavka) {
      // TODO: implement
   }

   public void obrisiStavku(StavkaCenovnika stavka) {
      // TODO: implement
   }
   
   public StavkaCenovnika nadjiStavku(String id) {
      // TODO: implement
      return null;
   }
   
   
   public java.util.Collection<StavkaCenovnika> getStavkaCenovnika() {
      if (stavkaCenovnika == null)
         stavkaCenovnika = new java.util.HashSet<StavkaCenovnika>();
      return stavkaCenovnika;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavkaCenovnika() {
      if (stavkaCenovnika == null)
         stavkaCenovnika = new java.util.HashSet<StavkaCenovnika>();
      return stavkaCenovnika.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavkaCenovnika */
   public void setStavkaCenovnika(java.util.Collection<StavkaCenovnika> newStavkaCenovnika) {
      removeAllStavkaCenovnika();
      for (java.util.Iterator iter = newStavkaCenovnika.iterator(); iter.hasNext();)
         addStavkaCenovnika((StavkaCenovnika)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaCenovnika */
   public void addStavkaCenovnika(StavkaCenovnika newStavkaCenovnika) {
      if (newStavkaCenovnika == null)
         return;
      if (this.stavkaCenovnika == null)
         this.stavkaCenovnika = new java.util.HashSet<StavkaCenovnika>();
      if (!this.stavkaCenovnika.contains(newStavkaCenovnika))
         this.stavkaCenovnika.add(newStavkaCenovnika);
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaCenovnika */
   public void removeStavkaCenovnika(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.stavkaCenovnika != null)
         if (this.stavkaCenovnika.contains(oldStavkaCenovnika))
            this.stavkaCenovnika.remove(oldStavkaCenovnika);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavkaCenovnika() {
      if (stavkaCenovnika != null)
         stavkaCenovnika.clear();
   }

}