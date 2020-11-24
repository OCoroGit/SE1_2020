package org.hbrs.se.ws20.uebung3.persistence;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member>, Serializable {
    FileOutputStream fos = null;
    ObjectOutputStream oos =null;
    ObjectInputStream ois = null;
     FileInputStream fis = null;



    @Override
    public void openConnection() throws PersistenceException {
        try {
            fos = new FileOutputStream("objectsToSave.xml");
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Keine Strategie vorhanden");
        }


    }

    @Override
    public void closeConnection() throws PersistenceException {
        try {
            fos.close();
            oos.close();
        } catch (IOException e) {
           throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Keine Strategie vorhanden");
        }
    }
    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException {
        if(member.size()==0)
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"kann nicht leeres Datei einspeichern");
        try {
            openConnection();
            oos.writeObject(member);
            oos.flush();
            closeConnection();
        } catch (IOException ioe) {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Kann nicht gespeichert werden");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException  {
        List<Member> newListe = null;
         if(!checkData())
           throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Datei nicht vorhanden");

       try {
           fis = new FileInputStream( "objectsToSave.xml" );
           ois = new ObjectInputStream(fis);
           Object obj = ois.readObject();
           newListe = (List) obj;
           fis.close();
           ois.close();

       } catch (IOException | ClassNotFoundException e) {
           throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Datei nicht vorhanden");
       }
        return newListe;
    }
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
        public boolean checkData(){
            File f=new File("objectsToSave.xml");
            return (f.exists() && !f.isDirectory());
        }

}