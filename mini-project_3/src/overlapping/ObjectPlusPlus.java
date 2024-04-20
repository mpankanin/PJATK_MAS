package overlapping;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public abstract class ObjectPlusPlus extends ObjectPlus implements Serializable {

    //Stores information about all connections of this object
    private Map<String, Map<Object, ObjectPlusPlus>> links = new Hashtable<>();

    //Stores information about all parts connected with any objects
    private static Set<ObjectPlusPlus> allParts = new HashSet<>();

    public ObjectPlusPlus() {
        super();
    }

    private void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier, int counter){
        Map<Object, ObjectPlusPlus> objectLinks;

        //Protection for the reverse connection
        if(counter < 1){
            return;
        }

        //Find a collection of links for the role
        if(links.containsKey(roleName)){
            objectLinks = links.get(roleName);
        }else {
            objectLinks = new HashMap<>();
            links.put(roleName, objectLinks);
        }

        //Check if there is already the connection, if yes, ignore the connection
        if(!objectLinks.containsKey(qualifier)){
            //Add a link for the target object
            objectLinks.put(qualifier, targetObject);

            //Add the reverse connection
            targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier){
        addLink(roleName, reverseRoleName, targetObject, 2);
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject){
        addLink(roleName, reverseRoleName, targetObject);
    }

    public void addPart(String roleName, String reverseRoleName, ObjectPlusPlus partObject) throws Exception {
        //Check if the part exists somewhere
        if(allParts.contains(partObject)) {
            throw new Exception("The part is already connected to a whole");
        }

        addLink(roleName, reverseRoleName, partObject);

        //Store adding the object as a part
        allParts.add(partObject);
    }

    public ObjectPlusPlus[] getLinks(String roleName) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            //No links for the role
            throw new Exception("No links for the role: " + roleName);
        }

        objectLinks = links.get(roleName);
        return (ObjectPlusPlus[]) objectLinks.values().toArray(new ObjectPlusPlus[0]);
    }

    public void showLinks(String roleName, PrintStream stream) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            //No links for the role
            throw new Exception("No links for the role: " + roleName);
        }

        objectLinks = links.get(roleName);
        Collection collection = objectLinks.values();
        stream.println(this.getClass().getSimpleName() + " links, role '" + roleName + "':");

        for(Object object : collection) {
            stream.println("   " + object);
        }
    }

    public ObjectPlusPlus getLinkedObject(String roleName, Object qualifier) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            //No links for the role
            throw new Exception("No links for the role: " + roleName);
        }

        objectLinks = links.get(roleName);
        if(!objectLinks.containsKey(qualifier)) {
            //No link for the qualifier
            throw new Exception("No link for the qualifier: " + qualifier);
        }

        return objectLinks.get(qualifier);
    }

    protected boolean anyLink(String roleName) {
        return links.containsKey(roleName);
    }

}
